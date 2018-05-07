package com.sky.api.order;

import com.google.gson.Gson;
import com.sky.api.util.ExpressUtil;
import com.sky.api.util.MemberFreezeUtil;
import com.sky.common.Constants;
import com.sky.common.MsgHelp;
import com.sky.common.bean.StatusBean;
import com.sky.common.massage.ResponseUtil;
import com.sky.common.massage.Status;
import com.sky.common.piting.Pager;
import com.sky.common.profitUtil.JdbcModuleDaoSupport;
import com.sky.common.util.*;
import com.sky.dao.enums.*;
import com.sky.dao.model.*;
import com.sky.dao.shopapi.WarehouseOrder;
import com.sky.dao.vo.*;
import com.sky.service.directsale.*;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.sky.common.massage.ResponseUtil.success;
import static com.sky.dao.express.yto.enums.DataType.json;

/**
 * DoingOrderAction
 *
 * @author dao
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/order", produces = "application/json")
public class DoingOrderAction {
    private static Logger log = Logger.getLogger(DoingOrderAction.class);


    /**
     * 订单服务接口
     */
    @Resource
    DoingOrderService doingOrderService;

    /**
     * 用户地址服务接口
     */
    @Resource
    MemberAddressService memberAddressService;

    /**
     * 产品服务接口
     */
    @Resource
    ProductService productService;

    /**
     * 产品库存服务接口
     */
    @Resource
    private ProductStockService productStockService;


    /**
     * 收益服务接口
     */
    @Resource
    MemberProfitService memberProfitService;

    @Resource
    MemberService memberService;

    /**
     * 获取一条订单对象
     *
     * @return String
     * @throws Exception
     */
    @RequestMapping(value = "/get/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public String get(@PathVariable String orderId, String version, HttpServletRequest req, HttpServletResponse res) throws Exception {
        if (Version.V10.equals(version)) {
            if (StringUtil.isNull(orderId)) {
                return ResponseUtil.error("订单ID为空");
            }

            if (!StringUtil.isUUID(orderId)) {
                return ResponseUtil.error("订单ID错误");
            }

            String moduleId = SessionUtil.getSessionUserInfo().getMemberId();
//            APIOrderBean ub = doingOrderService.getBeanById(orderId, moduleId);
            if (!StringUtil.isNull(null)) {
                return ResponseUtil.data(null);
            } else {
                return ResponseUtil.error("该订单不存在");
            }
        }
        return ResponseUtil.unknownVersion();
    }


    /**
     * 根据订单code获取订单详情
     *
     * @param orderCode
     * @param version
     * @param req
     * @param res
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getOrderByCode/{orderCode}", method = RequestMethod.GET)
    @ResponseBody
    public String getOrderByCode(@PathVariable String orderCode, String version, HttpServletRequest req, HttpServletResponse res) throws Exception {
        if (Version.V10.equals(version)) {
            APIOrderBean ub = doingOrderService.getOrderDetaiByOrderCode(orderCode);
            if (!StringUtil.isNull(ub)) {
                return ResponseUtil.data(ub);
            } else {
                return ResponseUtil.error("该订单不存在");
            }
        }
        return ResponseUtil.unknownVersion();
    }

    /**
     * 订单列表
     *
     * @param pageOffset 页码
     * @param pageSize   页数
     * @param version    接口版本号
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody

    public String list(String username, String pageOffset, String pageSize, Integer orderStatus, String version, HttpServletRequest req, HttpServletResponse res) throws Exception {
        if (Version.V10.equals(version)) {
            if (StringUtil.isNull(pageOffset)) {
                pageOffset = "1";
            }
            if (StringUtil.isNull(pageSize)) {
                pageSize = "15";
            }
            if (StringUtil.isNumeric(pageOffset)) {
                return ResponseUtil.error("分页起始页为数字");
            }

            //缓存获取用户对象bean
            FoodWareHouse user = SessionUtil.getSessionByUserName(username);
            String warehouseMemberId = user.getMemberId();

            Pager<WarehouseOrder> pageData = new Pager<>();
            pageData.setPageOffset(Integer.parseInt(pageOffset));
            pageData.setPageSize(Integer.parseInt(pageSize));
            pageData = doingOrderService.list(warehouseMemberId, orderStatus, pageData);
            return ResponseUtil.data(pageData);
        }
        return ResponseUtil.unknownVersion();
    }

    /**
     * 订单列表
     *
     * @param pageOffset 页码
     * @param pageSize   页数
     * @param version    接口版本号
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/supplyOrderList", method = RequestMethod.GET)
    @ResponseBody
    public String supplyOrderList(String username, String pageOffset, String pageSize, String version, HttpServletRequest req, HttpServletResponse res) throws Exception {
        if (Version.V10.equals(version)) {
            if (StringUtil.isNull(pageOffset)) {
                pageOffset = "1";
            }
            if (StringUtil.isNull(pageSize)) {
                pageSize = "15";
            }
            if (StringUtil.isNumeric(pageOffset)) {
                return ResponseUtil.error("分页起始页为数字");
            }

            //缓存获取用户对象bean
            FoodWareHouse user = SessionUtil.getSessionByUserName(username);
            String memberId = user.getMemberId();

            Pager<ReissueOrder> pageData = new Pager<ReissueOrder>();
            pageData.setPageOffset(Integer.parseInt(pageOffset));
            pageData.setPageSize(Integer.parseInt(pageSize));
            pageData = doingOrderService.supplyOrderList(memberId, pageData);
            return ResponseUtil.data(pageData);
        }
        return ResponseUtil.unknownVersion();
    }


    /**
     * 补货单 撤销单
     *
     * @param version 接口版本号
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/supplyOrderDel", method = RequestMethod.POST)
    @ResponseBody
    public String supplyOrderDel(String username, String orderCode, String version, HttpServletRequest req, HttpServletResponse res) throws Exception {
        if (Version.V10.equals(version)) {
            if (StringUtil.isNull(orderCode)) {
                return ResponseUtil.error("订单未选择");
            }

            //缓存获取用户对象bean
            FoodWareHouse user = SessionUtil.getSessionByUserName(username);
            String memberId = user.getMemberId();

            StatusBean status = doingOrderService.delReissueOrder(memberId, orderCode);
            if (status.getStatus()) {
                return success("撤销订单成功！");
            } else {
                return ResponseUtil.error(status.getMsg());
            }
        }
        return ResponseUtil.unknownVersion();
    }

    /**
     * 补货单 确认收货
     *
     * @param version 接口版本号
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/supplyOrderReceive", method = RequestMethod.POST)
    @ResponseBody
    public String supplyOrderReceive(String username, String orderCode, String version, HttpServletRequest req, HttpServletResponse res) throws Exception {
        if (Version.V10.equals(version)) {
            if (StringUtil.isNull(orderCode)) {
                return ResponseUtil.error("订单未选择");
            }

            //缓存获取用户对象bean
            FoodWareHouse user = SessionUtil.getSessionByUserName(username);
            String memberId = user.getMemberId();

            StatusBean status = doingOrderService.supplyOrderReceive(memberId, orderCode);
            if (status.getStatus()) {
                return success("订单收货确认成功！");
            } else {
                return ResponseUtil.error(status.getMsg());
            }
        }
        return ResponseUtil.unknownVersion();
    }




    /**
     * 补货单支付
     *
     * @param
     * @param
     * @return json格式
     * @throws Exception
     */
    @RequestMapping(value = "/paySupplyOrder", method = RequestMethod.POST)
    @ResponseBody
    public String paySupplyOrder(String orderId, String memberId, Integer totalMoney, String sign, HttpServletRequest req, HttpServletResponse res) throws Exception {
        //验签
        String nowDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String localSign = MD5Util.MD5(orderId + nowDate);

        if (sign.equals(localSign)) {
            //1.查询订单信息
            ReissueOrder reissueOrder = doingOrderService.getReissueById(orderId, memberId);
            if (StringUtil.isNull(reissueOrder)) {
                return ResponseUtil.error("订单不存在");
            }
            if (OrderStatus.WaitPay.getCode() != reissueOrder.getOrderStatus()) {
                return ResponseUtil.error("订单状态必须为“" + OrderStatus.WaitPay.getMsg() + "”");
            }
            if (!totalMoney.equals(reissueOrder.getTotalMoney())) {
                return ResponseUtil.error("订单支付金额错误");
            }
            //判断库存情况
            doingOrderService.getProductStock(orderId, memberId);


            MemberMoneyTotalBean MemberMoneyTotalBean = doingOrderService.getSupplyCoin(memberId);
            if (totalMoney > MemberMoneyTotalBean.getSupplyCoin()) {
                return ResponseUtil.error("余额不足");
            }


            StatusBean status = doingOrderService.paymentReissueOrder(memberId, orderId, totalMoney);
            if (status.getStatus()) {
                return success("支付成功！");
            } else {
                return ResponseUtil.error(status.getMsg());
            }
        }
        return ResponseUtil.error("验签失败");
    }


    /**
     * 补货单下单
     *
     * @param json 订单信息
     * @param req
     * @param res
     * @return json格式
     * @throws Exception
     */
    @RequestMapping(value = "/addsupply", method = RequestMethod.POST)
    @ResponseBody
    public String addhuanhuo(@RequestBody String json, HttpServletRequest req, HttpServletResponse res) throws Exception {

        log.error("换货单创建");
        log.error(" 补货单>>>>>>>>>>json " + json);
        //1、检查参数
        APIAddOrderBean orderBean = null;
        try {
            orderBean = JacksonUtil.fromJson(json, APIAddOrderBean.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (StringUtil.isNull(orderBean)) {
            return ResponseUtil.error("传入的参数错误 ");
        }
        if (orderBean.getProducts().isEmpty()) {
            return ResponseUtil.error("请选择产品");
        }
        //缓存获取用户对象bean
        String username = orderBean.getAddressId();
        FoodWareHouse user = SessionUtil.getSessionByUserName(username);
        String memberId = user.getMemberId();

        //检查是否有 已提交 为审核的单子 ，如果有，返回 亲，还有未审核的订单，暂且不能再次下单
        List<ReissueOrder> list = doingOrderService.getSupplyOrderList(memberId, OrderStatus.WaitPay.getCode());//待付款
        if (list.size() > 0) {
            return ResponseUtil.error("亲，还有未审核的订单，暂且不能再次下单");
        }

        //2、验证地址信息
        String address = String.format("%s@%s@%s@%s", user.getProvince(), user.getCity(), user.getDistrict(), user.getDetail());

        //3、生成订单信息
        String newOrderId = StringUtil.getUUID();
        String newOrderCode = "BHH" + DbUtil.getNewOrderCode(memberId);
        Date curDate = new Date();

        //3.1、封装订单子表
        List<ReissueOrder1> reissueOrder1s = new ArrayList<ReissueOrder1>();
        ReissueOrder1 reissueOrder1;

        //3.2、验证产品信息
        int price = 0, lineTotalPrice = 0, totalPrice = 0;
        ProductDetail productDetail;
        int index = 1;
        long stock = 0;

        for (APIAddOrderProductBean orderProduct : orderBean.getProducts()) {
            if (!StringUtil.isUUID(orderProduct.getProductId())) {
                return ResponseUtil.error("产品ID错误");
            }
            if (orderProduct.getAmount() < 1) {
                return ResponseUtil.error("亲，产品数量错误");
            }
            productDetail = productService.get(orderProduct.getProductId());
            if (StringUtil.isNull(productDetail)) {
                return ResponseUtil.error("产品无效");
            }
            stock = productStockService.getProductStock(productDetail.getProductId());
            if (stock <= 0) {
                return ResponseUtil.error("产品“" + productDetail.getName() + "”无库存");
            }
            if (stock < orderProduct.getAmount()) {
                return ResponseUtil.error("产品“" + productDetail.getName() + "”库存不足");
            }

            price = productDetail.getRetailPrice();
            lineTotalPrice = price * orderProduct.getAmount();
            totalPrice += lineTotalPrice;

            reissueOrder1 = new ReissueOrder1();
            reissueOrder1.setOrder1Id(StringUtil.getUUID());
            reissueOrder1.setOrderId(newOrderId);
            reissueOrder1.setSortIndex(index);
            reissueOrder1.setProductId(orderProduct.getProductId());
            reissueOrder1.setPurchaseQuantity(orderProduct.getAmount());
            reissueOrder1.setShippedQuantity(0);
            reissueOrder1.setPrice(price);
            reissueOrder1.setLineTotal(lineTotalPrice);

            reissueOrder1s.add(reissueOrder1);

            index++;
        }

        //4、设定运费（如果订单的金额大于等于750元，则返回0运费）
        int freight = 0;

        //5、设定总价
        totalPrice = totalPrice + freight; //订单总价=产品总价+运费

        //封装订单主表
        ReissueOrder reissueOrder = new ReissueOrder();
        reissueOrder.setOrderId(newOrderId);
        reissueOrder.setMemberId(memberId);
        reissueOrder.setOrderCode(newOrderCode);
        reissueOrder.setOrderStatus(OrderStatus.WaitPay.getCode()); //待付款
        reissueOrder.setContact(user.getContact());

        reissueOrder.setPhone(user.getPhone());
        reissueOrder.setAddress(address);
        reissueOrder.setZipcode("0");//邮编
        reissueOrder.setTotalMoney(totalPrice);
        reissueOrder.setFreight(freight);

        reissueOrder.setOrderFrom(orderBean.getOrderFrom());
        reissueOrder.setBuyerRemark(orderBean.getRemark());
        reissueOrder.setIsProfit(0);
        reissueOrder.setCreateDate(curDate);
        reissueOrder.setDeleteFlag(0);
        reissueOrder.setMemberType(0);
        reissueOrder.setPayType(orderBean.getPayType());
        reissueOrder.setOrderType(OrderTypeEnum.SUPPLY.getCode());

        StatusBean status = doingOrderService.addHuanhuo(reissueOrder, reissueOrder1s);
        if (status.getStatus()) {
            APIOrderIdBean orderIdBean = new APIOrderIdBean();
            orderIdBean.setOrderId(newOrderId);
            orderIdBean.setOrderCode(newOrderCode);
            orderIdBean.setTotalMoney(totalPrice);
            return ResponseUtil.data(orderIdBean, "订单已提交");
        } else {
            return ResponseUtil.error(status.getMsg());
        }
    }


    /**
     * 根据订单code获取订单详情
     *
     * @param
     * @param
     * @param req
     * @param res
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/scanner", method = RequestMethod.POST)
    @ResponseBody
    public String scanner(String erCode, String username, HttpServletRequest req, HttpServletResponse res) throws Exception {

        //缓存获取用户对象bean
        FoodWareHouse user = SessionUtil.getSessionByUserName(username);
        String warehouseMemberId = user.getMemberId();

        //取二维码数据 String erCode = sign@ordermemberId@orderCode;
        String[] erCodeArray = erCode.split("@");
        String sign = erCodeArray[0];
        String orderMemberId = erCodeArray[1];
        String orderCode = erCodeArray[2];
        log.error("sign>>>>>>" + sign);
        log.error("orderMemberId>>>>>>" + orderMemberId);
        log.error("orderCode>>>>>>" + orderCode);
        //验签
        String nowDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String localSign = MD5Util.MD5(orderCode + nowDate);
        if (sign.equals(localSign)) {
            //更新 member_total_money   food_coin减去  supply_coin 加上
            //更新doingorder
            StatusBean status = doingOrderService.updateMoneyAndOrder(warehouseMemberId, orderMemberId, orderCode);
            if (status.getStatus()) {
                return new Gson().toJson(status);
            } else {
                return ResponseUtil.error(status.getMsg());
            }
        } else {
            return ResponseUtil.error("验签失败");
        }

    }

    /**
     * 根据订单code获取订单详情
     *
     * @param
     * @param
     * @param req
     * @param res
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/scannerTest", method = RequestMethod.POST)
    @ResponseBody
    public String scanner(String orderMemberId, String orderCode, String username, HttpServletRequest req, HttpServletResponse res) throws Exception {

        //缓存获取用户对象bean
        FoodWareHouse user = SessionUtil.getSessionByUserName(username);
        String memberId = user.getMemberId();

        //更新 member_total_money   food_coin减去  supply_coin 加上
        //更新doingorder
        StatusBean status = doingOrderService.updateMoneyAndOrder(memberId, orderMemberId, orderCode);
        if (status.getStatus()) {
            return new Gson().toJson(status);
        } else {
            return ResponseUtil.error(status.getMsg());
        }
    }


    public static void main(String[] args) {


        //验签
        String nowDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String localSign = MD5Util.MD5("1541523381001137" + nowDate);

        System.out.println(">>>>> " + localSign);
    }
}

















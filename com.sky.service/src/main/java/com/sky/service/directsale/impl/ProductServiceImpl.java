package com.sky.service.directsale.impl;

import com.sky.common.Constants;
import com.sky.common.bean.StatusBean;
import com.sky.common.piting.Pager;
import com.sky.common.service.impl.BaseServiceImpl;
import com.sky.common.util.*;
import com.sky.dao.enums.DataBaseType;
import com.sky.dao.enums.TeamFlag;
import com.sky.dao.model.ProductDetail;
import com.sky.dao.vo.FWCodeRedisBean;
import com.sky.dao.vo.MemberBean;
import com.sky.dao.vo.ProductBean;
import com.sky.service.directsale.ProductService;
import com.sky.service.directsale.ProductStockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能：
 * 1、实现根据商品分类查询商品（分页）
 * 2、实现查询商品详情
 *
 * @author xiaoheliu
 * @version 1.0
 * @since 2015-10-20
 **/
@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl implements ProductService {

    @Resource
    private ProductStockService productStockService;

    //升级套餐的分类id
    private static  final String UP_CATEGORY_ID="a99dc47fafd44818843ab676d3e75c1c";
    //新零售的 金卡 升级套餐
    private static  final String XLS_GOLD_UP_CROWN_1="722591ef172f4056a63f87dcadac6ca7";
    private static  final String XLS_GOLD_UP_CROWN_2="c42a9f0a62b44ad0b4ed366fb12c8684";
    private static  final String XLS_GOLD_UP_CENTER_1="16ae0cd6bb2848dc83ecf67ced1be8f8";
    private static  final String XLS_GOLD_UP_CENTER_2="6042f2595a7f4e73b0885717ed1a1105";
    //海葵的金卡 升级套餐
    private static  final String HK_GOLD_UP_CROWN_1="";
    private static  final String HK_GOLD_UP_CROWN_2="";
    private static  final String HK_GOLD_UP_CENTER_1="";
    private static  final String HK_GOLD_UP_CENTER_2="";
    //所有权限的产品
    private static  final String ALL="all";


    @Override
    public int count(String categoryId) throws Exception {
        StringBuffer paginationSQL = new StringBuffer();
        paginationSQL.append("select count(*) from product where 1=1 ");
        paginationSQL.append(" and category_id='" + categoryId + "'");
        return JdbcModuleDaoSupport2.count(DataBaseType.BASE_DATA, paginationSQL.toString(), null, DbUtil.getMod4DbRandom());
    }

    @Override
    public Pager<ProductBean> list(String categoryId, Pager<ProductBean> page, String phone) throws Exception {
        ProductBean bean = new ProductBean();
        bean.setCategoryId(categoryId);
        StringBuffer paginationSQL = new StringBuffer();
        paginationSQL.append("select p.product_id, p.category_id, p.name, p.short_name, p.brand,p.sales, p.retail_price, p.market_price,p.is_profit,p.team_flag,pi.thumb_url, 1 as hiddenFlag");
        paginationSQL.append(" from product p left join product_image pi on p.product_id=pi.product_id where 1=1 and p.delete_flag = 0 and p.category_id =:categoryId and p.product_type= 0 and p.status = 0 order by sort_index");
        //此处无法实现 团队包含模式的 分页  2018-03-20 张杰
        //paginationSQL.append(" limit " + (page.getPageOffset() - 1) * page.getPageSize() + "," + page.getPageSize() + "");
        List<ProductBean> datas = JdbcModuleDaoSupport2.getList(DataBaseType.BASE_DATA, paginationSQL.toString(), bean, DbUtil.getMod4DbRandom());

        if (!StringUtil.isNull(datas) && datas.size() > 0) {
            for (int i = 0; i < datas.size(); i++) {
                bean = datas.get(i);
                bean.setStock(productStockService.getProductStock(bean.getProductId()));
            }
            //团队的处理  新
            this.productListTeamHandelNew(categoryId,datas,phone);

        } else {
            datas = new ArrayList<ProductBean>();
        }

        //分页 截取
        int totalRows = datas.size();
        int offSet=(page.getPageOffset() - 1) * page.getPageSize();
        int endSet=offSet+ page.getPageSize();
        //防越界
        datas =datas.size()>endSet?datas.subList(offSet,endSet):datas.subList(offSet,datas.size());

        page.setDatas(datas);

        //int totalRows = this.count(categoryId);
        page.setTotalRecord(totalRows);
        page.setTotalPage(totalRows);
        return page;
    }

    private void productListTeamHandel(String categoryId, List<ProductBean> datas, String phone) {
        try {
            if(!categoryId.equals("3765aba998b749149a2a4dcccae6a4ca")
                &&!categoryId.equals("3c4b5c23b8c94307a112ea88650cf538")
                &&!categoryId.equals("8a1330bdfa884b3388ab808f4930cea3")
                &&!categoryId.equals("823c9cb575f34307b3df5f6038bfc6c3")){
                return ;  //只有  加盟类 需要处理(金卡套餐 钻卡套餐 白金卡套餐 升级套餐)
            }
            //系统账号 权限组别豁免  2018-01-12 张杰
            if("18612341234".equals(phone)||(phone!=null&&phone.startsWith("1860002000"))){
                return;
            }
            //获取会员信息
            MemberBean memberBean= SessionUtil.getSessionMemberId(phone);//通过手机号获取redis
            if(memberBean==null){
                String sql="SELECT * FROM member WHERE phone='"+phone+"'AND delete_flag=0 limit 1";
                memberBean= JdbcTemplateDaoSupport.getObjectDateInfo(sql, new MemberBean());
            }
            //
            //todo 根据营销政策  所有代KL的为 老新零售会员专享  其余的为共赢专享
            List<ProductBean> listKL=new ArrayList<>(); //所有KL的集合

            if(memberBean!=null){
                for (ProductBean p:datas) {
                    if(p.getName().contains("KL")){
                        listKL.add(p);
                    }
                }
            }
            // 与共赢国际的区分
            if(memberBean.getTeamFlag()== TeamFlag.GY){
                datas.removeAll(listKL);
            }else {
                datas.clear();
                datas.addAll(listKL);
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error("数据异常------"+e.getCause());
        }
    }

    //最新的 产品定义 根据 TeamFLag定义权限
    private void productListTeamHandelNew(String categoryId, List<ProductBean> datas, String phone) {
        // TODO: 2018/1/13 0013 teamFlag 定义为一个 逗号拆分的数据 定义他确定的权限 或者 用 all代表全部
        try {

            String teamFlag="";
            //系统账号 权限组别豁免  2018-01-12 张杰
            if("18612341234".equals(phone)||(phone!=null&&phone.startsWith("1860002000"))){
                return;
            }

            //获取会员信息
            MemberBean memberBean= SessionUtil.getSessionMemberId(phone);//通过手机号获取redis
            if(memberBean==null){
                String sql="SELECT m.team_flag FROM member m WHERE phone='"+phone+"'AND delete_flag=0 limit 1";
                memberBean= JdbcTemplateDaoSupport.getObjectDateInfo(sql, new MemberBean());
            }
            //根据权限获取到的产品集合
            List<ProductBean> list =new ArrayList<>();
            for(ProductBean p:datas){
                //冗余数据清除
                teamFlag=p.getTeamFlag().contains(ALL)?ALL:p.getTeamFlag();
                //代表这个产品 所有团队 都拥有权限
                if(teamFlag.equals(ALL)){
                    list.add(p);
                }else {
                    List<Integer> teamFlagList=getProductTeamFlagList(teamFlag) ;
                    if(teamFlagList.contains(memberBean.getTeamFlag())){
                        list.add(p);
                    }
                }
            }
            datas.clear();
            datas.addAll(list);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("数据异常------"+e.getCause());
        }
    }

    private List<Integer> getProductTeamFlagList(String teamFlag) {
        List<Integer> teamFlagList=new ArrayList<>();

        try {
            String[]arr=teamFlag.split(",");
            for(int i=0;i<arr.length;i++){
                teamFlagList.add(Integer.parseInt(arr[i]));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return teamFlagList;
    }

    @Override
    public ProductDetail get(String productId) {
        ProductDetail productDetail = new ProductDetail();
        StringBuffer sql = new StringBuffer();
        sql.append("select p.category_id, p.product_id, p.type, p.name,p.team_flag,p.short_name, p.size,p.discount_rate,p.shop_flag, p.brand,p.sales, p.desc, p.details, p.remark, p.retail_price, p.market_price, p.is_profit ,p.member_type,p.group_id,p.pv, " +
                "pi.thumb_url, pi.bannel_thumb1, pi.bannel_thumb2, pi.bannel_thumb3, pi.bannel_thumb4, pi.bannel_thumb5, pi.banner_image1, pi.banner_image2, pi.banner_image3, pi.banner_image4, pi.banner_image5 " +
                "from product p left join product_image pi on p.product_id = pi.product_id where 1=1 AND p.delete_flag=0");
        sql.append(" and p.product_id = '" + productId + "'");
        productDetail = JdbcModuleDaoSupport2.getObjectDateInfo(DataBaseType.BASE_DATA, sql.toString(), productDetail, DbUtil.getMod4DbRandom());
        if (StringUtil.isNull(productDetail))
            return null;

        productDetail.setStock(productStockService.getProductStock(productId));
        return productDetail;
    }

    @Override
    public ProductDetail getFromFW(String productId) {
        ProductDetail productDetail = new ProductDetail();
        StringBuffer sql = new StringBuffer();
        sql.append("select p.category_id, p.product_id, p.name, p.short_name, p.size, p.brand, p.sales,p.desc, p.details, p.remark,");
        sql.append(" p.retail_price, p.market_price, p.member_type,p.group_id, pi.thumb_url, pi.bannel_thumb1, pi.bannel_thumb2,");
        sql.append(" pi.bannel_thumb3, pi.bannel_thumb4, pi.bannel_thumb5, pi.banner_image1, pi.banner_image2, pi.banner_image3, ");
        sql.append(" pi.banner_image4, pi.banner_image5 from product p left join product_image pi on p.product_id = pi.product_id ");
        sql.append(" where 1=1 AND p.delete_flag=0");
        sql.append(" and p.product_id = '" + productId + "'");
        productDetail = JdbcModuleDaoSupport2.getObjectDateInfo(DataBaseType.FW_DATA, sql.toString(), productDetail, DbUtil.getBaseModule());
        if (StringUtil.isNull(productDetail))
            return null;
        return productDetail;
    }

    @Override
    public ProductBean getByProductId(String productId) throws Exception {
        ProductBean productBean = new ProductBean();
        StringBuffer sql = new StringBuffer();
        sql.append("select p.category_id, p.product_id, p.name, p.short_name, p.sales,p.brand, p.desc, p.details, p.remark, p.retail_price, p.market_price, pi.thumb_url from product p left join product_image pi on p.product_id = pi.product_id");
        sql.append(" where p.product_id = '" + productId + "'");
        productBean = JdbcModuleDaoSupport2.getObjectDateInfo(DataBaseType.BASE_DATA, sql.toString(), productBean, DbUtil.getMod4DbRandom());
        if(StringUtil.isNull(productBean)){
        	productBean = new ProductBean();
        }
        productBean.setDetails("");
        productBean.setStock(0);
        return productBean;
    }

    public boolean InitProductStock(Integer stock){
        String sql="select * from product where delete_flag=0";
        List<ProductBean> list= JdbcModuleDaoSupport2.getList(DataBaseType.BASE_DATA,sql,new ProductBean(),"00");
        for (ProductBean productBean : list) {
            log.fatal("刷新了产品库存redis：" + productBean.getName() + ";原库存：" + productBean.getInventory());
            productStockService.setProductStock(productBean.getProductId(),stock);
        }
        return true;
    }


    public StatusBean InitFWCode(){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from (");
         for (int i=0; i<32 ; i++){
             String tableName = "fw_code_";
             if (i < 10)
             {
                 tableName = tableName + "0" + i;
             }
             else
             {
                 tableName = tableName + i;
             }
             sql.append("SELECT * FROM ");
             sql.append(tableName);
             if (i != 31)
             {
                 sql.append(" union ");
             }
         }
        sql.append(")T ");
        List<FWCodeRedisBean> list= JdbcModuleDaoSupport2.getList(DataBaseType.FW_DATA,sql.toString(),new FWCodeRedisBean(), DbUtil.getBaseModule());
        for (FWCodeRedisBean fwCodeBean : list) {
            fwCodeBean.setCodeTypeStr("盒码");
            /*把防伪信息存入redis*/
            String json = JacksonUtil.toJson(fwCodeBean);
            SessionUtil.setSessionStringNotPreKey(Constants.FW_CODE + fwCodeBean.getbCode(), json);
            SessionUtil.incrementLongValueInit(Constants.FW_CODE_COUNT + fwCodeBean.getbCode(), 1);
            if (!StringUtil.isNull(fwCodeBean.getxCode())){
                fwCodeBean.setCodeTypeStr("箱码");
                String xjson = JacksonUtil.toJson(fwCodeBean);
                SessionUtil.setSessionStringNotPreKey(Constants.FW_CODE + fwCodeBean.getxCode(), xjson);
                SessionUtil.incrementLongValueInit(Constants.FW_CODE_COUNT + fwCodeBean.getxCode(), 1);
            }
        }
        return new StatusBean(true,"初始化fw成功,数量："+list.size());
    }
}

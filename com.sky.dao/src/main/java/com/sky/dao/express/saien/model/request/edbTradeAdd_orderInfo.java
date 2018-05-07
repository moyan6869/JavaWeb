package com.sky.dao.express.saien.model.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by Administrator on 2015/12/24.
 */

@XStreamAlias("orderInfo")
public class edbTradeAdd_orderInfo {
    private String tid;//订单编号
    private String out_tid;//	外部平台单号
    private String shop_id;//	店铺编号（E店宝中档案管理—基本档案—店铺设置查看）
    private int storage_id;//仓库编码（E店宝中档案管理—仓库档案—仓库设置查看）
    private String buyer_id;//买家ID
    private String buyer_msg;//	买家留言
    private String buyer_email;//	买家邮件地址
    private String buyer_alipay;//	买家支付宝账号
    private String seller_remark;//	客服备注
    private String consignee;//	收货人姓名
    private String address;//	收货地址
    private String postcode;//	收货人邮编
    private String telephone;//	联系电话
    private String mobilPhone;//	联系手机
    private String privince;//	收货人省份
    private String city;//	收货人城市
    private String area;//	收货人地区
    private double actual_freight_get;//	实收运费
    private double actual_RP;//实收参考价
    private String ship_method;//	配送方式
    private String express="韵达";//	快递公司名（（E店宝中档案管理—仓库档案—快递公司设置查看））   修改：2016-01-19 10:30 赛恩技术要求快递必填《韵达》
    private int is_invoiceOpened = 0;//	开票情况(是否已开发票0：无1：有)默认0
    private String invoice_type;//	发票类型
    private double invoice_money;//		开票金额
    private String invoice_title;//		发票抬头
    private String invoice_msg;//		发票内容
    private String order_type = "正常订单";//		订单类型（等货订单囤货订单换货订单其他订单预售订单正常订单中断订单）默认：正常订单
    private String process_status = "未确认";//		处理状态（未确认已财务审核已归档已确认已作废）默认：未确认
    private String pay_status = "未付款";//		付款状态（待退款部分退款待退款全部退款待退款所有交易关闭未付款已付款已退款部分退款已退款全部退款已退款所有）默认：未付款
    private String deliver_status = "未发货";//		发货状态（待退货部分退货待退货全部退货待退货所有退货到货部分退货退货到货全部退货退货到货所有未发货已发货）默认：未发货
    private int is_COD;//是否货到付款
    private double serverCost_COD;//货到付款服务费
    private double order_totalMoney;//	订单总金额
    private double product_totalMoney;//	产品总金额
    private String pay_method;//	支付方式
    private double pay_commission;//	支付佣金
    private int pay_score;//支付积分
    private int return_score;//	返点积分
    private double favorable_money;//	优惠金额
    private String alipay_transaction_no;//		支付宝交易号
    private String out_payNo;//		外部平台付款单号
    private String out_express_method;//	外部平台快递方式
    private String out_order_status;//	外部平台快递订单状态
    private String order_date;//订货日期
    private String pay_date;//付款日期
    private String finish_date;//
    private String plat_type;//平台类型
    private String distributor_no;//分销商编号
    private String WuLiu;//	物流公司
    private String WuLiu_no;//物流单号
    private String in_memo;//内部便签
    private String other_remark;//其他备注
    private double actual_freight_pay;//实付运费
    private String ship_date_plan;//预配货日期
    private String deliver_date_plan;//预计发货日期
    private int is_scorePay = 0;//是否积分换购（0：不是1：是）默认：0
    private int is_needInvoice = 0;//是否需要开发票（0：不需要1：需要）默认0

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getOut_tid() {
        return out_tid;
    }

    public void setOut_tid(String out_tid) {
        this.out_tid = out_tid;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public int getStorage_id() {
        return storage_id;
    }

    public void setStorage_id(int storage_id) {
        this.storage_id = storage_id;
    }

    public String getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(String buyer_id) {
        this.buyer_id = buyer_id;
    }

    public String getBuyer_msg() {
        return buyer_msg;
    }

    public void setBuyer_msg(String buyer_msg) {
        this.buyer_msg = buyer_msg;
    }

    public String getBuyer_email() {
        return buyer_email;
    }

    public void setBuyer_email(String buyer_email) {
        this.buyer_email = buyer_email;
    }

    public String getBuyer_alipay() {
        return buyer_alipay;
    }

    public void setBuyer_alipay(String buyer_alipay) {
        this.buyer_alipay = buyer_alipay;
    }

    public String getSeller_remark() {
        return seller_remark;
    }

    public void setSeller_remark(String seller_remark) {
        this.seller_remark = seller_remark;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobilPhone() {
        return mobilPhone;
    }

    public void setMobilPhone(String mobilPhone) {
        this.mobilPhone = mobilPhone;
    }

    public String getPrivince() {
        return privince;
    }

    public void setPrivince(String privince) {
        this.privince = privince;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public double getActual_freight_get() {
        return actual_freight_get;
    }

    public void setActual_freight_get(double actual_freight_get) {
        this.actual_freight_get = actual_freight_get;
    }

    public double getActual_RP() {
        return actual_RP;
    }

    public void setActual_RP(double actual_RP) {
        this.actual_RP = actual_RP;
    }

    public String getShip_method() {
        return ship_method;
    }

    public void setShip_method(String ship_method) {
        this.ship_method = ship_method;
    }

    public String getExpress() {
        return express;
    }

    public void setExpress(String express) {
        this.express = express;
    }

    public int getIs_invoiceOpened() {
        return is_invoiceOpened;
    }

    public void setIs_invoiceOpened(int is_invoiceOpened) {
        this.is_invoiceOpened = is_invoiceOpened;
    }

    public String getInvoice_type() {
        return invoice_type;
    }

    public void setInvoice_type(String invoice_type) {
        this.invoice_type = invoice_type;
    }

    public double getInvoice_money() {
        return invoice_money;
    }

    public void setInvoice_money(double invoice_money) {
        this.invoice_money = invoice_money;
    }

    public String getInvoice_title() {
        return invoice_title;
    }

    public void setInvoice_title(String invoice_title) {
        this.invoice_title = invoice_title;
    }

    public String getInvoice_msg() {
        return invoice_msg;
    }

    public void setInvoice_msg(String invoice_msg) {
        this.invoice_msg = invoice_msg;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getProcess_status() {
        return process_status;
    }

    public void setProcess_status(String process_status) {
        this.process_status = process_status;
    }

    public String getPay_status() {
        return pay_status;
    }

    public void setPay_status(String pay_status) {
        this.pay_status = pay_status;
    }

    public String getDeliver_status() {
        return deliver_status;
    }

    public void setDeliver_status(String deliver_status) {
        this.deliver_status = deliver_status;
    }

    public int getIs_COD() {
        return is_COD;
    }

    public void setIs_COD(int is_COD) {
        this.is_COD = is_COD;
    }

    public double getServerCost_COD() {
        return serverCost_COD;
    }

    public void setServerCost_COD(double serverCost_COD) {
        this.serverCost_COD = serverCost_COD;
    }

    public double getOrder_totalMoney() {
        return order_totalMoney;
    }

    public void setOrder_totalMoney(double order_totalMoney) {
        this.order_totalMoney = order_totalMoney;
    }

    public double getProduct_totalMoney() {
        return product_totalMoney;
    }

    public void setProduct_totalMoney(double product_totalMoney) {
        this.product_totalMoney = product_totalMoney;
    }

    public String getPay_method() {
        return pay_method;
    }

    public void setPay_method(String pay_method) {
        this.pay_method = pay_method;
    }

    public double getPay_commission() {
        return pay_commission;
    }

    public void setPay_commission(double pay_commission) {
        this.pay_commission = pay_commission;
    }

    public int getPay_score() {
        return pay_score;
    }

    public void setPay_score(int pay_score) {
        this.pay_score = pay_score;
    }

    public int getReturn_score() {
        return return_score;
    }

    public void setReturn_score(int return_score) {
        this.return_score = return_score;
    }

    public double getFavorable_money() {
        return favorable_money;
    }

    public void setFavorable_money(double favorable_money) {
        this.favorable_money = favorable_money;
    }

    public String getAlipay_transaction_no() {
        return alipay_transaction_no;
    }

    public void setAlipay_transaction_no(String alipay_transaction_no) {
        this.alipay_transaction_no = alipay_transaction_no;
    }

    public String getOut_payNo() {
        return out_payNo;
    }

    public void setOut_payNo(String out_payNo) {
        this.out_payNo = out_payNo;
    }

    public String getOut_express_method() {
        return out_express_method;
    }

    public void setOut_express_method(String out_express_method) {
        this.out_express_method = out_express_method;
    }

    public String getOut_order_status() {
        return out_order_status;
    }

    public void setOut_order_status(String out_order_status) {
        this.out_order_status = out_order_status;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getPay_date() {
        return pay_date;
    }

    public void setPay_date(String pay_date) {
        this.pay_date = pay_date;
    }

    public String getFinish_date() {
        return finish_date;
    }

    public void setFinish_date(String finish_date) {
        this.finish_date = finish_date;
    }

    public String getPlat_type() {
        return plat_type;
    }

    public void setPlat_type(String plat_type) {
        this.plat_type = plat_type;
    }

    public String getDistributor_no() {
        return distributor_no;
    }

    public void setDistributor_no(String distributor_no) {
        this.distributor_no = distributor_no;
    }

    public String getWuLiu() {
        return WuLiu;
    }

    public void setWuLiu(String wuLiu) {
        WuLiu = wuLiu;
    }

    public String getWuLiu_no() {
        return WuLiu_no;
    }

    public void setWuLiu_no(String wuLiu_no) {
        WuLiu_no = wuLiu_no;
    }

    public String getIn_memo() {
        return in_memo;
    }

    public void setIn_memo(String in_memo) {
        this.in_memo = in_memo;
    }

    public String getOther_remark() {
        return other_remark;
    }

    public void setOther_remark(String other_remark) {
        this.other_remark = other_remark;
    }

    public double getActual_freight_pay() {
        return actual_freight_pay;
    }

    public void setActual_freight_pay(double actual_freight_pay) {
        this.actual_freight_pay = actual_freight_pay;
    }

    public String getShip_date_plan() {
        return ship_date_plan;
    }

    public void setShip_date_plan(String ship_date_plan) {
        this.ship_date_plan = ship_date_plan;
    }

    public String getDeliver_date_plan() {
        return deliver_date_plan;
    }

    public void setDeliver_date_plan(String deliver_date_plan) {
        this.deliver_date_plan = deliver_date_plan;
    }

    public int getIs_scorePay() {
        return is_scorePay;
    }

    public void setIs_scorePay(int is_scorePay) {
        this.is_scorePay = is_scorePay;
    }

    public int getIs_needInvoice() {
        return is_needInvoice;
    }

    public void setIs_needInvoice(int is_needInvoice) {
        this.is_needInvoice = is_needInvoice;
    }
}

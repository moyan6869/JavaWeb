package com.sky.dao.express.saien.model.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by Administrator on 2015/12/24.
 */

@XStreamAlias("product_item")
public class edbTradeAdd_product_item {
    private String barCode;//条形码（子表）
    private String product_title;//网店品名（子表）
    private String standard;//网店规格（子表）
    private double out_price;//外部单价（子表）
    private double favorite_money;//优惠金额（子表）
    private int orderGoods_Num;//订货数量（子表）
    private int gift_Num;//赠品数量（子表）
    private double cost_Price;//成交单价（子表）
    private String tid;//订单编号（子表）
    private String product_stockout;//产品缺货情况（子表）
    private int is_Book = 0;//是否预订（0：否1：是）默认：0（子表）
    private int is_presell;//是否预售（子表）
    private int is_Gift = 0;//是否赠品（0：否1：是）默认：0（子表）
    private double avg_price;//加权平均单价（子表）
    private double product_freight;//产品运费（子表）
    private String shop_id;//店铺编号（子表）
    private String out_tid;//外部平台单号（子表）
    private String out_productId;//外部平台产品Id（子表）
    private String out_barCode;//外部平台条形码（子表）
    private String product_intro;//产品简介（子表）

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getProduct_title() {
        return product_title;
    }

    public void setProduct_title(String product_title) {
        this.product_title = product_title;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public double getOut_price() {
        return out_price;
    }

    public void setOut_price(double out_price) {
        this.out_price = out_price;
    }

    public double getFavorite_money() {
        return favorite_money;
    }

    public void setFavorite_money(double favorite_money) {
        this.favorite_money = favorite_money;
    }

    public int getOrderGoods_Num() {
        return orderGoods_Num;
    }

    public void setOrderGoods_Num(int orderGoods_Num) {
        this.orderGoods_Num = orderGoods_Num;
    }

    public int getGift_Num() {
        return gift_Num;
    }

    public void setGift_Num(int gift_Num) {
        this.gift_Num = gift_Num;
    }

    public double getCost_Price() {
        return cost_Price;
    }

    public void setCost_Price(double cost_Price) {
        this.cost_Price = cost_Price;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getProduct_stockout() {
        return product_stockout;
    }

    public void setProduct_stockout(String product_stockout) {
        this.product_stockout = product_stockout;
    }

    public int getIs_Book() {
        return is_Book;
    }

    public void setIs_Book(int is_Book) {
        this.is_Book = is_Book;
    }

    public int getIs_presell() {
        return is_presell;
    }

    public void setIs_presell(int is_presell) {
        this.is_presell = is_presell;
    }

    public int getIs_Gift() {
        return is_Gift;
    }

    public void setIs_Gift(int is_Gift) {
        this.is_Gift = is_Gift;
    }

    public double getAvg_price() {
        return avg_price;
    }

    public void setAvg_price(double avg_price) {
        this.avg_price = avg_price;
    }

    public double getProduct_freight() {
        return product_freight;
    }

    public void setProduct_freight(double product_freight) {
        this.product_freight = product_freight;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public String getOut_tid() {
        return out_tid;
    }

    public void setOut_tid(String out_tid) {
        this.out_tid = out_tid;
    }

    public String getOut_productId() {
        return out_productId;
    }

    public void setOut_productId(String out_productId) {
        this.out_productId = out_productId;
    }

    public String getOut_barCode() {
        return out_barCode;
    }

    public void setOut_barCode(String out_barCode) {
        this.out_barCode = out_barCode;
    }

    public String getProduct_intro() {
        return product_intro;
    }

    public void setProduct_intro(String product_intro) {
        this.product_intro = product_intro;
    }
}

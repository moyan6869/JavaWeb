package com.sky.dao.vo;

import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * Created by weiyunliang on 2017/7/11.
 */
public class HomepageBean {
    private int pageOffset; //当前的页数
    private int pageSize; //一页显示多少条
    private long totalRecord; //总记录数
    private int totalPage; //总页数
    private List<BannerBean> banner;//轮播图
    private List<BuylimitBean> buylimit;//限时抢购
    private List<LuckIndianaProduct> luck;//幸运夺宝

    public List<ProductHotBean> getProductHot() {
        return productHot;
    }

    public void setProductHot(List<ProductHotBean> productHot) {
        this.productHot = productHot;
    }

    private List<ProductHotBean> productHot;//超值热卖

    public int getPageOffset() {
        return pageOffset;
    }

    public void setPageOffset(int pageOffset) {
        this.pageOffset = pageOffset;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<BannerBean> getBanner() {
        return banner;
    }

    public void setBanner(List<BannerBean> banner) {
        this.banner = banner;
    }

    public List<BuylimitBean> getBuylimit() {
        return buylimit;
    }

    public void setBuylimit(List<BuylimitBean> buylimit) {
        this.buylimit = buylimit;
    }

    public List<LuckIndianaProduct> getLuck() {
        return luck;
    }

    public void setLuck(List<LuckIndianaProduct> luck) {
        this.luck = luck;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        if (totalPage % pageSize == 0) {
            this.totalPage = totalPage / pageSize;
        } else {
            this.totalPage = (totalPage / pageSize) + 1;
        }
    }
}

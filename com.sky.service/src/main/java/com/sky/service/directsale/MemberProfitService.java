package com.sky.service.directsale;

import com.sky.common.bean.StatusBean;
import com.sky.common.piting.Pager;
import com.sky.dao.model.*;
import com.sky.dao.shopapi.CoinBalanceBean;

/**
 * MemberProfitService
 *
 * @author dao
 **/
public interface MemberProfitService {


    /**
     * 查询总数量
     *
     * @param memberId
     * @return
     * @throws Exception
     */
    public int count(String memberId) throws Exception;

    /**
     * 查询所有数据
     *
     * @param memberId 查询条件
     * @return List<MemberBean> 查询后返回的结果集
     * @throws Exception
     **/
    public Pager<MemberFreezeBean> list(String memberId, Pager<MemberFreezeBean> pageData) throws Exception;

    /**
     * 补货币 流水记录 查询
     * @param memberId
     * @param pageData
     * @return
     * @throws Exception
     */
    public Pager<CoinBalanceBean> getSupplyCoinList(String memberId, Pager<CoinBalanceBean> pageData) throws Exception;


    public StatusBean<?> tansferSupplyCoin(String inMemberId, String outMemberId, long coin) throws Exception;






//   查询复消币换货币币种
    public CoinlistBean coinlist(String memberId, CoinlistBean pageData) throws Exception;
    //   查询复消币换货币币种添加记录
    public Pager<CoinaddBean> coinaddlist(String memberId, Pager<CoinaddBean> pageData) throws Exception;
    //   查询复消币换货币币种使用记录
    public Pager<CoinuseBean> coinuselist(String memberId, Pager<CoinuseBean> pageData) throws Exception;

    /**
     * 获取用户的收益
     *
     * @param memberId
     * @return
     */
    public APIUserProfitBean getUserProfit(String memberId) throws Exception;



    /**
     * 获取用户的返本基金
     * @param memberId
     * @return
     */
    public APIMemberLimitLogBean getMemberLimitLog(String memberId) throws Exception;


    public Long getSupplyCoin (String memberId);
}

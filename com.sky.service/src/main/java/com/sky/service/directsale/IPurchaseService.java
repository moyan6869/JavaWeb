package com.sky.service.directsale;

import com.sky.common.bean.StatusBean;
import com.sky.common.piting.Pager;
import com.sky.dao.vo.DoingPayOneVo;
import com.sky.dao.vo.LuckIndianaBuyrecord;
import com.sky.dao.vo.LuckIndianaProduct;
import com.sky.dao.vo.RecordDetail;

import java.util.List;

/**
 * Created by Administrator on 2017/4/20 0020.
 */
public interface IPurchaseService {

    public List<LuckIndianaProduct> getActivities();

    public LuckIndianaProduct getActivity(String productId, String luckId, int mount);

    public Pager<LuckIndianaBuyrecord> getActivityRecord(String memberId, String productId, int pageOffset, int pageSize);

    public RecordDetail getrecorddetail(String memberId, String recordId);

    public Pager<LuckIndianaBuyrecord> getMyActivityRecord(String memberId, int pageOffset, int pageSize);


    public LuckIndianaProduct buyOrNot(String memberId, String productId, int mount, int consumeQuantity);

    public LuckIndianaProduct payOne(String memberId, String luckId, String productId, int mount, int totalMoney, int consumeQuantity);

    public boolean acceptPrize(String buyId, String orderCode, String contact, String phone, String address);

    /**
     * 一元夺宝余额支付（短信验证码+支付密码+订单Id）
     * @param bean
     * @return
     * @throws Exception
     */
    public StatusBean payTwo(final DoingPayOneVo bean, String luckId, String productId, int mount, int totalMoney, int consumeQuantity, String buyId) throws Exception;


    public StatusBean payDBOrder(String buyId, int payMoney, int payType, String tr);
}

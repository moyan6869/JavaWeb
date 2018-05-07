package com.sky.api.util;

import java.util.Date;

import com.sky.common.bean.StatusBean;
import com.sky.common.util.StringUtil;
import com.sky.dao.enums.FreezeType;
import com.sky.dao.vo.FoodWareHouse;
import com.sky.dao.vo.MemberBean;
import com.sky.dao.vo.MemberBean2;

public class MemberFreezeUtil {
	
	
	/**
	 * 获取 是否冻结账户
	* @Title: checkFreezeMember
	* @Description: TODO    
	* @param @param member
	* @param @return 
	* @return String
	* @throws
	 */
	public static String checkFreezeMember(FoodWareHouse member){
		String msg = "";
		if(StringUtil.isNull(member)){
			return "";

		}
		if(!StringUtil.isNull(member.getFreezeType()) && member.getFreezeType().equals("1")){
			if(StringUtil.isNull(member.getFreezeDate())){
				msg = FreezeType.FreezeMember.getMsg()+member.getFreezeReason();
			}else{
				Date date = new Date();
				if(member.getFreezeDate().getTime() > date.getTime()){
					msg = FreezeType.FreezeMember.getMsg()+member.getFreezeReason();
				}
			}
		}
		return msg;
	}

	//检查用户是否被冻结余额
	public static StatusBean checkFreezeMember2(MemberBean member)
	{
		if(StringUtil.isNull(member)){
			return new StatusBean(false,"用户不存在");
		}
		if((!StringUtil.isNull(member.getFreezeType())) && (
				member.getFreezeType() == FreezeType.FreezeMember.getCode()
//				||member.getFreezeType() == FreezeType.FreezeProfit.getCode()
						||member.getFreezeType() == FreezeType.FreezeMoney.getCode()
						||member.getFreezeType() == FreezeType.FreezeProfitAndMoney.getCode())){

			if(StringUtil.isNull(member.getFreezeDate())){//空的，永久冻结
				return new StatusBean(false, member.getFreezeReason());
			}else{//有有效期
				if(member.getFreezeDate().after(new Date())){//未过期，继续冻结
					return new StatusBean(false, member.getFreezeReason());
				}
				return new StatusBean(true,"");//冻结结束
			}
		} else {//未冻结
			return new StatusBean(true,"");
		}
	}

	//检查用户是否被冻结余额
	public static StatusBean checkFreezeYunMember(MemberBean2 member)
	{
		if(StringUtil.isNull(member)){
			return new StatusBean(false,"用户不存在");
		}
		if((!StringUtil.isNull(member.getFreezeType())) && (
				member.getFreezeType() == FreezeType.FreezeMember.getCode()
//				||member.getFreezeType() == FreezeType.FreezeProfit.getCode()
						||member.getFreezeType() == FreezeType.FreezeMoney.getCode()
						||member.getFreezeType() == FreezeType.FreezeProfitAndMoney.getCode())){

			if(StringUtil.isNull(member.getFreezeDate())){//空的，永久冻结
				return new StatusBean(false, member.getFreezeReason());
			}else{//有有效期
				if(member.getFreezeDate().after(new Date())){//未过期，继续冻结
					return new StatusBean(false, member.getFreezeReason());
				}
				return new StatusBean(true,"");//冻结结束
			}
		} else {//未冻结
			return new StatusBean(true,"");
		}
	}
}

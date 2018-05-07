package com.sky.api;

public class TestSql {
	
	
	String sql = "";
	
	public static void main( String[] args ){
//		address();
		order();
	}
	
	/**
	 * 订单生成
	 */
	public static void order(){
		for(int i= 0; i < 64 ; i++ ){
			
			String str = "";
			
			str = i < 10 ?"0"+i+"":i+"";
			
			System.out.println("ALTER TABLE `doing_order_"+str+"` CHANGE `contact` `contact` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;");
			System.out.println("ALTER TABLE `doing_order_"+str+"` CHANGE `address` `address` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;");
			System.out.println("ALTER TABLE `doing_order_"+str+"` CHANGE `pay_remark` `pay_remark` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;");
			System.out.println("ALTER TABLE `doing_order_"+str+"` CHANGE `buyer_remark` `buyer_remark` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;");
			System.out.println("ALTER TABLE `doing_order_"+str+"` CHANGE `seller_remark` `seller_remark` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;");
		}
	}
	
	
	/**
	 * 退款
	 */
	public static void refund(){
		for (int i = 0; i < 64; i++) {
			String str = "";
			str = i < 10 ? "0" + i + "" : i + "";
			System.out.println("ALTER TABLE `refund_order_" + str
					+ "` CHANGE `refund_money_reason` `refund_money_reason` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;");
			System.out.println("ALTER TABLE `refund_order_" + str
					+ "` CHANGE `refund_goods_reason` `refund_goods_reason` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;");
			System.out.println("ALTER TABLE `refund_order_" + str
					+ "` CHANGE `is_received_refund_goods_remark` `is_received_refund_goods_remark` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;");
			System.out.println("ALTER TABLE `refund_order_" + str
					+ "` CHANGE `refund_money_remark` `refund_money_remark` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;");
		}
	}
	/**
	 * 地址
	 */
	public static void address(){
		for (int i = 0; i < 64; i++) {
			String str = "";
			str = i < 10 ? "0" + i + "" : i + "";
			System.out.println("ALTER TABLE `member_address_" + str
					+ "` CHANGE `contact` `contact` VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;");
		}
	}
	
}

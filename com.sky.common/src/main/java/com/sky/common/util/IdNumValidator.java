package com.sky.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 身份证号码校验
 */
public class IdNumValidator {

	public static String validateNum(String idNumSubStr) {
		String birthday = idNumSubStr.substring(6, 14);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		try {
			Date date = sdf.parse(birthday);

			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);

			if (calendar.get(Calendar.YEAR) < 1900 || date.after(new Date())) {
				throw new RuntimeException("身份证生日时间错误！");
			}

			String tempBirthday = sdf.format(date);

			if (!birthday.equals(tempBirthday)) {
				throw new RuntimeException("身份证生日格式错误！");
			}
		} catch (ParseException e) {
			throw new RuntimeException("身份证生日输入错误！");
		}

		char[] chs = idNumSubStr.toCharArray();

		int sum = 0;

		for (int i = 0; i < chs.length; i++) {
			int j = Integer.parseInt(Character.toString(chs[i]));

			sum += j * (Math.pow(2, 17 - i) % 11);
		}

		int x = (12 - sum % 11) % 11;

		return x == 10 ? "X" : x + "";
	}

	public static boolean validate(String idNumStr) {
		assert idNumStr != null;
		if (idNumStr.length() != 18) {
			throw new RuntimeException("身份证号位数错误");
		}

		String idNumSubStr = idNumStr.substring(0, idNumStr.length() - 1);

		Long.parseLong(idNumSubStr);

		String lastStr = idNumStr.substring(idNumStr.length() - 1).toUpperCase();

		return lastStr.equals(validateNum(idNumSubStr));
	}

	public static void main(String[] args) {
		System.out.println(validate("44088219811025104"));
		// 將要測試的身份證字號填入此
		IdNumValidator id = new IdNumValidator("A123456789");
		// --------------------------
		// IDcheack回傳的是true跟false
		if (id.IDCheak()) {
			System.out.println("真的");
		} else {
			System.out.println("非法的");
		}

	}

	public String str = "";

	// 檢查是否為身份證字號並回傳True或False
	public boolean IDCheak() {
		IdNumValidator id = new IdNumValidator(this.str);
		int[] D = new int[10];
		// 身份正字號長度必須為10個字
		if (str == null || str.length() != 10) {
			return false;
		}
		// 首字為英文，然後第二位數為1~2
		if (!(id.D0() != 0 && id.DNumber(1) > 0 && id.DNumber(1) < 3)) {
			return false;
		}
		// put the first code and the second code

		D[0] = id.D0();
		D[1] = id.DNumber(1);
		// 剩下數值應為0~9
		for (int k = 2; k < 10; k++) {
			if (!(id.DNumber(k) >= 0 && id.DNumber(k) <= 9)){
				return false;
			}
			D[k] = id.DNumber(k);
		}
		int cheakCode = 0;
		cheakCode = (10 - (id.CheckCode(D) % 10)) % 10;
		if (cheakCode != D[9]){
			return false;
		}
		return true;

	}

	// D0是找第一個字的代碼，因為有些數字不規律所以要用很多if做判斷
	private int D0() {
		int D00 = 0;
		int temp = this.str.codePointAt(0);
		if (72 >= temp && temp >= 65){
			D00 = temp - 55;
		} else if (78 >= temp && temp >= 74) {
			D00 = temp - 56;
		} else if (86 >= temp && temp >= 80) {
			D00 = temp - 57;
		} else if (90 >= temp && temp >= 88){
			D00 = temp - 58;
		}
		switch (temp) {
		case 74:
			D00 = temp - 39;
		case 79:
			D00 = temp - 44;
			break;
		case 87:
			D00 = temp - 55;
			break;
		default:
			break;
		}

		// 這邊是用來檢查使用者輸入小寫時的判斷式
		if (104 >= temp && temp >= 97){
			D00 = temp - 87;
		} else if (110 >= temp && temp >= 106) {
			D00 = temp - 88;
		} else if (118 >= temp && temp >= 112) {
			D00 = temp - 89;
		} else if (122 >= temp && temp >= 120){
			D00 = temp - 90;
		}
		switch (temp) {
		case 106:
			D00 = temp - 71;
		case 111:
			D00 = temp - 76;
			break;
		case 119:
			D00 = temp - 87;
			break;
		default:
			break;
		}
		return D00;

	}

	// DNumber用來撿查第2~第10個字，所以判斷式簡單許多
	private int DNumber(int i) {
		int D1 = 100;
		// 這個初始100只是用來表示如果他不是0~9這個值就顯示100
		// 也可以用其他數值來表示，但是要避免使用0~9
		int temp = this.str.codePointAt(i);
		// use variable to determine the code of the i-th character of the
		// string
		if (57 >= temp && temp >= 48) {
			D1 = temp - 48;
		}
		return D1;
	}

	// 這邊只是輔助計算身份證是否正確
	private int CheckCode(int[] X) {
		int x1 = Math.floorDiv(X[0], 10);
		int x2 = X[0] % 10;
		int Y = x1 + (9 * x2) + (8 * X[1]);
		for (int i = 2; i <= 8; i++){
			Y = (9 - i) * X[i] + Y;
		}
		return Y;
	}

	public void ChangeID(String s) {
		this.str = s;

	}

	public IdNumValidator(String s) {
		this.str = s;

	}

	public IdNumValidator() {

	}

}
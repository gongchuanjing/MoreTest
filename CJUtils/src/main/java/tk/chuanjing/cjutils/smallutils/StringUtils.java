package tk.chuanjing.cjutils.smallutils;

import android.text.TextUtils;

/**
 * @author ChuanJing
 * @date 2016年8月28日 下午3:55:11
 */
public class StringUtils {

	/** 如果是 null 转换为0 */
	public static String nullTo0(String str) {
		if ("null".equals(str) || "null" == str || str == null || "" == str || "".equals(str)) {
			return "0";
		}
		return str;
	}

	/** 把一个纯数字 字符串 转换成数字，如果不是数字字符串 则 返回 0 */
	public static int numStringToInt(String str) {
		String noNullStr = nullTo0(str);
		int num = 0;
		try {
			num = Integer.parseInt(noNullStr);
		} catch (NumberFormatException e) {
			// e.printStackTrace();
			return 0;
		}
		return num;
	}

	public static double numStringToDouble(String str) {
		String noNullStr = nullTo0(str);
		double num = 0.00;
		try {
			num = Double.parseDouble(noNullStr);
		} catch (NumberFormatException e) {
			// e.printStackTrace();
			return num;
		}
		return num;
	}

	/** 如果服务器返回字符串是“null” 转换为"" */
	public static String nullToStrNull(String str) {
		if ("null".equals(str) || "null" == str || str == null) {
			return "";
		}
		return str;
	}
	
	/** 如果服务器返回字符串是“null” 转换为""，否则进行千位分隔符转换 */
	public static String nullToStrNullOrDiv(String str) {
		if ("null".equals(str) || "null" == str || str == null) {
			return "";
		} else {
			return intDiv(str);
		}
	}
	
	/**
	 * 判断字符串为null,或者空串，或者是字符串"null"
	 * @param str
	 * @return
	 */
	public static boolean isStrNullOrKongChuan(String str){
		if ("null".equals(str) || "null" == str || str == null || "" == str || "".equals(str) || "0".equals(str) || "0.0".equals(str) || "0.00".equals(str)) {
			return true;
		}
		return false;
	}
	
	public static boolean fierceIsEmpty(String str){
		if (TextUtils.isEmpty(str) || "null".equals(str) || "null" == str) {
			return true;
		}
		return false;
	}

	/**
	 * 数字转千分符
	 *
	 * @param str
	 * @return
	 */
	public static String intDiv(String str) {
		String moneyStr = "";
		// 不足三位不截取，不然会出现,100
		if (!TextUtils.isEmpty(str)) {
			if (str.length() > 3) {
				// 倒置字符串从个位判断，从前往后会出现100,0
				str = new StringBuilder(str).reverse().toString();
				moneyStr = str.replaceAll("[\\w]{3}", "$0,");
				moneyStr = new StringBuilder(moneyStr).reverse().toString();
				// 如果第一个是 , 则去掉
				if (moneyStr.startsWith(",")) {
					moneyStr = moneyStr.substring(1);
				}
				return moneyStr;
			} else {
				return str;
			}
		}
		return moneyStr;
	}
}

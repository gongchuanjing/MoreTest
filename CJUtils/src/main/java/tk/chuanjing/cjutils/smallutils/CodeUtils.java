package tk.chuanjing.cjutils.smallutils;

import android.util.Base64;

public class CodeUtils {

	/**
	 *  加密
	 * @param content 加密后内容
	 * @return
	 */
	public static String encode(String content) {
		content = new String(Base64.encode(content.getBytes(), Base64.DEFAULT));
		System.out.println("加密后的结果:" + content);
		return content;
	}

	/**
	 *  解密
	 * @param content 解密后内容
	 * @return
	 */
	public static String decode(String content) {
		content = new String(Base64.decode(content, Base64.DEFAULT));
		System.out.println("解密后的结果:" + content);
		return content;
	}
}

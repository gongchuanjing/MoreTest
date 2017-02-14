package tk.chuanjing.moretest;

import android.os.Environment;

import static android.os.Build.VERSION_CODES.N;

/**
 * 常量类
 */
public class Constant {

	// -------------------------------------网络地址常量-----------------------------------
	 public static final String PATH = "http://120.26.10.29:8081/LiVEServiceLSH/";//dev net test
 	 public static final String PATHKPI = "http://120.26.10.29:8081/LiVEService/";// KPI

	/** 新版本下载地址 */
	public static  String NET_APK = "http://chuanjing.bitbucket.org/kuaididaole/kuaididaole.apk";

	/** 登录 */
	public static final String DO_LOGIN = PATH + "ITaskLogin";

	/** 获取金融保险开关 */
	public static final String FINANCIAL_INSURANCE_SWITCH = PATHKPI + "set/getItaskDealerInfo";


	// --------------------------------------文件相关常量-----------------------------------
	private static final String ROOT_PATH = "moretest";

	/** 本软件在内存卡根目录上的专用文件夹，既：/mnt/sdcard/iris */
	public static final String ROOT_FILE_PATH = Environment.getExternalStorageDirectory().getPath() + "/" + ROOT_PATH;

	/** 本软件的下载专用文件夹，既：/mnt/sdcard/moretest/download */
	public static final String DOWNLOAD_FILE_PATH = ROOT_FILE_PATH + "/download";
	public static final String IMAGE_PATH = ROOT_FILE_PATH + "/image";
}

package tk.chuanjing.moretest;

import android.os.Environment;

/**
 * 常量类
 */
public class Constant {

	// --------------------------------------网络地址常量-----------------------------------
	/**
	 * 旧的后台地址,待删除
	 */
	public static final String PATHOLD = "https://112.124.38.188:2673/ITaskServiceLSH/";

	/**
	 * 新的后台地址
	 */
//	 public static final String PATH = "http://106.120.243.55:7522/LiVEServiceLSH/";//Lsh Formal
//	 public static final String PATH = "http://183.91.155.195:7522/LiVEServiceLSH/";//Lsh Test
	 public static final String PATH = "http://120.26.10.29:8081/LiVEServiceLSH/";//dev net test
 	 public static final String PATHKPI = "http://120.26.10.29:8081/LiVEService/";// KPI
//	 public static final String PATH = "http://192.168.91.111:7522/LiVEServiceLSH/";//dev test
//	 public static final String PATH = "http://192.168.91.88:2673/LiVEServiceLSH/";//dev test
//	 public static final String PATH = "http://120.26.66.145:7522/LiVEServiceLSH/";//release
//	 public static final String PATH = "http://183.91.155.195:1818/LiVEServiceLSH/";//LSH formal release
//	 public static final String PATHKPI = "http://183.91.155.195:1818/LiVEService/";//LSH formal release
	 
	 /**战败原因*/
	 public static final String GET_DEFEAT_REASON = PATH + "GetDefeatReason";
	
	/**待挖掘线索需要高亮的接口*/
	 public static final String UPDATE_CRM_EXPLORE=	PATH + "UpdateCrmExploreCheck";
	
	

	/** 新版本下载地址 */
	public static  String NET_APK = "http://120.26.66.145:7522/LSHTestUpdate/LshITaskSE.apk";

	/** 登录 */
	public static final String DO_LOGIN = PATH + "ITaskLogin";

	/** 获取客户线索信息 */
	public static final String GET_CUSTOMER_CLUE = PATH + "GetCustomerClueServlet";

	/** 获取库存信息--三个页面公用一个接口，但参数不一 */
	public static final String GET_STOCK_INFO = PATH + "ITaskGetCarStockInfo";

	/** 获取推荐信息 */
	public static final String GET_RECOMMEND_LIST = PATH + "GetRecommendListServlet";

	/** 获取推荐信息(被推荐线索) */
	public static final String GET_CUSTOMER_CLUE_LIST = PATH + "GetCustomerClueListServlet";

	/** 获取将过保的客户信息 */
	public static final String GET_REPURCHASE_LIST = PATH + "GetRepurchaseListServlet";

	public static final String GET_FINANCE_SETTING = PATH + "GetFinanceSettingsServlet"; // 旧金融设置

	/** 获取金融设置信息 */
	public static final String GET_QUOTE_FINANCE_SETTING = PATH + "ITaskGetQuoteFinanceSetting";

	/** 金融获取金融筛选后参数 */
	public static final String GET_QUOTE_FINANCE_INFO = PATH + "ITaskGetQuoteFinanceInfo";

	/** 金融热销 */
	public static final String GET_QUOTE_FINANCE_HOT = PATH + "ITaskGetQuoteFinanceHot";

	/** 获取平台信息 */
	public static final String GET_CUSTOMER_INFO = PATH + "ITaskGetCustomerInfo";

	/** 设置平台信息 */
	public static final String SET_CUSTOMER_INFO = PATH + "ITaskSetCustomerInfo";

	/** 获取车系车型车款,对比车型 */
	public static final String GET_CAR_INFO = PATH + "ITaskGetCarInfo";

	/** 获取名单/线索 */
	public static final String GET_CUST_INFO = PATH + "ITaskGetCustList";

	/** 获取线索池筛选 */
	public static final String GET_CUSTLIST_FILTER = PATH + "ITaskGetCustListFilter";
	
	/** 获取线索池筛选 中 状态筛选的所有状态 */
	public static final String CAR_SALES_STATE = PATH + "CarSalesState";
	
	/** 获取合同审批流程 */
	public static final String CONTRACT_APPROVAL_PROCEDURE = PATHKPI + "approval/contractFlowCheck";

	/** 获取消息列表 */
	public static final String GET_MSG_LIST = PATH + "ITaskGetMsgList";

	/** 从ID获取单个精品（非套餐） */
	public static final String GET_AFTER_MARKET_FORMID = PATH + "GetAfterMarketFromID";

	/** 从ID获取精品/套餐 */
	public static final String GET_AFTER_MARKET_LIST_FORMID = PATH + "GetAfterMarketListFromID";

	/** 获取活动 */
	public static final String GET_ACTIVITY_LIST = PATH + "GetActivityList";

	/** 获取活动邀约 */
	public static final String GET_ACTIVITY_CUSTLIST = PATH + "GetActivityCustList";

	/** 获取活动文件 */
	public static final String GET_ACTIVITY_FILE = PATH + "GetActivityFile";

	/** 获取客户详细信息 */
	public static final String GET_CUSTOMER_HISTORY = PATH + "ITaskGetCustHistory";

	/** 插入跟进 */
	public static final String GET_INSERT_FOLLOWUP = PATH + "ITaskInsertFollowUp";

	/** 获取漏斗 */
	public static final String GET_FUNNEL = PATH + "GetFunnel";

	/** 插入推荐、再购线索 */
	public static final String INSERT_CLUE = PATH + "ITaskInsertClue";

	/**
	 * 获取日历数据
	 */
	public static final String GET_CALENDAR = PATH + "ITaskGetCalendar";
	/**
	 * 获取待办事项,按照时间排序
	 */
	public static final String GET_TODO_BY_TIME = PATH + "ITaskGetScheduleOrderTime";
	/**
	 * 获取待办事项,按照类别排序
	 */
	public static final String GET_TODO_BY_OBJ = PATH + "ITaskGetScheduleOrderObj";

	/**
	 * 删除日历
	 */
	public static final String DELETE_CALENDAR = PATH + "ITaskDeleteSchedule";
	/**
	 * 添加日历
	 */
	public static final String ADD_NEW_SCHEDULE = PATH + "ITaskAddNewSchedule";
	/**
	 * 通过ID获取车型
	 */
	public static final String GET_CAR_FROM_ID = PATH + "GetCarFromID";
	/**
	 * 通过IDlist获取车型List
	 */
	public static final String GET_CAR_LIST_FROM_ID = PATH + "GetCarListFromID";
	/**
	 * 通过对比ID获取车型
	 */
	public static final String GET_COMPARE_CAR_FROM_ID = PATH + "GetCompareCarFromID";
	/**
	 * 通过IDlist获取车型List
	 */
	public static final String GET_COMPARE_CAR_LIST_FROM_ID = PATH + "GetCompareCarListFromID";

	/** 保险热销 */
	public static final String GET_QUOTE_INSURANCE_INFO = PATH + "ITaskGetQuoteInsuranceInfo";

	/** 报价单中的保险公司选择 */
	public static final String GET_QUOTE_INSURANCE_SETTING = PATH + "ITaskGetQuoteInsuranceSetting";

	/**
	 * 获取精品分类
	 */
	public static final String GET_AFTER_MARKET_CATLOG = PATH + "ITaskGetAfterMarketCatlog";
	/**
	 * 获取精品列表
	 */
	public static final String GET_AFTER_MARKT_LIST = PATH + "ITaskGetAfterMarketList";

	/**
	 * 获取随车项目
	 */
	public static final String GET_SI_LIST = PATH + "ITaskGetSIList";

	/**
	 * 获取销售平台
	 */
	public static final String GET_STAG_INFO = PATH + "ITaskGetTest";
	/**
	 * 设置销售平台
	 */
	public static final String SET_STAG_INFO = PATH + "ITaskTest";

	/** 修改密码 */
	public static final String CHANGE_PASS = PATH + "ITaskChangePass";

	/** 检查设备ID是否冲突 */
	public static final String ITASK_CHECK_DEVICE = PATH + "ITaskCheckDevice";
	
	/** 获取试驾时间 */
	public static final String TEST_DRIVE_TIME = PATH + "foreGround/testDriveProcess";

	/** 获取金融保险开关 */
	public static final String FINANCIAL_INSURANCE_SWITCH = PATHKPI + "set/getItaskDealerInfo";
	
	/** 撤单 */
	public static final String CANCEL_APPROVAL = PATHKPI + "approval/CancelApproval";

	// --------------------------------------文件相关常量-----------------------------------
	private static final String ROOT_PATH = "iris";

	/** 本软件在内存卡根目录上的专用文件夹，既：/mnt/sdcard/iris */
	public static final String ROOT_FILE_PATH = Environment.getExternalStorageDirectory().getPath() + "/" + ROOT_PATH;

	/** 本软件的下载专用文件夹，既：/mnt/sdcard/iris/update */
	// public static final String DOWNLOAD_FILE_PATH = ROOT_FILE_PATH +
	// "/download";
	public static final String DOWNLOAD_FILE_PATH = ROOT_FILE_PATH + "/update";
	public static final String PPT_PATH = ROOT_FILE_PATH + "/pdf";
	public static final String IMAGE_PATH = ROOT_FILE_PATH + "/image";
	// -------------------------------------本地存储数据的xml名字-------------------------------
	public static final String XML_NAME_MSG = "Message";
}

package tk.chuanjing.moretest.testokhttp;

import java.util.ArrayList;

public class SCInfo {
	
	/**
	 * 是否首次登录：0-否/1-是
	 */
	private String FirstLogin;
	
	/**
	 * 是否强制更新-0-否/1-是
	 */
	private String ForceUpdate;
	
	/**
	 * 上级代码
	 */
	private String UpCode;
	/**
	 * 上级角色
	 */
	private String UpRole;

	/**
	 * 经销商名称_英文
	 */
	private String DealerName_EN;
	
	/**
	 * 角色
	 */
	private String SCRole;

	/**
	 * 返回信息:已删除,升级,成功,错误,没有权限
	 */
	private String info;

	/**
	 * 经销商代码
	 */
	private String dealerCode;

	/**
	 * 经销商名
	 */
	private String dealerName;
	/**
	 * 是否解密电话号码：是-解密
	 */
	private String decodePhoneNum;
	/**
	 * 推荐的月份数
	 */
	private String recommendMonth;
	/**
	 * 不同级别客户最大跟进天数（A,B,C,D）
	 */
	private ArrayList<String> maxReserveDay;
	/**
	 * 明天所需跟进数字
	 */
	private String todayTaskNum;
	/**
	 * 我也不知道做什么的
	 * 
	 */
	private String scisReception;
	/**
	 * 销售顾问姓名
	 */
	private String scname;

	/**
	 * 销售顾问代码
	 */
	private String sccode;
	/**
	 * 销售顾问电话
	 */
	private String scphone;
	/**
	 * 销售顾问所在小组
	 */
	private String scinGroup;
	/**
	 * 销售顾问的级别:C-Sales
	 */
	private String sclevel;
	/**
	 * App版本
	 */
	private String itaskVersion;
	/**
	 * 销售顾问所属品牌
	 */
	private String scbrand;

	public String getFirstLogin() {
		return FirstLogin;
	}

	public void setFirstLogin(String firstLogin) {
		FirstLogin = firstLogin;
	}

	public String getForceUpdate() {
		return ForceUpdate;
	}

	public void setForceUpdate(String forceUpdate) {
		ForceUpdate = forceUpdate;
	}

	public String getUpCode() {
		return UpCode;
	}

	public void setUpCode(String upCode) {
		UpCode = upCode;
	}

	public String getUpRole() {
		return UpRole;
	}

	public void setUpRole(String upRole) {
		UpRole = upRole;
	}

	public String getDealerCode() {
		return dealerCode;
	}

	public String getDealerName() {
		return dealerName;
	}

	public String getDecodePhoneNum() {
		return decodePhoneNum;
	}

	public String getInfo() {
		return info;
	}

	public String getItaskVersion() {
		return itaskVersion;
	}

	public ArrayList<String> getMaxReserveDay() {
		return maxReserveDay;
	}

	public String getRecommendMonth() {
		return recommendMonth;
	}

	public String getScbrand() {
		return scbrand;
	}

	public String getSccode() {
		return sccode;
	}

	public String getScinGroup() {
		return scinGroup;
	}

	public String getScisReception() {
		return scisReception;
	}

	public String getSclevel() {
		return sclevel;
	}

	public String getScname() {
		return scname;
	}

	public String getScphone() {
		return scphone;
	}

	public String getSCRole() {
		return SCRole;
	}

	public String getTodayTaskNum() {
		return todayTaskNum;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public void setDecodePhoneNum(String decodePhoneNum) {
		this.decodePhoneNum = decodePhoneNum;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public void setItaskVersion(String itaskVersion) {
		this.itaskVersion = itaskVersion;
	}

	public void setMaxReserveDay(ArrayList<String> maxReserveDay) {
		this.maxReserveDay = maxReserveDay;
	}

	public void setRecommendMonth(String recommendMonth) {
		this.recommendMonth = recommendMonth;
	}

	public void setScbrand(String scbrand) {
		this.scbrand = scbrand;
	}

	public void setSccode(String sccode) {
		this.sccode = sccode;
	}

	public void setScinGroup(String scinGroup) {
		this.scinGroup = scinGroup;
	}

	public void setScisReception(String scisReception) {
		this.scisReception = scisReception;
	}

	public void setSclevel(String sclevel) {
		this.sclevel = sclevel;
	}

	public void setScname(String scname) {
		this.scname = scname;
	}

	public void setScphone(String scphone) {
		this.scphone = scphone;
	}

	public void setSCRole(String sCRole) {
		SCRole = sCRole;
	}

	public void setTodayTaskNum(String todayTaskNum) {
		this.todayTaskNum = todayTaskNum;
	}
	
	public String getDealerName_EN() {
		return DealerName_EN;
	}

	public void setDealerName_EN(String dealerName_EN) {
		DealerName_EN = dealerName_EN;
	}

	@Override
	public String toString() {
		return "SCInfo [DealerName_EN=" + DealerName_EN + ", SCRole=" + SCRole + ", info=" + info + ", dealerCode="
				+ dealerCode + ", dealerName=" + dealerName + ", decodePhoneNum=" + decodePhoneNum + ", recommendMonth="
				+ recommendMonth + ", maxReserveDay=" + maxReserveDay + ", todayTaskNum=" + todayTaskNum
				+ ", scisReception=" + scisReception + ", scname=" + scname + ", sccode=" + sccode + ", scphone="
				+ scphone + ", scinGroup=" + scinGroup + ", sclevel=" + sclevel + ", itaskVersion=" + itaskVersion
				+ ", scbrand=" + scbrand + "]";
	}
}

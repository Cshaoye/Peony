package com.shaoye.dto;

public class TBUserDto {
	
	private String id;// 主键
	private String channel;// CHANNEL渠道来源
	private String clientCode;// ClientCode; varchar(4) NOT NULL, 客户号
	private String email;// EMAIL varchar(255) DEFAULT NULL, 邮箱
	private String employeeId;// EMPLOYEEID; varchar(255) DEFAULT NULL,经办员工
	private int enabled;// ENABLED tinyint(1) NOT NULL DEFAULT '0',是否可用
	private int enterprise;// ENTERPRISE tinyint(1) DEFAULT '0',是否为企业用户
	private String grouptId;// GROUPID varchar(255) DEFAULT NULL,所属分组
	private String idNumber;// IDNUMBER varchar(255) DEFAULT NULL,身份证
	private String loginname;// LOGINNAME varchar(30) NOT NULL,登录名
	private String mobile;// MOBILE varchar(255) DEFAULT NULL,手机号码
	private String name;// NAME varchar(15) DEFAULT NULL, 用户名
	private String passphrase;// PASSPHRASE varchar(40) NOT NULL,加密密码
	private String salt;// SALT varchar(120) NOT NULL, 盐值
	private String source;// SOURCE varchar(255) NOT NULL,来源
	private String referralId;// REFERRAL_ID varchar(255) DEFAULT NULL,推荐人id
	private String referralRealm;// REFERRAL_REALM varchar(255) DEFAULT
									// NULL,推荐人姓名

	public TBUserDto(String id,String employeeId,int enabled,int enterprise
			,String name,String source,String passphrase,String salt) {
		this.id =id;
		this.employeeId = employeeId;
		this.enabled = enabled;
		this.enterprise = enterprise;
		this.name = name;
		this.source = source;
		this.passphrase = passphrase;
		this.salt = salt;
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public int getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(int enterprise) {
		this.enterprise = enterprise;
	}

	public String getGrouptId() {
		return grouptId;
	}

	public void setGrouptId(String grouptId) {
		this.grouptId = grouptId;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassphrase() {
		return passphrase;
	}

	public void setPassphrase(String passphrase) {
		this.passphrase = passphrase;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getReferralId() {
		return referralId;
	}

	public void setReferralId(String referralId) {
		this.referralId = referralId;
	}

	public String getReferralRealm() {
		return referralRealm;
	}

	public void setReferralRealm(String referralRealm) {
		this.referralRealm = referralRealm;
	}

}

package com.lenovo.tool.InHtmlJWXT_util;

/**
 * 储存用户信息
 * @author EsauLu
 *
 */
public class User {
	
	/**
	 * 用户名
	 */
	private String name = "Pactera_liuzh";
	
	/**
	 * 密码
	 */
	private String passwd = "1liuzhenhua";
	
	/**
	 * 验证码
	 */
	private String check;
	
	/**
	 * BtnLogin
	 */
	private String BtnLogin = "Login";
	
	/**
	 * viewstate
	 */
	private String viewstate = "/wEPDwUJMTE5NzA0MzI3ZGT7udzmHfhQ3Q+wUnVG1+Ocig+j8Q==";
	/**
	 * 构造函数
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 构造函数
	 * @param name 用户名
	 * @param passwd 密码
	 */
	public User(String name,String passwd) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.passwd=passwd;
	}
	
	/**
	 * 设置用户名
	 * @param name 用户名
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 设置密码
	 * @param passwd 密码
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	/**
	 * 获取用户名
	 * @return 返回用户名
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 获取密码
	 * @return 返回密码
	 */
	public String getPasswd() {
		return passwd;
	}
	
	/**
	 * 设置验证码
	 * @param check 验证码
	 */
	public void setCheck(String check) {
		this.check = check;
	}
	
	/**
	 * 获取验证码
	 * @return 返回验证码
	 */
	public String getCheck() {
		return check;
	}
	/**
	 * 获取BtnLogin
	 * @return 返回BtnLogin
	 */
	public String getBtnLogin() {
		return BtnLogin;
	}
	
	/**
	 * 获取viewstate
	 * @return 返回viewstate
	 */
	public String getviewstate() {
		return viewstate;
	}
}



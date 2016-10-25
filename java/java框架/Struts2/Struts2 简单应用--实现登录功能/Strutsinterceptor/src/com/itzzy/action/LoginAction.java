package com.itzzy.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport implements SessionAware{
	
	private String username;
	private String password;
	private Map<String, Object> session;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String login(){
		if("admin".equals(username)&&"123".equals(password)){
			session.put("login", username);
			return SUCCESS;
		}else {
			session.put("loginError", "用户名或密码不正确！");
			return ERROR;
		}
	}
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

}

package com.hp.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
	private Integer userid;
	private String qq;
	private String username;
	private String password;
	private String headpic;
	private Integer sex;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	private String nowaddress;
	private String hometown;
	private String ismarry;
	private Integer state;
	private Date lastvisit;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
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
	public String getHeadpic() {
		return headpic;
	}
	public void setHeadpic(String headpic) {
		this.headpic = headpic;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getNowaddress() {
		return nowaddress;
	}
	public void setNowaddress(String nowaddress) {
		this.nowaddress = nowaddress;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public String getIsmarry() {
		return ismarry;
	}
	public void setIsmarry(String ismarry) {
		this.ismarry = ismarry;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	public Date getLastvisit() {
		return lastvisit;
	}
	public void setLastvisit(Date lastvisit) {
		this.lastvisit = lastvisit;
	}
	
	
	
}

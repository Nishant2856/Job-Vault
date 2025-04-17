package com.xadmin.jobvault.bean;

public class user {
private int u_id ;
private String full_name;
private String email;
private String password;
private String mobile;
private String address;
private String work_status;
private String created_date;
public user(int u_id, String full_name, String email, String password, String mobile, String address,
		String work_status, String created_date) {
	super();
	this.u_id = u_id;
	this.full_name = full_name;
	this.email = email;
	this.password = password;
	this.mobile = mobile;
	this.address = address;
	this.work_status = work_status;
	this.created_date = created_date;
}
public String getCreated_date() {
	return created_date;
}
public void setCreated_date(String created_date) {
	this.created_date = created_date;
}
public user(String full_name, String email, String password, String mobile, String address, String work_status) {
	super();
	this.full_name = full_name;
	this.email = email;
	this.password = password;
	this.mobile = mobile;
	this.address = address;
	this.work_status = work_status;
}
public user(int u_id, String full_name, String email, String password, String mobile, String address,
		String work_status) {
	super();
	this.u_id = u_id;
	this.full_name = full_name;
	this.email = email;
	this.password = password;
	this.mobile = mobile;
	this.address = address;
	this.work_status = work_status;
}
public int getU_id() {
	return u_id;
}
public void setU_id(int u_id) {
	this.u_id = u_id;
}
public String getFull_name() {
	return full_name;
}
public void setFull_name(String full_name) {
	this.full_name = full_name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getWork_status() {
	return work_status;
}
public void setWork_status(String work_status) {
	this.work_status = work_status;
}
}

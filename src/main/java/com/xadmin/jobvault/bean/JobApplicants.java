package com.xadmin.jobvault.bean;

public class JobApplicants {
private int a_id;
private int u_id;
private int c_id;
private int j_id;
private String date;
private String status;
private String title;
private String username;
private String email;
private String number;

public JobApplicants(int u_id, int c_id, int j_id, String date, String status, String title, String username,
		String email, String number) {
	super();
	this.u_id = u_id;
	this.c_id = c_id;
	this.j_id = j_id;
	this.date = date;
	this.status = status;
	this.title = title;
	this.username = username;
	this.email = email;
	this.number = number;
}
public JobApplicants(int u_id, int c_id, int j_id,  String title, String username, String email,
		String number) {
	super();

	this.u_id = u_id;
	this.c_id = c_id;
	this.j_id = j_id;

	this.title = title;
	this.username = username;
	this.email = email;
	this.number = number;
}
public JobApplicants(int a_id, int u_id, int c_id, int j_id, String date, String status, String title, String username,
		String email, String number) {
	super();
	this.a_id = a_id;
	this.u_id = u_id;
	this.c_id = c_id;
	this.j_id = j_id;
	this.date = date;
	this.status = status;
	this.title = title;
	this.username = username;
	this.email = email;
	this.number = number;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}

public String getUsername() {
	return username;
}
public void getUsername(String username) {
	this.username = username;
}


public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public JobApplicants(int u_id, int c_id, int j_id, String date, String status, String title) {
	super();
	this.u_id = u_id;
	this.c_id = c_id;
	this.j_id = j_id;
	this.date = date;
	this.status = status;
	this.title = title;
}
public JobApplicants(int a_id, int u_id, int c_id, int j_id, String date, String status, String title) {
	super();
	this.a_id = a_id;
	this.u_id = u_id;
	this.c_id = c_id;
	this.j_id = j_id;
	this.date = date;
	this.status = status;
	this.title = title;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public JobApplicants(int a_id, int u_id, int c_id, int j_id, String date, String status) {
	super();
	this.a_id = a_id;
	this.u_id = u_id;
	this.c_id = c_id;
	this.j_id = j_id;
	this.date = date;
	this.status = status;
}
public JobApplicants(int u_id, int c_id, int j_id, String date, String status) {
	super();
	this.u_id = u_id;
	this.c_id = c_id;
	this.j_id = j_id;
	this.date = date;
	this.status = status;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}


public JobApplicants(int u_id, int c_id, int j_id , String title) {
	super();
	this.u_id = u_id;
	this.c_id = c_id;
	this.j_id = j_id;
	this.title = title;
}
public JobApplicants(int a_id, int u_id, int c_id, int j_id) {
	super();
	this.a_id = a_id;
	this.u_id = u_id;
	this.c_id = c_id;
	this.j_id = j_id;
}
public int getA_id() {
	return a_id;
}
public void setA_id(int a_id) {
	this.a_id = a_id;
}
public int getU_id() {
	return u_id;
}
public void setU_id(int u_id) {
	this.u_id = u_id;
}
public int getC_id() {
	return c_id;
}
public void setC_id(int c_id) {
	this.c_id = c_id;
}
public int getJ_id() {
	return j_id;
}
public void setJ_id(int j_id) {
	this.j_id = j_id;
}
}

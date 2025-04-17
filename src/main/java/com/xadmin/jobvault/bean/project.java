package com.xadmin.jobvault.bean;

public class project {
private int pr_id;
private int u_id;
private String  title;
private String  client_name;
private String  status;
private String  years;
private String  months;
private String  details;
public project(int u_id, String title, String client_name, String status, String years, String months, String details) {
	super();
	this.u_id = u_id;
	this.title = title;
	this.client_name = client_name;
	this.status = status;
	this.years = years;
	this.months = months;
	this.details = details;
}
public project(int pr_id, int u_id, String title, String client_name, String status, String years, String months,
		String details) {
	super();
	this.pr_id = pr_id;
	this.u_id = u_id;
	this.title = title;
	this.client_name = client_name;
	this.status = status;
	this.years = years;
	this.months = months;
	this.details = details;
}
public int getPr_id() {
	return pr_id;
}
public void setPr_id(int pr_id) {
	this.pr_id = pr_id;
}
public int getU_id() {
	return u_id;
}
public void setU_id(int u_id) {
	this.u_id = u_id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getClient_name() {
	return client_name;
}
public void setClient_name(String client_name) {
	this.client_name = client_name;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getYears() {
	return years;
}
public void setYears(String years) {
	this.years = years;
}
public String getMonths() {
	return months;
}
public void setMonths(String months) {
	this.months = months;
}
public String getDetails() {
	return details;
}
public void setDetails(String details) {
	this.details = details;
}
}

package com.xadmin.jobvault.bean;

public class profile {
int p_id ;
public profile(int u_id, String summary) {
	super();
	this.u_id = u_id;
	this.summary = summary;
}
public profile(int p_id, int u_id, String summary) {
	super();
	this.p_id = p_id;
	this.u_id = u_id;
	this.summary = summary;
}
int u_id;
String summary ;

public int getU_id() {
	return u_id;
}
public void setU_id(int u_id) {
	this.u_id = u_id;
}
public String getSummary() {
	return summary;
}
public void setSummary(String summary) {
	this.summary = summary;
}
public profile(String summary) {
	super();
	this.summary = summary;
}
}

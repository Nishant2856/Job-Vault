package com.xadmin.jobvault.bean;

public class skills {
private int s_id;
private int u_id;
private String skill_name;
private String version;
private String last_used;
private String years;
private String month;
public skills(int u_id, String skill_name, String version, String last_used, String years, String month) {
	super();
	this.u_id = u_id;
	this.skill_name = skill_name;
	this.version = version;
	this.last_used = last_used;
	this.years = years;
	this.month = month;
}
public skills(int s_id, int u_id, String skill_name, String version, String last_used, String years, String month) {
	super();
	this.s_id = s_id;
	this.u_id = u_id;
	this.skill_name = skill_name;
	this.version = version;
	this.last_used = last_used;
	this.years = years;
	this.month = month;
}
public int getS_id() {
	return s_id;
}
public void setS_id(int s_id) {
	this.s_id = s_id;
}
public int getU_id() {
	return u_id;
}
public void setU_id(int u_id) {
	this.u_id = u_id;
}
public String getSkill_name() {
	return skill_name;
}
public void setSkill_name(String skill_name) {
	this.skill_name = skill_name;
}
public String getVersion() {
	return version;
}
public void setVersion(String version) {
	this.version = version;
}
public String getLast_used() {
	return last_used;
}
public void setLast_used(String last_used) {
	this.last_used = last_used;
}
public String getYears() {
	return years;
}
public void setYears(String years) {
	this.years = years;
}
public String getMonth() {
	return month;
}
public void setMonth(String month) {
	this.month = month;
}

}

package com.xadmin.jobvault.bean;

public class resume {
private int r_id;
private int u_id;
private String resume;
	public resume(int u_id, String resume) {
	super();
	this.u_id = u_id;
	this.resume = resume;
}
	public resume(int u_id) {
		super();
		this.u_id = u_id;
	}
	public resume(int r_id, int u_id, String resume) {
	super();
	this.r_id = r_id;
	this.u_id = u_id;
	this.resume = resume;
}
	public int getR_id() {
	return r_id;
}
public void setR_id(int r_id) {
	this.r_id = r_id;
}
public int getU_id() {
	return u_id;
}
public void setU_id(int u_id) {
	this.u_id = u_id;
}
public String getResume() {
	return resume;
}
public void setResume(String resume) {
	this.resume = resume;
}
	public resume() {
		// TODO Auto-generated constructor stub
	}

}

package com.xadmin.jobvault.bean;

public class company {
	private int c_id;
	private String company_name;
	private String email;
	private String password;
	private String mobile;
	private String address;
	private String logo;
	public company(String company_name, String email, String password, String mobile, String address, String logo) {
		super();
		this.company_name = company_name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
		this.logo = logo;
	}
	public company(int c_id, String company_name, String email, String password, String mobile, String address,
			String logo) {
		super();
		this.c_id = c_id;
		this.company_name = company_name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
		this.logo = logo;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public company(String company_name, String email, String password, String mobile, String address) {
		super();
		this.company_name = company_name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
	}
	public company(int c_id, String company_name, String email, String password, String mobile, String address) {
		super();
		this.c_id = c_id;
		this.company_name = company_name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
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

}

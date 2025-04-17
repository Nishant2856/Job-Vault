package com.xadmin.jobvault.bean;

public class job {
int j_id;
int c_id;
public int getC_id() {
	return c_id;
}
public void setC_id(int c_id) {
	this.c_id = c_id;
}
String title;
String required_years;
String salary;
String location;
String time_up;
String query;
String about;
String education_info;
String created_date ;
String visibility ;
public job(int j_id, int c_id, String title, String required_years, String salary, String location, String time_up,
		String query, String about, String education_info, String created_date, String visibility) {
	super();
	this.j_id = j_id;
	this.c_id = c_id;
	this.title = title;
	this.required_years = required_years;
	this.salary = salary;
	this.location = location;
	this.time_up = time_up;
	this.query = query;
	this.about = about;
	this.education_info = education_info;
	this.created_date = created_date;
	this.visibility = visibility;
}
public String getVisibility() {
	return visibility;
}
public void setVisibility(String visibility) {
	this.visibility = visibility;
}
public job(int j_id, int c_id, String title, String required_years, String salary, String location, String time_up,
		String query, String about, String education_info, String created_date) {
	super();
	this.j_id = j_id;
	this.c_id = c_id;
	this.title = title;
	this.required_years = required_years;
	this.salary = salary;
	this.location = location;
	this.time_up = time_up;
	this.query = query;
	this.about = about;
	this.education_info = education_info;
	this.created_date = created_date;
}
public String getCreated_date() {
	return created_date;
}
public void setCreated_date(String created_date) {
	this.created_date = created_date;
}
public int getJ_id() {
	return j_id;
}
public void setJ_id(int j_id) {
	this.j_id = j_id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getRequired_years() {
	return required_years;
}
public void setRequired_years(String required_years) {
	this.required_years = required_years;
}
public String getSalary() {
	return salary;
}
public void setSalary(String salary) {
	this.salary = salary;
}
public job( String title, int c_id,  String required_years, String salary, String location, String time_up, String query,
		String about, String education_info ) {
	super();

	this.title = title;
	this.c_id = c_id;
	
	this.required_years = required_years;
	this.salary = salary;
	this.location = location;
	this.time_up = time_up;
	this.query = query;
	this.about = about;
	this.education_info = education_info;
}
public job(int j_id, String title, String required_years, String salary, String location, String time_up, String query,
		String about, String education_info) {
	super();
	this.j_id = j_id;
	this.title = title;
	this.required_years = required_years;
	this.salary = salary;
	this.location = location;
	this.time_up = time_up;
	this.query = query;
	this.about = about;
	this.education_info = education_info;
}
public job(int j_id, int c_id, String title, String required_years, String salary, String location, String time_up,
		String query, String about, String education_info) {
	super();
	this.j_id = j_id;
	this.c_id = c_id;
	this.title = title;
	this.required_years = required_years;
	this.salary = salary;
	this.location = location;
	this.time_up = time_up;
	this.query = query;
	this.about = about;
	this.education_info = education_info;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getTime_up() {
	return time_up;
}
public void setTime_up(String time_up) {
	this.time_up = time_up;
}
public String getQuery() {
	return query;
}
public void setQuery(String query) {
	this.query = query;
}
public String getAbout() {
	return about;
}
public void setAbout(String about) {
	this.about = about;
}
public String getEducation_info() {
	return education_info;
}
public void setEducation_info(String education_info) {
	this.education_info = education_info;
}
}

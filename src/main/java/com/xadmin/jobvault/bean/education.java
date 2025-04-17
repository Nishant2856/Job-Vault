package com.xadmin.jobvault.bean;

public class education {
	private int e_id;
	private int u_id;
	private String education;
	private String institution;
	private String curse;
	private String Specialization ;
	private String start;
	private String end;
	private String curse_type;
	public education(int u_id, String education, String institution, String curse, String specialization, String start,
			String end, String curse_type) {
		super();
		this.u_id = u_id;
		this.education = education;
		this.institution = institution;
		this.curse = curse;
		Specialization = specialization;
		this.start = start;
		this.end = end;
		this.curse_type = curse_type;
	}
	public education(int e_id, int u_id, String education, String institution, String curse, String specialization,
			String start, String end, String curse_type) {
		super();
		this.e_id = e_id;
		this.u_id = u_id;
		this.education = education;
		this.institution = institution;
		this.curse = curse;
		Specialization = specialization;
		this.start = start;
		this.end = end;
		this.curse_type = curse_type;
	}
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getCurse() {
		return curse;
	}
	public void setCurse(String curse) {
		this.curse = curse;
	}
	public String getSpecialization() {
		return Specialization;
	}
	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getCurse_type() {
		return curse_type;
	}
	public void setCurse_type(String curse_type) {
		this.curse_type = curse_type;
	}
}

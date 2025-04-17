package com.xadmin.jobvault.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.List;

import com.xadmin.jobvault.bao.companyDao;
import com.xadmin.jobvault.bao.jobDao;
import com.xadmin.jobvault.bao.skillsDao;
import com.xadmin.jobvault.bao.userDao;
import com.xadmin.jobvault.bao.applicantsDao;
import com.xadmin.jobvault.bao.projectDao;
import com.xadmin.jobvault.bao.educationDao;
import com.xadmin.jobvault.bao.profileDao;
import com.xadmin.jobvault.bao.resumeDao;
import com.xadmin.jobvault.bean.JobApplicants;
import com.xadmin.jobvault.bean.company;
import com.xadmin.jobvault.bean.education;
import com.xadmin.jobvault.bean.job;
import com.xadmin.jobvault.bean.skills;
import com.xadmin.jobvault.bean.user;
import com.xadmin.jobvault.bean.profile;
import com.xadmin.jobvault.bean.project;
import com.xadmin.jobvault.bean.resume;

import java.io.*;
import java.io.*;
import java.sql.*;


/**
 * Servlet implementation class jobVaultServlet
 */
@WebServlet("/")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
	maxFileSize = 1024 * 1024 * 10, // 10MB
	maxRequestSize = 1024 * 1024 * 50)
public class jobVaultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
userDao userDao;
companyDao companyDao;
jobDao jobDao;
applicantsDao applicantsDao;
skillsDao skillsDao;
educationDao educationDao;
profileDao profileDao ;
resumeDao resumeDao;
projectDao projectDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		userDao = new userDao();
		companyDao = new companyDao();
		 jobDao = new jobDao();
		 applicantsDao = new applicantsDao();
		 skillsDao = new skillsDao();
		 educationDao = new educationDao();
		 profileDao = new profileDao();
		 resumeDao = new resumeDao();
		 projectDao = new projectDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		switch(action) {
		
		case "/userlogin":
			loginUser(request, response);
			break;
		case "/registeruser":
			registerUser(request, response);
			
		case "/loginCompany":
			loginCompany(request, response);
			break;
		case "/registerCompany":
			registerCompany(request, response);
			break;
		case"/jobmanage":
			jobmanage(request, response);
			break;
		case"/addjob":
			addJob(request, response);
			break;
		case"/showaddjob":
			showaddJob(request, response);
			break;
		case"/showeditJob":
			showeditJob(request, response);
			break;
		case"/editjob":
			editJob(request, response);
			break;
		case"/deleteJob":
			deletJob(request, response);
			break;
		case"/home":
			Home(request, response);
			break;
		case"/view-profile":
			userViewProfile(request, response);
			break;
		case"/showuserupdate":
			showuserupdate(request, response);
			break;
		case"/welcome":
			Welcome(request, response);
			break;
		case"/edituser":
		updateuser(request, response);
			break;
		case"/logout":
			logout(request, response);
				break;
		case"/company-jobs":
			companyJobs(request, response);
				break;
		case"/apply-job":
			jobApply(request, response);
				break;
		case"/all-companies":
			allCompanies(request, response);
				break;
		case"/userappliedjob":
			userappliedjob(request, response);
				break;
		case"/applyjob":
			applyJob(request, response);
				break;
		case"/jobapplicants":
			companyjobapplicants(request, response);
				break;
		case"/accept-user":
			acceptUser(request, response);
				break;
		case"/reject-user":
			rejectUser(request, response);
				break;
		case"/showcompanyprofile":
			showcompanyprifle(request, response);
				break;
		case"/showcompanedit":
			showcompanypdate(request, response);
				break;
		case"/updateCompany":
			updatecompanyr(request, response);
				break;
		case"/user-skills":
			showuserSkills(request, response);
				break;
		case"/add-skills":
			addSkills(request, response);
				break;
		case"/user-education":
			showuserEdu(request, response);
				break;
		case"/add-education":
			addEducation(request, response);
				break;
		case"/skill_view":
			getSkills(request, response);
				break;
		case"/showprofileSummary":
			agetEducation(request, response);
				break;
		case"/addprofileSummary":
			addProfile(request, response);
				break;
		case"/addresume":
			addresume(request, response);
				break;
				
		case"/applicant-resume":
			applicantDoc(request, response);
				break;	
		case"/unvisibe":
			unvisible(request, response);
				break;	
		case"/visibe":
			visible(request, response);
				break;	
				
		case"/showuserproject":
			showuserproject(request, response);
				break;	
		case"/useraddproject":
			useraddproject(request, response);
				break;
				
		case"/admin-registered-users":
			showallusers(request, response);
				break;
				
		case"/delete-user":
			deletUser(request, response);
				break;	
		case"/registered-companies":
			showregisteredCompany(request, response);
				break;	
		case"/deletecompany":
			deleteCompany(request, response);
				break;	
		case"/companyJobs":
			jobCompany(request, response);
				break;
		case"/deleteJJob":
			deletJJob(request, response);
				break;
				
				
	
		default:
			Welcome(request, response);
			break;
		}
	}
	
	 private void deletJJob(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {

	    	int j_id = Integer.parseInt(request.getParameter("j_id"));
	    	int c_id = Integer.parseInt(request.getParameter("c_id"));
	    	jobDao.deleteJob(j_id, c_id);
	    	
	    	
	    		response.sendRedirect("companyJobs?c_id="+c_id);
	    
	    	
	    	
	    	
	    }
	
	
	 private void jobCompany(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {
		  	int c_id = Integer.parseInt(request.getParameter("c_id"));
		 List<job> jobs = jobDao.showJobs(c_id);
		 company company = companyDao.companyDetails(c_id);
			RequestDispatcher dispatecher = request.getRequestDispatcher("admin-registred-company-jobs.jsp");
			request.setAttribute("jobs", jobs);
			request.setAttribute("company", company);
			dispatecher.forward(request,response);
	    	
	    }
	
	
	
	 private void deletUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {

	    	int u_id = Integer.parseInt(request.getParameter("u_id"));
	    	userDao.deleteUser(u_id);
	    	
	    	
	    		response.sendRedirect("admin-registered-users");
	    
	    	
	    	
	    	
	    }
	
	
	 private void deleteCompany(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {

	    	int c_id = Integer.parseInt(request.getParameter("c_id"));
	    	companyDao.deleteCompany(c_id);
	    	
	    	
	    		response.sendRedirect("registered-companies");
	    
	    	
	    	
	    	
	    }
	
	 private void showregisteredCompany(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {

		 List<company> companies = companyDao.allcompanies();

			RequestDispatcher dispatecher = request.getRequestDispatcher("admin-registred-company.jsp");

			request.setAttribute("companies", companies);
			dispatecher.forward(request,response);
	    	
	    }
	
	 private void showallusers( HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {


	     List<user>  users = userDao.allUsers();;
	    	RequestDispatcher dispatecher = request.getRequestDispatcher("admin-register-users.jsp");
  	request.setAttribute("users", users);

  	dispatecher.forward(request,response);
	    
	    }
	
	private void useraddproject(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {

    	int u_id = Integer.parseInt(request.getParameter("u_id"));
    	String title = request.getParameter("title");
    	String client_name = request.getParameter("client_name");
    	String status = request.getParameter("status");
    	String months = request.getParameter("months");
    	String years = request.getParameter("years");
    	String details = request.getParameter("details");
    
    	project newuser = new project(  u_id,  title,  client_name,  status,  months,years,  details)  ;
    	int result = projectDao.addProject(newuser);
    	if(result > 0) {
 
            response.sendRedirect("view-profile?u_id="+u_id);
    	}else {
    		response.sendRedirect("user-project?u_id="+u_id);

    	}
    }

	private void showuserproject( HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {

    	int u_id = Integer.parseInt(request.getParameter("u_id"));
     	user userdetails = userDao.userDetails(u_id);
 
     
    	RequestDispatcher dispatecher = request.getRequestDispatcher("user-projects.jsp");
 	request.setAttribute("user", userdetails);

 	dispatecher.forward(request,response);
    
    }
	
	private void visible( HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {

    	int c_id = Integer.parseInt(request.getParameter("c_id"));
    	
    	int j_id = Integer.parseInt(request.getParameter("j_id"));
    	jobDao.visible(j_id);
    	
    	response.sendRedirect("jobmanage?c_id="+c_id);
    
    }
	
	private void unvisible( HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {

    	int c_id = Integer.parseInt(request.getParameter("c_id"));
    	
    	int j_id = Integer.parseInt(request.getParameter("j_id"));
    	jobDao.unvisible(j_id);
    	
    	response.sendRedirect("jobmanage?c_id="+c_id);
    
    }

	
	 private void applicantDoc( HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {

	    	int c_id = Integer.parseInt(request.getParameter("c_id"));
	    	
	    	int u_id = Integer.parseInt(request.getParameter("u_id"));
	    	
	    	user userdetails = userDao.userDetails(u_id);
	    	company company = companyDao.companyDetails(c_id);
	    	resume resume =resumeDao.getResume(u_id);
	    	profile profile =profileDao.getProfile(u_id);
	     List<skills>	 skills = skillsDao.getSkills(u_id);
	     List<education>  education = educationDao.getEducation(u_id);
	     List<project>  project = projectDao.getProjects(u_id);
	    	RequestDispatcher dispatecher = request.getRequestDispatcher("user-details.jsp");
     	request.setAttribute("user", userdetails);
     	request.setAttribute("company", company);
     	request.setAttribute("resume", resume);
    	request.setAttribute("skills", skills);
    	request.setAttribute("education", education);
    	request.setAttribute("profile", profile);
    	request.setAttribute("project", project);
     	dispatecher.forward(request,response);
	    
	    }
	
	 private void addresume(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    { 
		 
	    	
	        Part part = request.getPart("file");//
	        int u_id = Integer.parseInt(request.getParameter("u_id"));
	    	resume newuser = new resume(u_id);
	    	int result = resumeDao.createResume(newuser ,part);
	    	
	    	  response.sendRedirect("view-profile?u_id="+u_id);
	    	
	    	
	    }
	
	
	
	 private void addProfile(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {

	    	int u_id = Integer.parseInt(request.getParameter("u_id"));
	    	String summary = request.getParameter("summary");
	    	
	    	profile newuser = new profile(  u_id, summary)  ;
	    	int result = profileDao.addProfile(newuser);
	    	if(result > 0) {
	 
	            response.sendRedirect("view-profile?u_id="+u_id);
	    	}else {
	    		response.sendRedirect("showprofileSummary?u_id="+u_id);
	
	    	}
	    }
	
	 private void addEducation(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {

	    	int u_id = Integer.parseInt(request.getParameter("u_id"));
	    	String education = request.getParameter("education");
	    	String institution = request.getParameter("institution");
	    	String Course = request.getParameter("Course");
	    	String Specialization = request.getParameter("Specialization");
	    	String start_date = request.getParameter("start_date");
	    	String end_date = request.getParameter("end_date");
	    	String Course_type = request.getParameter("Course_type");
	    	education newuser = new education(  u_id,  education,  institution,  Course,  Specialization,start_date,  end_date,  Course_type)  ;
	    	int result = educationDao.addEducation(newuser);
	    	if(result > 0) {
	 
	            response.sendRedirect("view-profile?u_id="+u_id);
	    	}else {
	    		response.sendRedirect("user-education?u_id="+u_id);
	
	    	}
	    }
	 private void getSkills(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {

	    	int s_id = Integer.parseInt(request.getParameter("u_id"));
	    	
	    	skills  result = skillsDao.getSkill(s_id);
	    	int u_id = Integer.parseInt(request.getParameter("u_id"));
	    	user userdetails = userDao.userDetails(u_id);
	    	RequestDispatcher dispatecher = request.getRequestDispatcher("user-skills.jsp");
        	request.setAttribute("user", userdetails);
        	request.setAttribute("skill",result );
        	dispatecher.forward(request,response);
	    
	    }
	 private void agetEducation(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {

	    	int u_id = Integer.parseInt(request.getParameter("u_id"));
	    	user userdetails = userDao.userDetails(u_id);
    		RequestDispatcher dispatecher = request.getRequestDispatcher("user-summary-profile.jsp");
        	request.setAttribute("user", userdetails);
        	request.setAttribute("update", "update");
        	dispatecher.forward(request,response);
	    	
	    	
	    
	    }
	 private void addSkills(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {

	    	int u_id = Integer.parseInt(request.getParameter("u_id"));
	    	String name = request.getParameter("skill-name");
	    	String version = request.getParameter("version");
	    	String last_used = request.getParameter("last_used");
	    	String years = request.getParameter("years");
	    	String month = request.getParameter("months");
	    	
	    	skills newuser = new skills( u_id,name,version,  last_used,  years,  month) ;
	    	int result = skillsDao.addSkill(newuser);
	    	if(result > 0) {
	 
	            response.sendRedirect("view-profile?u_id="+u_id);
	    	}else {
	    		response.sendRedirect("user-skills?u_id="+u_id);
	
	    	}
	    }
	private void showuserSkills(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
    	
    	int u_id = Integer.parseInt(request.getParameter("u_id"));
    	user userdetails = userDao.userDetails(u_id);
    		RequestDispatcher dispatecher = request.getRequestDispatcher("user-skills.jsp");
        	request.setAttribute("user", userdetails);
        	request.setAttribute("update", "update");
        	dispatecher.forward(request,response);
        	
    	
    	
    	
    	
    }
	
	private void showuserEdu(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
    	
    	int u_id = Integer.parseInt(request.getParameter("u_id"));
    	user userdetails = userDao.userDetails(u_id);
    		RequestDispatcher dispatecher = request.getRequestDispatcher("user-education.jsp");
        	request.setAttribute("user", userdetails);
        	request.setAttribute("update", "update");
        	dispatecher.forward(request,response);
        	
    	
    	
    	
    	
    }
	 private void updatecompanyr(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {

	    	int c_id = Integer.parseInt(request.getParameter("c_id"));
	    	String name = request.getParameter("company_name");
	    	String email = request.getParameter("email");
	    	String password = request.getParameter("password");
	    	String number = request.getParameter("number");
	    	String address = request.getParameter("address");
	    	
	    	company newuser = new company(c_id , name , email,password , number , address);
	    	int result = companyDao.updateCompany(newuser);
	    	if(result > 0) {
	    	

	            // Set session attributes
	           
	            response.sendRedirect("showcompanyprofile?c_id="+c_id);
	    	}else {
	    		RequestDispatcher dispatecher = request.getRequestDispatcher("showuserupdate?u_id="+c_id);
	        	request.setAttribute("message", "Details not updated ");
	        	dispatecher.forward(request,response);
	    	}
	    	
	    	
	    	
	    }
	
	 private void showcompanypdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {
	    	
	    	int c_id = Integer.parseInt(request.getParameter("c_id"));
	    	company userdetails = companyDao.companyDetails(c_id);
	    		RequestDispatcher dispatecher = request.getRequestDispatcher("company-register.jsp");
	        	request.setAttribute("company", userdetails);
	        	request.setAttribute("update", "update");
	        	dispatecher.forward(request,response);
	        	
	    	
	    	
	    	
	    	
	    }
	
	
	 private void showcompanyprifle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {
	    	
	    	int c_id = Integer.parseInt(request.getParameter("c_id"));
	    	company company = companyDao.companyDetails(c_id);
	    		RequestDispatcher dispatecher = request.getRequestDispatcher("company-profile.jsp");
	        	request.setAttribute("company", company);
	        	
	        	dispatecher.forward(request,response);
	        	
	    	
	    	
	    	
	    	
	    }
	 
	
	 private void acceptUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {
	    	
	    		int a_id = Integer.parseInt(request.getParameter("a_id"));
	    		applicantsDao.acceptUser(a_id);
	    		JobApplicants ja = applicantsDao.getDetails(a_id);
	    		response.sendRedirect("jobapplicants?c_id="+ja.getC_id());
	    		
	    		
	   
	    	
	    	
	    	
	    	
	    }
	 private void rejectUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {
	    	
			int a_id = Integer.parseInt(request.getParameter("a_id"));
    		applicantsDao.rejectUser(a_id);
    		JobApplicants ja = applicantsDao.getDetails(a_id);
    		
    		response.sendRedirect("jobapplicants?c_id="+ja.getC_id());
	    	
	    	
	    	
	    	
	    }
	 private void companyjobapplicants(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {
	    	
	    		int c_id = Integer.parseInt(request.getParameter("c_id"));
	    		List<JobApplicants> applicanst = applicantsDao.companygetuserApply(c_id);
	    		company company = companyDao.companyDetails(c_id);
	    		
	    		RequestDispatcher dispatecher = request.getRequestDispatcher("company-job-applicants.jsp");
	    		
	        	request.setAttribute("applicanst", applicanst);
	        	request.setAttribute("company", company);
	        	dispatecher.forward(request,response);
	   
	    	
	    	
	    	
	    	
	    }
	 private void Home(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {
	    	List<company> companies = companyDao.allcompanies();
	    		int u_id = Integer.parseInt(request.getParameter("u_id"));
	    	
	    		user userdetails = userDao.userDetails(u_id);
	    		RequestDispatcher dispatecher = request.getRequestDispatcher("home.jsp");
	        	request.setAttribute("user", userdetails);
	        	request.setAttribute("companies", companies);
	        	dispatecher.forward(request,response);
	   
	    	
	    	
	    	
	    	
	    }
	 
	 private void applyJob(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {
	    	
	    		int j_id = Integer.parseInt(request.getParameter("j_id"));
	    	
	    		job jobdetails = jobDao.getJobdetail(j_id);
	    		int c_id = jobdetails.getC_id();
	    		String title = jobdetails.getTitle();
	    
	    		HttpSession session = request.getSession(false);
	    		
	    		 int u_id =  Integer.parseInt((String) session.getAttribute("user"));
	    		 user user = userDao.userDetails(u_id);
	    		 String username = user.getFull_name();
	    		 String email = user.getEmail();
	    		 String number = user.getMobile();
	    		 JobApplicants applicants = new JobApplicants(u_id , c_id,j_id ,title,username,email,number);
	    		applicantsDao.userApply(applicants);
	    		response.sendRedirect("apply-job?j_id="+j_id);
	    		
	   
	    	
	    	
	    	
	    	
	    }
	 
	 
	 private void userappliedjob(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {
	    	
	    		int u_id = Integer.parseInt(request.getParameter("u_id"));
	    		List<JobApplicants> JobApplicants = applicantsDao.getuserApply(u_id);
	    		user userdetails = userDao.userDetails(u_id);
	    		RequestDispatcher dispatecher = request.getRequestDispatcher("user-applies-jobs.jsp");
	        	request.setAttribute("user", userdetails);
	        	request.setAttribute("JobApplicants", JobApplicants);
	        	dispatecher.forward(request,response);
	   
	    	
	    	
	    	
	    	
	    }
	 
	 
	 private void Welcome(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {
	    	
	
		 List<company> companies = companyDao.allcompanies();

 		RequestDispatcher dispatecher = request.getRequestDispatcher("home.jsp");
     
     	request.setAttribute("companies", companies);
     	dispatecher.forward(request,response);


	    	
	    }
	 
	 
	 private void allCompanies(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {
	    	
	
			List<company> companies = companyDao.allcompanies();
    		int u_id = Integer.parseInt(request.getParameter("u_id"));
    	
    		user userdetails = userDao.userDetails(u_id);
    		RequestDispatcher dispatecher = request.getRequestDispatcher("more-jobs.jsp");
        	request.setAttribute("user", userdetails);
        	request.setAttribute("companies", companies);
        	dispatecher.forward(request,response);


	    	
	    }
	 private void companyJobs(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {
	    	

	        
	        // Store the data in the request object
	   
		 int c_id = Integer.parseInt(request.getParameter("c_id"));
		 HttpSession session = request.getSession(false);
	    	int u_id =  Integer.parseInt((String) session.getAttribute("user"));
	    	
	    	 user user = userDao.userDetails(u_id);
	 	 List<job> jobs = jobDao.usershowJobs(c_id);
	 	 company company = companyDao.companyDetails(c_id);
	    
		   
	 		RequestDispatcher dispatecher = request.getRequestDispatcher("company-jobs.jsp");
    		request.setAttribute("jobs", jobs);
    		request.setAttribute("company", company);
    		request.setAttribute("user", user);
    		 	
        	dispatecher.forward(request,response);


	    	
	    }
	 private void updateuser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {

	    	int u_id = Integer.parseInt(request.getParameter("u_id"));
	    	String name = request.getParameter("name");
	    	String email = request.getParameter("email");
	    	String password = request.getParameter("password");
	    	String number = request.getParameter("number");
	    	String address = request.getParameter("address");
	    	String job_status = request.getParameter("country");
	    	user newuser = new user(u_id , name , email,password , number , address,job_status);
	    	int result = userDao.update(newuser);
	    	if(result > 0) {
	    	

	            // Set session attributes
	           
	            response.sendRedirect("view-profile?u_id="+u_id);
	    	}else {
	    		RequestDispatcher dispatecher = request.getRequestDispatcher("showuserupdate?u_id="+u_id);
	        	request.setAttribute("message", "Details not updated ");
	        	dispatecher.forward(request,response);
	    	}
	    	
	    	
	    	
	    }
	 
	 private void showuserupdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {
	    	
	    	int u_id = Integer.parseInt(request.getParameter("u_id"));
	    	user userdetails = userDao.userDetails(u_id);
	    		RequestDispatcher dispatecher = request.getRequestDispatcher("user-register.jsp");
	        	request.setAttribute("user", userdetails);
	        	request.setAttribute("update", "update");
	        	dispatecher.forward(request,response);
	        	
	    	
	    	
	    	
	    	
	    }
	 
	 private void jobApply(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {
	    	
	    	int j_id = Integer.parseInt(request.getParameter("j_id"));
	    	job jobDetails = jobDao.getJobdetail(j_id);
	    	int c_id = jobDetails.getC_id();

    	
    		
	    	company company = companyDao.companyDetails(c_id);
	    	RequestDispatcher dispatecher = request.getRequestDispatcher("job-more-info.jsp");
	    	HttpSession session = request.getSession(false);
	    	int u_id =  Integer.parseInt((String) session.getAttribute("user"));
	    	JobApplicants checkuser = applicantsDao.userapplicants(u_id , j_id);
	    	 user user = userDao.userDetails(u_id);
	    	request.setAttribute("checkuser", checkuser);
	    	if(checkuser != null) {
	    		request.setAttribute("checkuser", "checkuser");
	    	}
	        	request.setAttribute("job", jobDetails);
	        	request.setAttribute("user", user);
	        	request.setAttribute("company", company);
	        	dispatecher.forward(request,response);
	        	
	    	
	    	
	    	
	    	
	    }
	 
	 private void userViewProfile(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {
	    	
	    	int u_id = Integer.parseInt(request.getParameter("u_id"));
	    	user userdetails = userDao.userDetails(u_id);
	    	List<education> education = educationDao.getEducation(u_id);
	    	List<skills> skills = skillsDao.getSkills(u_id);
	    	  List<project>  project = projectDao.getProjects(u_id);
	    	
	    	RequestDispatcher dispatecher = request.getRequestDispatcher("user-profile.jsp");
	        	request.setAttribute("user", userdetails);
	        	request.setAttribute("education", education);
	        	request.setAttribute("skills", skills);
	          	request.setAttribute("project", project);
	        	dispatecher.forward(request,response);
	    	
	    	
	    	
	    	
	    }
	 private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {
	    	
		 HttpSession session = request.getSession(false); // Get existing session, but do not create a new one
		 if (session != null) {
		     session.invalidate(); // Invalidate the session
		     response.sendRedirect("welcome");
		 }

	    	
	    	
	    	
	    	
	    }
	 
	 private void showaddJob(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {
	    		int c_id = Integer.parseInt(request.getParameter("c_id"));
	    		company com = companyDao.companyDetails(c_id);
	    		RequestDispatcher dispatecher = request.getRequestDispatcher("company-add-job.jsp");
	        	request.setAttribute("company", com);
	        	dispatecher.forward(request,response);
	    	
	    	
	    	
	    	
	    }
	 
	 private void jobmanage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {
	    	
		 	 int c_id = Integer.parseInt(request.getParameter("c_id"));
		 	 company companydetails = companyDao.companyDetails(c_id);
		 	 List<job> ListUser = jobDao.showJobs(c_id);

		 		RequestDispatcher dispatecher = request.getRequestDispatcher("company-manage-job.jsp");
	    		request.setAttribute("ListUser", ListUser);
	    		request.setAttribute("company", companydetails);
	        	dispatecher.forward(request,response);
		 
	    	
	    	
	    	
	    	
	    }
		
	 private void loginUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {

	    	String email = request.getParameter("email");
	    	String password = request.getParameter("password");
	     	if("admin@gmail.com".equals(email) && "123".equals(password)) {
	     		List<user> userdetails = userDao.allUsers();
	     		RequestDispatcher dispatecher = request.getRequestDispatcher("admin-register-users.jsp");
	     		request.setAttribute("users", userdetails);
	         	dispatecher.forward(request,response);
	    		
	    	}
	    	
	    	user result = userDao.loginUser(email , password);
	    	if(result != null) {
	    		HttpSession session = request.getSession(true);

	            // Set session attributes
	    		String str = String.valueOf(result.getU_id());
	            session.setAttribute("user", str);
	            response.sendRedirect("home?u_id="+result.getU_id());
	    	}else {
	    		RequestDispatcher dispatecher = request.getRequestDispatcher("user-login.jsp");
	        	request.setAttribute("message", "Email or password incorrect");
	        	dispatecher.forward(request,response);
	    	}
	    	
	    	
	    	
	    }
	
	 
	 private void addJob(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {

	    	int c_id = Integer.parseInt(request.getParameter("c_id"));
	    	String title = request.getParameter("job_name");
	    	String required_years = request.getParameter("job_years");
	    	String salary = request.getParameter("job_salary");
	    	String location = request.getParameter("job_location");
	    	String time_up = request.getParameter("job_contact");
	    	String query = request.getParameter("job_contact");
	    	String about = request.getParameter("job_details");
	    	String education_info = request.getParameter("job_edu_info");
	   
	    	job newjob = new job(title, c_id  , required_years,  salary,  location,  time_up,  query, about,  education_info );
	    	int result = jobDao.addJob(newjob);
	    	if(result >  0) {
	    		response.sendRedirect("jobmanage?c_id="+c_id);
	    	}else {
	    		RequestDispatcher dispatecher = request.getRequestDispatcher("showaddjob?c_id="+c_id);
	        	request.setAttribute("message", " Job not added ");
	        	dispatecher.forward(request,response);
	    	}
	    	
	    	
	    	
	    }
	 
	 private void editJob(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {

	    	int j_id = Integer.parseInt(request.getParameter("j_id"));
	    	String title = request.getParameter("job_name");
	    	String required_years = request.getParameter("job_years");
	    	String salary = request.getParameter("job_salary");
	    	String location = request.getParameter("job_location");
	    	String time_up = request.getParameter("job_contact");
	    	String query = request.getParameter("job_contact");
	    	String about = request.getParameter("job_details");
	    	String education_info = request.getParameter("job_edu_info");
	   
	    	job newjob = new job(j_id ,title , required_years ,  salary,  location,  time_up,  query, about,  education_info );
	    	int result = jobDao.updateJob(newjob);
	    	if(result >  0) {
	    		job jo = jobDao.getJobdetail(j_id);
	    		response.sendRedirect("jobmanage?c_id="+jo.getC_id());
	    	}else {
	    		RequestDispatcher dispatecher = request.getRequestDispatcher("showeditJob?j_id="+j_id);
	        	request.setAttribute("message", " Job not updated ");
	        	dispatecher.forward(request,response);
	    	}
	    	
	    	
	    	
	    }
	 
	 private void deletJob(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {

	    	int j_id = Integer.parseInt(request.getParameter("j_id"));
	    
	    	job cc = jobDao.getJobdetail(j_id);
	    	int c_id = cc.getC_id();
	   
	    	int result = jobDao.deleteJob(j_id , c_id);
	    	if(result >  0) {
	    	
	    		response.sendRedirect("jobmanage?c_id="+c_id);
	    	}else {
	    		RequestDispatcher dispatecher = request.getRequestDispatcher("showeditJob?j_id="+j_id);
	        	request.setAttribute("message", " Job not updated ");
	        	dispatecher.forward(request,response);
	    	}
	    	
	    	
	    	
	    }
	 
	 private void showeditJob(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {
		 int j_id = Integer.parseInt(request.getParameter("j_id"));
		 	job result = jobDao.getJobdetail(j_id); 
	    	
	
	    		RequestDispatcher dispatecher = request.getRequestDispatcher("showaddjob?c_id="+result.getC_id());
	        	request.setAttribute("job",result);
	        	dispatecher.forward(request,response);
	    	
	    	
	    	
	    	
	    }
	 
	 
	 
	 private void loginCompany(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {

	    	String email = request.getParameter("email");
	    	String password = request.getParameter("password");
	   
	    	company result = companyDao.loginCompany(email , password);
	    	if(result != null) {
	    		HttpSession session = request.getSession(true);

	            // Set session attributes
	            session.setAttribute("company", result.getEmail());
	            response.sendRedirect("jobmanage?c_id="+result.getC_id());
	    	}else {
	    		RequestDispatcher dispatecher = request.getRequestDispatcher("company-login.jsp");
	        	request.setAttribute("message", "Email or password incorrect");
	        	dispatecher.forward(request,response);
	    	}
	    	
	    	
	    	
	    }

	 private void registerCompany(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    { 
		 
	    	String name = request.getParameter("company_name");
	    	String email = request.getParameter("email");
	    	String password = request.getParameter("password");
	    	String number = request.getParameter("number");
	    	String address = request.getParameter("address");

	        Part part = request.getPart("file");//
	    	company newuser = new company(name , email,password , number , address );
	    	int result = companyDao.createCompany(newuser ,part);
	    	if(result > 0) {
	    		RequestDispatcher dispatecher = request.getRequestDispatcher("company-login.jsp");
	        	request.setAttribute("message", "Account created please Login ");
	        	dispatecher.forward(request,response);
	    	}
	    	else {
	    		RequestDispatcher dispatecher = request.getRequestDispatcher("company-register.jsp");
	        	request.setAttribute("message", "Incorrect details ,Please Fill again");
	        	dispatecher.forward(request,response);
	    	}
	    	
	    	
	    	
	    }
	
	 
	 private void registerUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {
	    	
	    	String name = request.getParameter("name");
	    	String email = request.getParameter("email");
	    	String password = request.getParameter("password");
	    	String number = request.getParameter("number");
	    	String address = request.getParameter("address");
	    	String job_status = request.getParameter("country");
	    	user newuser = new user(name , email,password , number , address,job_status);
	    	int result = userDao.createUser(newuser);
	    	if(result > 0) {
	    		RequestDispatcher dispatecher = request.getRequestDispatcher("user-login.jsp");
	        	request.setAttribute("message", "Account created please Login ");
	        	dispatecher.forward(request,response);
	    	}
	    	else {
	    		RequestDispatcher dispatecher = request.getRequestDispatcher("user-register.jsp");
	        	request.setAttribute("message", "Incorrect details ,Please Fill again");
	        	dispatecher.forward(request,response);
	    	}
	    	
	    	
	    	
	    }
	 
}

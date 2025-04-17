package com.xadmin.jobvault.bao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xadmin.jobvault.bean.JobApplicants;
import com.xadmin.jobvault.bean.job;

public class applicantsDao {
	  String url = "jdbc:mysql://localhost:3306/jobvault";
	    String username = "root";
	    String driver = "com.mysql.cj.jdbc.Driver";
	    String password = "";
	    String user_apply = " insert into applicants(u_id , c_id ,j_id, status,title ,username,email,number) values(?,?,? , 'Pending',?,?,?,?)";
	    String check_user_apply = " select * from applicants where u_id=? and j_id=? ";
	    String check_use = " select * from applicants where u_id=? ";
	    String company_check_use =  " select * from applicants where c_id=? ";
	    String update = "update applicants set status = ? where a_id = ?";
	    String get_by_a_id =  " select * from applicants where a_id=? ";
	    
	public applicantsDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	  public Connection getConnection() {
	        Connection connection = null;
	        try {
	            Class.forName(driver);
	            connection = DriverManager.getConnection(url, username, password);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        return connection;
	    }
	  
	  public int userApply(JobApplicants u) {
	        int result = 0;
	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(user_apply)) {
	             
	            ps.setInt(1, u.getU_id());
	            ps.setInt(2, u.getC_id());
	            ps.setInt(3, u.getJ_id());
	            ps.setString(4, u.getTitle());
	            ps.setString(5, u.getUsername());
	            ps.setString(6, u.getEmail());
	            ps.setString(7, u.getNumber());
	            result = ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
	  
	  public int acceptUser(int a_id) {
	        int result = 0;
	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(update)) {
	             
	            ps.setInt(2 , a_id);
	            
	            ps.setString(1, "accepted");
	            result = ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
	  
	  public int rejectUser(int a_id) {
	        int result = 0;
	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(update)) {
	             
	            ps.setInt(2 , a_id);
	            
	            ps.setString(1, "rejected");
	            result = ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
	  
	  public JobApplicants getDetails( int a_id) {
		  JobApplicants result=  null ;
	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(get_by_a_id)) {
	             
	            ps.setInt(1,a_id);
	          
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	            	int  aa_id = rs.getInt("a_id");
	            	int  jj_id = rs.getInt("j_id");
	            	int  uu_id = rs.getInt("u_id");
	            	int  c_id = rs.getInt("c_id");
	            	String status = rs.getString("status");
	            	String date = rs.getString("date");
	            	String title = rs.getString("title");  
	            	
	                // Assuming the user bean has a constructor: user(int id, String name, String country, String mobile)
	                result = new JobApplicants( aa_id,  uu_id,  c_id,  jj_id ,date ,status ,title);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
	  
	  
	  public JobApplicants userapplicants(int u_id , int j_id) {
		  JobApplicants result=  null ;
	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(check_user_apply)) {
	             
	            ps.setInt(1,u_id);
	            ps.setInt(2,j_id);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	            	int  a_id = rs.getInt("a_id");
	            	int  jj_id = rs.getInt("j_id");
	            	int  uu_id = rs.getInt("u_id");
	            	int  c_id = rs.getInt("c_id");
	            	String status = rs.getString("status");
	            	String date = rs.getString("date");
	            	String title = rs.getString("title");  
	            	
	                // Assuming the user bean has a constructor: user(int id, String name, String country, String mobile)
	                result = new JobApplicants( a_id,  uu_id,  c_id,  jj_id ,date ,status ,title);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
	  
	  
	  public List<JobApplicants>   getuserApply(int u_id ) {
		    List<JobApplicants> result = new ArrayList<>();
	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(check_use)) {
	             
	            ps.setInt(1,u_id);
	          
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	int  a_id = rs.getInt("a_id");
	            	int  jj_id = rs.getInt("j_id");
	            	int  uu_id = rs.getInt("u_id");
	            	int  c_id = rs.getInt("c_id");
	            	String status = rs.getString("status");
	            	String date = rs.getString("date");
	            	String title = rs.getString("title");  
	            	String username = rs.getString("username"); 
	            	String email = rs.getString("email"); 
	            	String number = rs.getString("number"); 
	                // Assuming the user bean has a constructor: user(int id, String name, String country, String mobile)
	                JobApplicants j = new JobApplicants( a_id,  uu_id,  c_id,  jj_id ,date ,status,title,username,email,number);
	                result.add(j);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
	
	  public List<JobApplicants>   companygetuserApply(int j_id ) {
		    List<JobApplicants> result = new ArrayList<>();
	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(company_check_use)) {
	             
	            ps.setInt(1,j_id);
	          
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	int  a_id = rs.getInt("a_id");
	            	int  jj_id = rs.getInt("j_id");
	            	int  uu_id = rs.getInt("u_id");
	            	int  c_id = rs.getInt("c_id");
	            	String status = rs.getString("status");
	            	String date = rs.getString("date");
	            	String title = rs.getString("title");  
	            	String username = rs.getString("username"); 
	            	String email = rs.getString("email"); 
	            	String number = rs.getString("number"); 
	                // Assuming the user bean has a constructor: user(int id, String name, String country, String mobile)
	                JobApplicants j = new JobApplicants( a_id,  uu_id,  c_id,  jj_id ,date ,status,title,username,email,number);
	                result.add(j);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
	

}

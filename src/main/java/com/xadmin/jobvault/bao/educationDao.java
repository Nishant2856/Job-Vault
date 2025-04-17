package com.xadmin.jobvault.bao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xadmin.jobvault.bean.company;
import com.xadmin.jobvault.bean.education;
import com.xadmin.jobvault.bean.skills;

public class educationDao {

	  String url = "jdbc:mysql://localhost:3306/jobvault";
	    String username = "root";
	    String driver = "com.mysql.cj.jdbc.Driver";
	    String password = "";
	    String insert = "insert into education(u_id , education ,institution,course , Specialization  ,start ,end,course_type) values(?,?,?,?,?,?,?,?)";
	    String get_skill = "select * from education where u_id = ?";
	public educationDao() {
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

	// Insert a new user into the database
	    public int addEducation(education u) {
	        int result = 0;
	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(insert)) {
	        	ps.setInt(1, u.getU_id());
	            ps.setString(2, u.getEducation());
	         
	            ps.setString(3, u.getInstitution());
	            ps.setString(4, u.getCurse());
	            ps.setString(5, u.getSpecialization());
	            ps.setString(6, u.getStart());
	            ps.setString(7, u.getEnd());
	            ps.setString(8, u.getCurse_type());
	            result = ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
	    
	    public  List<education> getEducation(int u_id ) {
	    
	    	  List<education> u = new ArrayList<>();
	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(get_skill)) {
	             
	        	ps.setInt(1, u_id);
	          
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	 int uu_id = rs.getInt("u_id");
	            	 int e_id = rs.getInt("e_id");
	                String education = rs.getString("education");
	                String institution = rs.getString("institution");
	                String course = rs.getString("course");
	                String Specialization	 = rs.getString("Specialization");
	                String start = rs.getString("start");
	                String end = rs.getString("end");
	                String course_type = rs.getString("course_type");
	                // Assuming the user bean has a constructor: user(int id, String name, String country, String mobile)
	                education j  = new education( e_id,  uu_id,  education,  institution,  course,  Specialization,
	            			 start,  end,  course_type)  ;
	                u.add(j);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return u;
	    }

}

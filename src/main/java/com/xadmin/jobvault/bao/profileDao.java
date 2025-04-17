package com.xadmin.jobvault.bao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xadmin.jobvault.bean.profile;
import com.xadmin.jobvault.bean.skills;

public class profileDao {

	  String url = "jdbc:mysql://localhost:3306/jobvault";
	    String username = "root";
	    String driver = "com.mysql.cj.jdbc.Driver";
	    String password = "";
	    String insert = "insert into profile(u_id , summary) values(?,?)";
	    String get_skill = "select * from profile where u_id = ?";
	public profileDao() {
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
	    public int addProfile(profile u) {
	        int result = 0;
	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(insert)) {
	        	ps.setInt(1, u.getU_id());
	            ps.setString(2, u.getSummary());
	         
	            
	            result = ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
	
	    
	    public profile getProfile( int u_id) {
	    	profile result = null;
	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(get_skill)) {
	        	ps.setInt(1, u_id);
	            
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	            	 int uu_id = rs.getInt("u_id");
	            	 int p_id = rs.getInt("p_id");
	                String skill_name = rs.getString("summary");
	                result = new  profile(p_id,uu_id ,skill_name);
	               
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
	
	

}

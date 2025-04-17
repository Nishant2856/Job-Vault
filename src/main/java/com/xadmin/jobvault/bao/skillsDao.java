package com.xadmin.jobvault.bao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xadmin.jobvault.bean.skills;
import com.xadmin.jobvault.bean.user;

public class skillsDao {
	  String url = "jdbc:mysql://localhost:3306/jobvault";
	    String username = "root";
	    String driver = "com.mysql.cj.jdbc.Driver";
	    String password = "";
	    String insert = "insert into skill(u_id , skill_name ,version,month , year ,lastuser) values(?,?,?,?,?,?)";
	    String get_skill = "SELECT * FROM skill where u_id = ? ";
	    String skill = "SELECT * FROM skill where s_id = ? ";
	public skillsDao() {
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
	    public int addSkill(skills u) {
	        int result = 0;
	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(insert)) {
	        	ps.setInt(1, u.getU_id());
	            ps.setString(2, u.getSkill_name());
	         
	            ps.setString(3, u.getVersion());
	            ps.setString(4, u.getMonth());
	            ps.setString(5, u.getYears());
	            ps.setString(6, u.getLast_used());
	            
	            result = ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
	    
	    public List<skills> getSkills(int u_id ) {
	    	List<skills>  u =  new ArrayList<>();
	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(get_skill)) {
	             
	        	ps.setInt(1, u_id);
	          
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	 int uu_id = rs.getInt("u_id");
	            	 int s_id = rs.getInt("s_id");
	                String skill_name = rs.getString("skill_name");
	                String version = rs.getString("version");
	                String months = rs.getString("month");
	                String years = rs.getString("year");
	                String last_used = rs.getString("lastuser");
	              
	                // Assuming the user bean has a constructor: user(int id, String name, String country, String mobile)
	               skills ur = new skills( s_id, uu_id,  skill_name,  version,  last_used,  years,  months) ;
	               u.add(ur);
	            }
	          

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return u;
	    }
	    
	    public skills getSkill(int s_id ) {
	    	skills  u = null;
	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(skill)) {
	             
	        	ps.setInt(1, s_id);
	          
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	            	 int uu_id = rs.getInt("u_id");
	            	 int ss_id = rs.getInt("s_id");
	                String skill_name = rs.getString("skill_name");
	                String version = rs.getString("version");
	                String months = rs.getString("month");
	                String years = rs.getString("year");
	                String last_used = rs.getString("lastuser");
	              
	                // Assuming the user bean has a constructor: user(int id, String name, String country, String mobile)
	              u = new skills( s_id, uu_id,  skill_name,  version,  last_used,  years,  months) ;
	               
	            }
	          

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return u;
	    }
	
	

}

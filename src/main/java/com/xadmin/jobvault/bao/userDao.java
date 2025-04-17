package com.xadmin.jobvault.bao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xadmin.jobvault.bean.user;

public class userDao {
    String url = "jdbc:mysql://localhost:3306/jobvault";
    String username = "root";
    String driver = "com.mysql.cj.jdbc.Driver";
    String password = "";
    
    // SQL queries
    String insert_user = "insert into user(full_name, email, password , mobile_number, address ,work_status) values(?,?,?,?,?,'Fresher')";
    String login_user = "select * from user where email = ? and  password = ?";
    String select_user = "select * from user where u_id =?";
    String update_user = "update user set full_name = ?, email = ?, password = ?, " +"mobile_number = ?, address = ? " +"where u_id = ?";
    String select_all_user = "SELECT * FROM user";
    String delete_user = " delete from user where u_id =?";
	public userDao() {
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
	    public int createUser(user u) {
	        int result = 0;
	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(insert_user)) {
	             
	            ps.setString(1, u.getFull_name());
	            ps.setString(2, u.getEmail());
	            ps.setString(3, u.getPassword());
	            ps.setString(4, u.getMobile());
	            ps.setString(5, u.getAddress());
	           
	            
	            result = ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
	
	    public int deleteUser(int u_id) {
	        int result = 0;
	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(delete_user)) {
	             
	            ps.setInt(1, u_id);
	            result = ps.executeUpdate();
	            if(result > 0) {
	            	 System.out.println(result + " record(s) deleted.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
	
	   
	    public int update(user u) {
	        int result = 0;
	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(update_user)) {
	             
	            ps.setString(1, u.getFull_name());
	            ps.setString(2, u.getEmail());
	            ps.setString(3, u.getPassword());
	            ps.setString(4, u.getMobile());
	            ps.setString(5, u.getAddress());
	        
	            ps.setInt(6, u.getU_id());
	            result = ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
	    
	    // Retrieve a single user by id
	    public user loginUser(String email , String password ) {
	        user u = null;
	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(login_user)) {
	             
	        	ps.setString(1, email);
	            ps.setString(2, password);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	            	 int u_id = rs.getInt("u_id");
	            	 System.out.println(u_id);
	                String name = rs.getString("full_name");
	                String eemail = rs.getString("email");
	                String pass = rs.getString("password");
	                String mobile = rs.getString("mobile_number");
	                String address = rs.getString("address");
	                String work_status = rs.getString("work_status");
	                // Assuming the user bean has a constructor: user(int id, String name, String country, String mobile)
	                u = new user(u_id, name,  eemail, pass , mobile ,address ,work_status);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return u;
	    }
	
	    
	
		public List<user> allUsers( ) {
	    	List<user>u = new ArrayList<>();
	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(select_all_user)) {
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	int uu_id = rs.getInt("u_id");
	                String name = rs.getString("full_name");
	                String eemail = rs.getString("email");
	                String pass = rs.getString("password");
	                String mobile = rs.getString("mobile_number");
	                String address = rs.getString("address");
	                String work_status = rs.getString("work_status");
	                String created_date = rs.getString("created_date");
	                // Assuming the user bean has a constructor: user(int id, String name, String country, String mobile)
	               user ur = new user(uu_id ,name,  eemail, pass , mobile ,address ,work_status ,created_date);
	               u.add(ur);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return u;
	    }
	    
	    
	    public user userDetails(int u_id) {
	        user u = null;
	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(select_user)) {
	             
	        	ps.setInt(1, u_id);
	      
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	            	int uu_id = rs.getInt("u_id");
	                String name = rs.getString("full_name");
	                String eemail = rs.getString("email");
	                String pass = rs.getString("password");
	                String mobile = rs.getString("mobile_number");
	                String address = rs.getString("address");
	                String work_status = rs.getString("work_status");
	                // Assuming the user bean has a constructor: user(int id, String name, String country, String mobile)
	                u = new user(uu_id ,name,  eemail, pass , mobile ,address ,work_status);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return u;
	    }

}

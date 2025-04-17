package com.xadmin.jobvault.bao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xadmin.jobvault.bean.company;
import com.xadmin.jobvault.bean.job;
import com.xadmin.jobvault.bean.user;

public class jobDao {

    String url = "jdbc:mysql://localhost:3306/jobvault";
    String username = "root";
    String driver = "com.mysql.cj.jdbc.Driver";
    String password = "";
    
    // SQL queries
    String insert_user = "insert into job(title, required_years, salary , location, time_up ,query,about,education_info,c_id) values(?,?,?,?,?,?,?,?,?)";
    String select_job_by_j_id = "select * from job where j_id = ?";
    String select_users = "select * from job where c_id = ? ";
    String delete_job = " delete from job where j_id= ? and c_id = ?";
    String update_visibility = " update job set visibility =? where j_id=?";
   String  visible_jobs  = "select * from job where c_id = ? and visibility = 'visible'";
    String update_job = "update job set title= ?, required_years= ?, salary= ?,location =?,query= ?,about= ?,education_info = ? where j_id = ?";
	public jobDao() {
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
	    public int addJob(job u) {
	        int result = 0;
	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(insert_user)) {
	             
	            ps.setString(1, u.getTitle());
	            ps.setString(2, "3 years");
	            ps.setString(3, u.getSalary());
	            ps.setString(4, u.getLocation());
	            ps.setString(5, u.getTime_up());
	            ps.setString(6, u.getQuery());
	            ps.setString(7, u.getAbout());
	            ps.setString(8, u.getEducation_info());
	            ps.setInt(9, u.getC_id());
	            
	            result = ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
	    
	    
	    public int visible(int j_id) {
	        int result = 0;
	  

	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(update_visibility)) {
	             
	            ps.setString(1,"visible");
	           
	            ps.setInt(2, j_id);
	            
	            result = ps.executeUpdate();
	            if (result == 0) {
	                System.out.println("No records updated. Check the job ID.");
	            }
	        } catch (SQLException e) {
	            // Replace with your logging framework
	            e.printStackTrace();
	        }
	        return result;
	    }
	    
	    
	    public int unvisible(int j_id) {
	        int result = 0;
	  

	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(update_visibility)) {
	             
	            ps.setString(1,"unvisible");
	           
	            ps.setInt(2, j_id);
	            
	            result = ps.executeUpdate();
	            if (result == 0) {
	                System.out.println("No records updated. Check the job ID.");
	            }
	        } catch (SQLException e) {
	            // Replace with your logging framework
	            e.printStackTrace();
	        }
	        return result;
	    }
	    
	    
	    public int updateJob(job u) {
	        int result = 0;
	        String update_job = "UPDATE job SET title = ?, required_years = ?, salary = ?, " +
	                            "location = ?, query = ?, about = ?, education_info = ? " +
	                            "WHERE j_id = ?";

	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(update_job)) {
	             
	            ps.setString(1, u.getTitle());
	            ps.setString(2, "5 years");
	            ps.setString(3, u.getSalary());
	            ps.setString(4, u.getLocation());
	            ps.setString(5, u.getQuery());
	            ps.setString(6, u.getAbout());
	            ps.setString(7, u.getEducation_info());
	            ps.setInt(8, u.getJ_id());
	            
	            result = ps.executeUpdate();
	            if (result == 0) {
	                System.out.println("No records updated. Check the job ID.");
	            }
	        } catch (SQLException e) {
	            // Replace with your logging framework
	            e.printStackTrace();
	        }
	        return result;
	    }


	    public int deleteJob(int j_id , int c_id ) {
	        int result = 0;
	        try (Connection connection = getConnection();
	        		
	             PreparedStatement ps = connection.prepareStatement(delete_job)) {
	             
	          
	            ps.setInt(1, j_id);
	            ps.setInt(2, c_id);
	            
	            result = ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
	    
	    public List<job> showJobs(int c_id) {
	        List<job> list = new ArrayList<>();
	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(select_users)) {
	             ps.setInt(1, c_id);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                int id = rs.getInt("j_id");
	                int cc_id = rs.getInt("c_id");
	                String name = rs.getString("title");
	                String required_years = rs.getString("required_years");
	                String salary = rs.getString("salary");
	                String Location = rs.getString("location");
	                String Time_up = rs.getString("time_up");
	                String Query = rs.getString("query");
	                String About = rs.getString("about");
	                String Education_info = rs.getString("education_info");
	                String created_date =  rs.getString("created_date");
	                String visibility =  rs.getString("visibility");
	                job u = new job(id,cc_id , name, required_years, salary ,Location, Time_up, Query , About , Education_info , created_date,visibility);
	    
	                
	                list.add(u);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
	    
	    public List<job> usershowJobs(int c_id) {
	        List<job> list = new ArrayList<>();
	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(visible_jobs)) {
	             ps.setInt(1, c_id);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                int id = rs.getInt("j_id");
	                int cc_id = rs.getInt("c_id");
	                String name = rs.getString("title");
	                String required_years = rs.getString("required_years");
	                String salary = rs.getString("salary");
	                String Location = rs.getString("location");
	                String Time_up = rs.getString("time_up");
	                String Query = rs.getString("query");
	                String About = rs.getString("about");
	                String Education_info = rs.getString("education_info");
	                String created_date =  rs.getString("created_date");
	                String visibility =  rs.getString("visibility");
	                job u = new job(id,cc_id , name, required_years, salary ,Location, Time_up, Query , About , Education_info , created_date,visibility);
	    
	                
	                list.add(u);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
	    
	    public job getJobdetail(int j_id ) {
	        job u = null;
	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(select_job_by_j_id)) {
	             
	        	ps.setInt(1, j_id);
	           
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	            	int id = rs.getInt("j_id");
	            	 int cc_id = rs.getInt("c_id");
		                String name = rs.getString("title");
		                String required_years = rs.getString("required_years");
		                String salary = rs.getString("salary");
		                String Location = rs.getString("location");
		                String Time_up = rs.getString("time_up");
		                String Query = rs.getString("query");
		                String About = rs.getString("about");
		                String Education_info = rs.getString("education_info");
		                String created_date =  rs.getString("created_date");
	                // Assuming the user bean has a constructor: user(int id, String name, String country, String mobile)
		                 u = new job(id,cc_id , name, required_years, salary ,Location, Time_up, Query , About , Education_info , created_date);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return u;
	    }
	    
	    
}

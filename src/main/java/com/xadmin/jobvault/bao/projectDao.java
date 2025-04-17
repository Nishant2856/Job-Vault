package com.xadmin.jobvault.bao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xadmin.jobvault.bean.job;
import com.xadmin.jobvault.bean.project;

public class projectDao {
	   String url = "jdbc:mysql://localhost:3306/jobvault";
	    String username = "root";
	    String driver = "com.mysql.cj.jdbc.Driver";
	    String password = "";
	    
	    // SQL queries
	    String insert_user = "insert into project(title, client_name, status , years, months ,details,u_id) values(?,?,?,?,?,?,?)";
	    String select_job_by_j_id = "select * from job where j_id = ?";
	    String get_projects = "select * from project where u_id = ? ";
	    
	public projectDao() {
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
    public int addProject(project u) {
        int result = 0;
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(insert_user)) {
             
            ps.setString(1, u.getTitle());
            ps.setString(2,u.getClient_name());
            ps.setString(3, u.getStatus());
            ps.setString(4, u.getYears());
            ps.setString(5, u.getMonths());
            ps.setString(6, u.getDetails());
            ps.setInt(7, u.getU_id());
            
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    
    public List<project> getProjects(int u_id) {
        List<project> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(get_projects)) {
             ps.setInt(1, u_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("pr_id");
                int uu_id = rs.getInt("u_id");
                String name = rs.getString("title");
                String client_name = rs.getString("client_name");
                String status = rs.getString("status");
                String years = rs.getString("years");
                String months = rs.getString("months");
                String details = rs.getString("details");
               project u = new project(id,uu_id,name,client_name,status,years,months,details);
    
                
                list.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    

}

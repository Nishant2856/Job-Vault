package com.xadmin.jobvault.bao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xadmin.jobvault.bean.company;
import com.xadmin.jobvault.bean.resume;

import jakarta.servlet.http.Part;

public class resumeDao {
	  String url = "jdbc:mysql://localhost:3306/jobvault";
	    String username = "root";
	    String driver = "com.mysql.cj.jdbc.Driver";
	    String password = "";
	    String insert = "insert into resume(u_id , resume) values(?,?)";
	    String getresume = "SELECT * FROM resume where u_id = ? ";
	    String skill = "SELECT * FROM skill where s_id = ? ";
	public resumeDao() {
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

	   private String extractFileName(Part part) {//This method will print the file name.
	        String contentDisp = part.getHeader("content-disposition");
	        String[] items = contentDisp.split(";");
	        for (String s : items) {
	            if (s.trim().startsWith("filename")) {
	                return s.substring(s.indexOf("=") + 2, s.length() - 1);
	            }
	        }
	        return "";
	    }
	   
	   public int createResume(resume u, Part filePart) throws IOException {
	        int result = 0;
	         
	        String fileName = extractFileName(filePart);
	        final String UPLOAD_DIR = "D:\\JOb Project\\src\\main\\webapp\\uploads";
	        // Save the file to the directory
	        File uploadDir = new File(UPLOAD_DIR);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdir(); // Create the directory if it doesn't exist
	        }
	        File file = new File(uploadDir, fileName);
	        try (InputStream fileContent = filePart.getInputStream();
	             OutputStream out = new FileOutputStream(file)) {
	            byte[] buffer = new byte[1024];
	            int bytesRead;
	            while ((bytesRead = fileContent.read(buffer)) != -1) {
	                out.write(buffer, 0, bytesRead);
	            }
	        }
	        
	    	
	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(insert)) {
	             
	            ps.setInt(1, u.getU_id());
	       
	            ps.setString(2, fileName);
	            result = ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
	   
	   public resume getResume(int u_id) {
	    	
		   resume result=  null ;
	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(getresume)) {
	             
	            ps.setInt(1,u_id);
	          
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	            	int r_id = rs.getInt("r_id");
	            	int uu_id = rs.getInt("u_id");
	                String resume = rs.getString("resume");
	              
	                // Assuming the user bean has a constructor: user(int id, String name, String country, String mobile)
	                result = new resume(r_id,uu_id,resume);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
}

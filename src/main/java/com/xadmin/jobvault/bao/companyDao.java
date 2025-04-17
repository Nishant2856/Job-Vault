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
import java.util.ArrayList;
import java.util.List;

import com.xadmin.jobvault.bean.company;
import jakarta.servlet.http.Part;

public class companyDao {
    String url = "jdbc:mysql://localhost:3306/jobvault";
    String username = "root";
    String driver = "com.mysql.cj.jdbc.Driver";
    String password = "";

    // SQL queries
    String insert_company = "INSERT INTO company(company_name, email, password, mobile_number, address, logo) VALUES (?, ?, ?, ?, ?, ?)";
    String login_company = "SELECT * FROM company WHERE email = ? AND password = ?";
    String select_company_by_id = "SELECT * FROM company WHERE c_id = ?";
    String select_all_company = "SELECT * FROM company";
    String update_company = "UPDATE company SET company_name = ?, email = ?, password = ?, mobile_number = ?, address = ?, logo = ? WHERE c_id = ?";
    String delete_company = "DELETE FROM company WHERE c_id = ?";

    public companyDao() {
        super();
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    public int createCompany(company u, Part filePart) throws IOException {
        int result = 0;

        String fileName = extractFileName(filePart);
        final String UPLOAD_DIR = "E:\\JOb Project\\src\\main\\webapp\\uploads";

        // Ensure directory exists
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // Save file
        File file = new File(uploadDir, fileName);
        try (InputStream fileContent = filePart.getInputStream();
             OutputStream out = new FileOutputStream(file)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileContent.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }

        // Store relative path in the database
        String logoPath = "uploads/" + fileName;

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(insert_company)) {

            ps.setString(1, u.getCompany_name());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getMobile());
            ps.setString(5, u.getAddress());
            ps.setString(6, logoPath);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int updateCompany(company u, Part filePart) throws IOException {
        int result = 0;

        String fileName = extractFileName(filePart);
        final String UPLOAD_DIR = "E:\\JOb Project\\src\\main\\webapp\\uploads";

        // Ensure directory exists
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // Save file
        File file = new File(uploadDir, fileName);
        try (InputStream fileContent = filePart.getInputStream();
             OutputStream out = new FileOutputStream(file)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileContent.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }

        // Store relative path in the database
        String logoPath = "uploads/" + fileName;

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(update_company)) {

            ps.setString(1, u.getCompany_name());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getMobile());
            ps.setString(5, u.getAddress());
            ps.setString(6, logoPath);
            ps.setInt(7, u.getC_id());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int deleteCompany(int c_id) {
        int result = 0;
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(delete_company)) {
            ps.setInt(1, c_id);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public company companyDetails(int c_id) {
        company result = null;
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(select_company_by_id)) {

            ps.setInt(1, c_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int cc_id = rs.getInt("c_id");
                String name = rs.getString("company_name");
                String email = rs.getString("email");
                String pass = rs.getString("password");
                String mobile = rs.getString("mobile_number");
                String address = rs.getString("address");
                String logo = rs.getString("logo");

                // If logo is null, set a default image
                if (logo == null || logo.isEmpty()) {
                    logo = "uploads/default-logo.png";
                }

                result = new company(cc_id, name, email, pass, mobile, address, logo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}

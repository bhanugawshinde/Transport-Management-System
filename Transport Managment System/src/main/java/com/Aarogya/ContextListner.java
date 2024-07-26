package com.Aarogya;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
@WebListener
public class ContextListner implements ServletContextListener{
	public static Connection con ;
	public static String path;
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		// Create Connection object 
		String driver = servletContext.getInitParameter("driver");
		String url = servletContext.getInitParameter("url");
		String userName = servletContext.getInitParameter("userName");
		String password = servletContext.getInitParameter("password");
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,userName,password);
			servletContext.setAttribute("con", con);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// creating upload file path
		String uploadDir = servletContext.getInitParameter("uploadLocation");
        if (uploadDir == null || uploadDir.isEmpty()) {
            uploadDir = "uploads"; // default directory
        }
        // Get the real path
        path = servletContext.getRealPath("/") + File.separator + uploadDir;
        
        //creating File directory if it dose not exist
        File fileUploadDirectory = new File(path);
        if(!fileUploadDirectory.exists()) {
        	fileUploadDirectory.mkdirs();
        }
        //store full path in context 
        servletContext.setAttribute("path", path);
        
		
		
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

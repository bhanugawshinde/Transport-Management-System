package com.Aarogya.manager;

import java.io.IOException;
import java.io.PrintWriter;

import com.Aarogya.DAO.ManagerDao;
import com.Aarogya.util.Util;
import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/DeleteManager")
public class DeleteManager extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idsArray[] = Util.jsonToArray(req.getInputStream());		
		
		JsonObject jsonResponse = new JsonObject();
		resp.setContentType("application/json");
		try(PrintWriter out =  resp.getWriter() ){
			if(ManagerDao.delete(idsArray)) {				
				jsonResponse.addProperty("status", "Success");
				jsonResponse.addProperty("message", "Branch Deleted");
				out.print(jsonResponse);
			}
			else {
				jsonResponse.addProperty("status", "Error");
				jsonResponse.addProperty("status", "Branch Not Deleted");
				out.print(jsonResponse);
			}
		}
	}
}

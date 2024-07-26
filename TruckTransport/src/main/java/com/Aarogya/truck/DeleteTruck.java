package com.Aarogya.truck;

import java.io.IOException;
import java.io.PrintWriter;

import com.Aarogya.DAO.TruckDao;
import com.Aarogya.util.Util;
import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/DeleteTruck")
public class DeleteTruck extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idsArray[] = Util.jsonToArray(req.getInputStream());		
		
		JsonObject jsonResponse = new JsonObject();
		resp.setContentType("application/json");
		try(PrintWriter out =  resp.getWriter() ){
			if(TruckDao.delete(idsArray)) {				
				jsonResponse.addProperty("status", "Success");
				jsonResponse.addProperty("message", "Truck Deleted");
				out.print(jsonResponse);
			}
			else {
				jsonResponse.addProperty("status", "Error");
				jsonResponse.addProperty("status", "Truck Not Deleted");
				out.print(jsonResponse);
			}
		}
	}
}

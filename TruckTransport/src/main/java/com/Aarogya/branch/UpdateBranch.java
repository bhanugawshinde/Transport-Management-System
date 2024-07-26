package com.Aarogya.branch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.Aarogya.DAO.BranchDao;
import com.Aarogya.bean.BranchBean;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/UpdateBranch")
public class UpdateBranch extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String jsonPayload = reader.readLine();
		JsonObject jsonObject = new Gson().fromJson(jsonPayload, JsonObject.class);
		
		//get Parameter from jsonObject
		String branchId = jsonObject.get("branchId").getAsString(); 
		String branchName = jsonObject.get("branchName").getAsString();
		String managerId = jsonObject.get("managerId").getAsString();
		String addressLine1 = jsonObject.get("addressLine1").getAsString();
		String country = jsonObject.get("country").getAsString();
		String state = jsonObject.get("state").getAsString();
		String city = jsonObject.get("city").getAsString();
		String postalCode = jsonObject.get("postalCode").getAsString();
		String latitude = jsonObject.get("latitude").getAsString();
		String longitude = jsonObject.get("longitude").getAsString();
		String phoneNumber = jsonObject.get("phoneNumber").getAsString();
		String email = jsonObject.get("email").getAsString();
		String status = jsonObject.get("status").getAsString();
		
		BranchBean branch = new BranchBean(branchId,branchName, managerId, addressLine1, country, state, city, postalCode, latitude, longitude, phoneNumber, email, status, null, null);
		resp.setContentType("application/json");
		JsonObject jsonResponse = new JsonObject();
		try(PrintWriter out = resp.getWriter();) {			
			if(BranchDao.update(branch)) {
				jsonResponse.addProperty("status", "Success");
				jsonResponse.addProperty("message", "Succeesfully update branch");
			}
			else {
				jsonResponse.addProperty("status", "Error");
				jsonResponse.addProperty("message", "Not able to update branch");
			}
			
			out.print(jsonResponse);
		} 
		
		
	}
}

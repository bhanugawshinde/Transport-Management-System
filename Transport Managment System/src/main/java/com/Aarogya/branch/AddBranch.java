package com.Aarogya.branch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
@WebServlet("/AddBranch")
public class AddBranch extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// get Request and convert into json
		BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String jsonPayload = reader.readLine();
		JsonObject jsonObject = new Gson().fromJson(jsonPayload, JsonObject.class);

		// get parameter from json
		String branchName = jsonObject.get("branchName").getAsString();
		String managerId = jsonObject.get("managerId").getAsString();
		String AddressLine1 = jsonObject.get("addressLine1").getAsString();
		String country = jsonObject.get("country").getAsString();
		String state = jsonObject.get("state").getAsString();
		String city = jsonObject.get("city").getAsString();
		String postalCode = jsonObject.get("postalCode").getAsString();
		String latitude = jsonObject.get("latitude").getAsString();
		String longitude = jsonObject.get("longitude").getAsString();
		String phoneNumber = jsonObject.get("phoneNumber").getAsString();
		String email = jsonObject.get("email").getAsString();
		String status = jsonObject.get("status").getAsString();

		// Date
		Date dateEstablished = null;
		Date dateDeactivated = null;
		String dateFormat = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		try {
			String date1 = jsonObject.get("dateEstablished").getAsString();
			System.out.println(date1);
			if(!date1.equals(""))dateEstablished = simpleDateFormat.parse(date1);
			else dateEstablished = new Date();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// create BranchBean object
		BranchBean branch = new BranchBean(branchName, managerId, AddressLine1, country, state, city, postalCode,
				latitude, longitude, phoneNumber, email, status, dateEstablished, dateDeactivated);
		// Response
		JsonObject jsonResponse = new JsonObject();
		resp.setContentType("application/json");
		try (PrintWriter out = resp.getWriter()) {
		if (BranchDao.add(branch)) {
			jsonResponse.addProperty("status", "Success");
			jsonResponse.addProperty("message", "Successfully Branch Addeded");
			
		}
		else {
			jsonResponse.addProperty("status", "Error");
			jsonResponse.addProperty("message", "Not able to Add branch");
			
		}
		out.write(jsonResponse.toString());
		}
	}

}

package com.Aarogya.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.stream.Collectors;

import com.Aarogya.DAO.EmployeeDao;
import com.Aarogya.bean.EmployeeBean;
import com.Aarogya.util.Util;
import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Map<String, Object> mapObject = Util.jsonToMap(req.getInputStream());
		Map<String, String> map = mapObject.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry-> entry.getValue().toString()));
		String firstName = map.get("firstName");
		String lastName = map.get("lastName");
		String email = map.get("email");
		String phoneNumber = map.get("phoneNumber");
		java.sql.Date dateOfBirth = Util.getSqlDate(map.get("dateOfBirth"));
		java.sql.Date hireDate = Util.getSqlDate(map.get("hireDate"));
		String department = map.get("department");
		String address = map.get("address");
		String city = map.get("city");
		String state = map.get("state");
		String postalCode = map.get("postalCode");
		String country = map.get("country");
		String managerId = map.get("managerId");
		String branchId = map.get("branchId");
		Float salary = Float.parseFloat(map.get("salary"));
		EmployeeBean emp = new EmployeeBean(firstName, lastName, email, phoneNumber, dateOfBirth, hireDate, department, address, city, state, postalCode, country, null, managerId, branchId, salary);
		// Response
		JsonObject jsonResponse = new JsonObject();
		resp.setContentType("application/json");
		try (PrintWriter out = resp.getWriter()) {
		if (EmployeeDao.add(emp)) {
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

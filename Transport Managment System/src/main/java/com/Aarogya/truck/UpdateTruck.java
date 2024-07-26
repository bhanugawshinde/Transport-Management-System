package com.Aarogya.truck;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Map;
import java.util.stream.Collectors;

import com.Aarogya.DAO.TruckDao;
import com.Aarogya.bean.TruckBean;
import com.Aarogya.util.Util;
import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/UpdateTruck")
public class UpdateTruck extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> mapObject = Util.jsonToMap(req.getInputStream());
		Map<String, String> map = mapObject.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry->entry.getValue().toString()));
		
		String truckId = map.get("truckId");
		String profile = map.get("profile");
		String licensePlate = map.get("licensePlate");
		String companyName = map.get("companyName");
		String model = map.get("model");
		int yearOfManufacture = map.get("yearOfManufacture") != null ? Integer.parseInt(map.get("yearOfManufacture")) : 0;
		String vehicleIdentificationNumber = map.get("vehicleIdentificationNumber");
		String color = map.get("color");
		String type = map.get("type");
		double capacityWeight = map.get("capacityWeight") != null ? Double.parseDouble(map.get("capacityWeight")) : 0.0;
		double capacityVolume = map.get("capacityVolume") != null ? Double.parseDouble(map.get("capacityVolume")) : 0.0;
		String registrationState = map.get("registrationState");
		Date registrationExpiryDate = map.get("registrationExpiryDate") != null
				? Util.getSqlDate(map.get("registrationExpiryDate"))
				: null;
		String insurancePolicyNumber = map.get("insurancePolicyNumber");
		Date insuranceExpiryDate = map.get("insuranceExpiryDate") != null
				? Util.getSqlDate(map.get("insuranceExpiryDate"))
				: null;
		Date inspectionDate = map.get("inspectionDate") != null ? Util.getSqlDate(map.get("inspectionDate")) : null;
		String complianceCertificates = map.get("complianceCertificates");
		float currentMileage = map.get("currentMileage") != null ? Float.parseFloat(map.get("currentMileage")) : 0;
		String fuelType = map.get("fuelType");
		double fuelEfficiency = map.get("fuelEfficiency") != null ? Double.parseDouble(map.get("fuelEfficiency")) : 0.0;
		String gpsTrackingId = map.get("gpsTrackingId");
		String assignedDriver = map.get("assignedDriver");
		Date maintenanceSchedule = map.get("maintenanceSchedule") != null
				? Util.getSqlDate(map.get("maintenanceSchedule"))
				: null;
		Date purchaseDate = map.get("purchaseDate") != null ? Util.getSqlDate(map.get("purchaseDate")) : null;
		double purchasePrice = map.get("purchasePrice") != null ? Double.parseDouble(map.get("purchasePrice")) : 0.0;
		double depreciation = map.get("depreciation") != null ? Double.parseDouble(map.get("depreciation")) : 0.0;
		String additionalEquipment = map.get("additionalEquipment");
		String safetyFeatures = map.get("safetyFeatures");
		String telematicsSystem = map.get("telematicsSystem");
		String specialPermits = map.get("specialPermits");
		String branchId = map.get("branchId");

		TruckBean truckBean = new TruckBean(truckId, profile, licensePlate, companyName, model, yearOfManufacture,
				vehicleIdentificationNumber, color, type, capacityWeight, capacityVolume, registrationState,
				registrationExpiryDate, insurancePolicyNumber, insuranceExpiryDate, inspectionDate,
				complianceCertificates, currentMileage, fuelType, fuelEfficiency, gpsTrackingId, assignedDriver,
				maintenanceSchedule, purchaseDate, purchasePrice, depreciation, additionalEquipment, safetyFeatures,
				telematicsSystem, specialPermits, branchId);
		
		// Response
		JsonObject jsonResponse = new JsonObject();
		resp.setContentType("application/json");
		try (PrintWriter out = resp.getWriter()) {
		if (TruckDao.update(truckBean)) {
			jsonResponse.addProperty("status", "Success");
			jsonResponse.addProperty("message", "Successfully Update Manger");
		}
		else {
			jsonResponse.addProperty("status", "Error");
			jsonResponse.addProperty("message", "Not able to Update Manger");
		}
		out.write(jsonResponse.toString());
		}
	}

}

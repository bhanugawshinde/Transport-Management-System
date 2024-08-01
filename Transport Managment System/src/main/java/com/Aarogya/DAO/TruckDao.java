package com.Aarogya.DAO;

import java.io.File;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.Aarogya.ContextListner;
import com.Aarogya.DBConnection;
import com.Aarogya.bean.TruckBean;
import com.Aarogya.util.Util;

public class TruckDao {
	static Connection con = DBConnection.getConnection();

	public static boolean add(TruckBean truck) {
		PreparedStatement pstmt = null;
		
		try {
			con.setAutoCommit(false);
			Savepoint savepoint = con.setSavepoint();
			String functionCall = "{ ? = call getTruckId() }";
			CallableStatement call = con.prepareCall(functionCall);
			call.registerOutParameter(1, Types.VARCHAR);
			call.execute();
			String truckId = call.getString(1);

			Map<String, String> map = Util.stringToMap(truck.getProfile());
			String filetype[] = map.get("fileType").toString().split("/");
			String profileName = filetype.length == 2 ? truckId + "." + filetype[1] : null;

			Map<String, String> complianceCertificatesMap = Util.stringToMap(truck.getComplianceCertificates());
			filetype = complianceCertificatesMap.get("fileType").split("/");
			String complianceCertificatesName = filetype.length == 2
					? truckId + "ComplianceCertificates" + "." + filetype[1]
					: null;

			 pstmt = con.prepareStatement(
					"INSERT INTO trucks (Truck_id, PROFILE, LICENSE_PLATE, COMPANY_NAME, MODEL, YEAR_OF_MANUFACTURE, VEHICLE_IDENTIFICATION_NUMBER, COLOR, TYPE, CAPACITY_WEIGHT, CAPACITY_VOLUME, REGISTRATION_STATE, REGISTRATION_EXPIRY_DATE, INSURANCE_POLICY_NUMBER, INSURANCE_EXPIRY_DATE, INSPECTION_DATE, COMPLIANCE_CERTIFICATES, CURRENT_MILEAGE, FUEL_TYPE, FUEL_EFFICIENCY, GPS_TRACKING_ID, ASSIGNED_DRIVER, MAINTENANCE_SCHEDULE, PURCHASE_DATE, PURCHASE_PRICE, DEPRECIATION, ADDITIONAL_EQUIPMENT, SAFETY_FEATURES, TELEMATICS_SYSTEM, SPECIAL_PERMITS, BRANCH_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			//
			pstmt.setString(1, truckId);
			pstmt.setString(2, profileName);
			pstmt.setString(3, truck.getLicensePlate());
			pstmt.setString(4, truck.getCompanyName());
			pstmt.setString(5, truck.getModel());
			pstmt.setInt(6, truck.getYearOfManufacture());
			pstmt.setString(7, truck.getVehicleIdentificationNumber());
			pstmt.setString(8, truck.getColor());
			pstmt.setString(9, truck.getType());
			pstmt.setDouble(10, truck.getCapacityWeight());
			pstmt.setDouble(11, truck.getCapacityVolume());
			pstmt.setString(12, truck.getRegistrationState());
			pstmt.setDate(13, truck.getRegistrationExpiryDate());
			pstmt.setString(14, truck.getInsurancePolicyNumber());
			pstmt.setDate(15, truck.getInsuranceExpiryDate());
			pstmt.setDate(16, truck.getInspectionDate());
			pstmt.setString(17, complianceCertificatesName);
			pstmt.setFloat(18, truck.getCurrentMileage());
			pstmt.setString(19, truck.getFuelType());
			pstmt.setDouble(20, truck.getFuelEfficiency());
			pstmt.setString(21, truck.getGpsTrackingId());
			pstmt.setString(22, truck.getAssignedDriver());
			pstmt.setDate(23, truck.getMaintenanceSchedule());
			pstmt.setDate(24, truck.getPurchaseDate());
			pstmt.setDouble(25, truck.getPurchasePrice());
			pstmt.setDouble(26, truck.getDepreciation());
			pstmt.setString(27, truck.getAdditionalEquipment());
			pstmt.setString(28, truck.getSafetyFeatures());
			pstmt.setString(29, truck.getTelematicsSystem());
			pstmt.setString(30, truck.getSpecialPermits());
			pstmt.setString(31, truck.getBranchId());

			if (pstmt.executeUpdate() > 0) {
				String folder = ContextListner.path + File.separator + "Truck" + File.separator + truckId;
				if (Util.saveBase64File(folder, profileName, map.get("base64Data")) && Util.saveBase64File(folder,
						complianceCertificatesName, complianceCertificatesMap.get("base64Data"))) {
					return true;
				} else {
					con.rollback(savepoint);
					return false;
				}
			} else {
				con.rollback(savepoint);
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

	public static List<TruckBean> view() {
		List<TruckBean> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			 pstmt = con.prepareStatement("SELECT * FROM trucks");
			 rs = pstmt.executeQuery();

			while (rs.next()) {
				TruckBean truckBean = new TruckBean();
				truckBean.setTruckId(rs.getString("Truck_id"));
				truckBean.setProfile(rs.getString("PROFILE"));
				truckBean.setLicensePlate(rs.getString("LICENSE_PLATE"));
				truckBean.setCompanyName(rs.getString("COMPANY_NAME"));
				truckBean.setModel(rs.getString("MODEL"));
				truckBean.setYearOfManufacture(rs.getInt("YEAR_OF_MANUFACTURE"));
				truckBean.setVehicleIdentificationNumber(rs.getString("VEHICLE_IDENTIFICATION_NUMBER"));
				truckBean.setColor(rs.getString("COLOR"));
				truckBean.setType(rs.getString("TYPE"));
				truckBean.setCapacityWeight(rs.getDouble("CAPACITY_WEIGHT"));
				truckBean.setCapacityVolume(rs.getDouble("CAPACITY_VOLUME"));
				truckBean.setRegistrationState(rs.getString("REGISTRATION_STATE"));
				truckBean.setRegistrationExpiryDate(rs.getDate("REGISTRATION_EXPIRY_DATE"));
				truckBean.setInsurancePolicyNumber(rs.getString("INSURANCE_POLICY_NUMBER"));
				truckBean.setInsuranceExpiryDate(rs.getDate("INSURANCE_EXPIRY_DATE"));
				truckBean.setInspectionDate(rs.getDate("INSPECTION_DATE"));
				truckBean.setComplianceCertificates(rs.getString("COMPLIANCE_CERTIFICATES"));
				truckBean.setCurrentMileage(rs.getInt("CURRENT_MILEAGE"));
				truckBean.setFuelType(rs.getString("FUEL_TYPE"));
				truckBean.setFuelEfficiency(rs.getDouble("FUEL_EFFICIENCY"));
				truckBean.setGpsTrackingId(rs.getString("GPS_TRACKING_ID"));
				truckBean.setAssignedDriver(rs.getString("ASSIGNED_DRIVER"));
				truckBean.setMaintenanceSchedule(rs.getDate("MAINTENANCE_SCHEDULE"));
				truckBean.setPurchaseDate(rs.getDate("PURCHASE_DATE"));
				truckBean.setPurchasePrice(rs.getDouble("PURCHASE_PRICE"));
				truckBean.setDepreciation(rs.getDouble("DEPRECIATION"));
				truckBean.setAdditionalEquipment(rs.getString("ADDITIONAL_EQUIPMENT"));
				truckBean.setSafetyFeatures(rs.getString("SAFETY_FEATURES"));
				truckBean.setTelematicsSystem(rs.getString("TELEMATICS_SYSTEM"));
				truckBean.setSpecialPermits(rs.getString("SPECIAL_PERMITS"));
				truckBean.setBranchId(rs.getString("BRANCH_ID"));

				list.add(truckBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public static boolean update(TruckBean truck) {
		StringBuilder query = new StringBuilder("UPDATE trucks SET LICENSE_PLATE=?, COMPANY_NAME=?, MODEL=?, YEAR_OF_MANUFACTURE=?, VEHICLE_IDENTIFICATION_NUMBER=?, COLOR=?, TYPE=?, CAPACITY_WEIGHT=?, CAPACITY_VOLUME=?, REGISTRATION_STATE=?, REGISTRATION_EXPIRY_DATE=?, INSURANCE_POLICY_NUMBER=?, INSURANCE_EXPIRY_DATE=?, INSPECTION_DATE=?, CURRENT_MILEAGE=?, FUEL_TYPE=?, FUEL_EFFICIENCY=?, GPS_TRACKING_ID=?, ASSIGNED_DRIVER=?, MAINTENANCE_SCHEDULE=?, PURCHASE_DATE=?, PURCHASE_PRICE=?, DEPRECIATION=?, ADDITIONAL_EQUIPMENT=?, SAFETY_FEATURES=?, TELEMATICS_SYSTEM=?, SPECIAL_PERMITS=?, BRANCH_ID=? ");
		String truckId = truck.getTruckId();
		String folder = ContextListner.path + File.separator + "Truck" + File.separator + truckId;
		PreparedStatement pstmt = null;
		
		if (truck != null) {
			
			Map<String, String> profileMap = Util.stringToMap(truck.getProfile());
			String filetype[] = profileMap.get("fileType").toString().split("/");
			String profileName = filetype.length == 2 ? truckId + "." + filetype[1] : null;
			
			Map<String, String> complianceCertificatesMap = Util.stringToMap(truck.getComplianceCertificates());
			filetype = complianceCertificatesMap.get("fileType").split("/");
			String complianceCertificatesName = filetype.length == 2
					? truckId + "ComplianceCertificates" + "." + filetype[1]
					: null;
			
			if ((!profileMap.get("fileName").equals(""))
					&& (!complianceCertificatesMap.get("fileName").equals(""))) {
				if (Util.saveBase64File(folder, profileName, profileMap.get("base64Data")) && Util.saveBase64File(folder,
						complianceCertificatesName, complianceCertificatesMap.get("base64Data"))) {
					query.append(", profile = '"+profileName+"', "+"Compliance_Certificates = '"+complianceCertificatesName+"' ");
				} else {
					return false;
				}
				
				
			
			} else if (!profileMap.get("fileName").equals("")) {
				
				if (Util.saveBase64File(folder, profileName, profileMap.get("base64Data")) ) {
					query.append(", profile = '"+profileName+"' ");
				} else {
					return false;
				}
				
			
			} else if (!complianceCertificatesMap.get("fileName").equals("")) {
				
				if (Util.saveBase64File(folder, complianceCertificatesName, complianceCertificatesMap.get("base64Data")) ) {
					query.append("complianceCertificates = '"+complianceCertificatesName+"' ");
				} else {
					return false;
				}
			
			}
			
			query.append("Where Truck_id = '"+truckId+"'");		
		}
		try {
			
			 pstmt = con.prepareStatement(query.toString());

			pstmt.setString(1, truck.getLicensePlate());
			pstmt.setString(2, truck.getCompanyName());
			pstmt.setString(3, truck.getModel());
			pstmt.setInt(4, truck.getYearOfManufacture());
			pstmt.setString(5, truck.getVehicleIdentificationNumber());
			pstmt.setString(6, truck.getColor());
			pstmt.setString(7, truck.getType());
			pstmt.setDouble(8, truck.getCapacityWeight());
			pstmt.setDouble(9, truck.getCapacityVolume());
			pstmt.setString(10, truck.getRegistrationState());
			pstmt.setDate(11, new java.sql.Date(truck.getRegistrationExpiryDate().getTime()));
			pstmt.setString(12, truck.getInsurancePolicyNumber());
			pstmt.setDate(13, new java.sql.Date(truck.getInsuranceExpiryDate().getTime()));
			pstmt.setDate(14, new java.sql.Date(truck.getInspectionDate().getTime()));
			pstmt.setFloat(15, truck.getCurrentMileage());
			pstmt.setString(16, truck.getFuelType());
			pstmt.setDouble(17, truck.getFuelEfficiency());
			pstmt.setString(18, truck.getGpsTrackingId());
			pstmt.setString(19, truck.getAssignedDriver());
			pstmt.setDate(20, new java.sql.Date(truck.getMaintenanceSchedule().getTime()));
			pstmt.setDate(21, new java.sql.Date(truck.getPurchaseDate().getTime()));
			pstmt.setDouble(22, truck.getPurchasePrice());
			pstmt.setDouble(23, truck.getDepreciation());
			pstmt.setString(24, truck.getAdditionalEquipment());
			pstmt.setString(25, truck.getSafetyFeatures());
			pstmt.setString(26, truck.getTelematicsSystem());
			pstmt.setString(27, truck.getSpecialPermits());
			pstmt.setString(28, truck.getBranchId());
			
			
			
			if (pstmt.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		return false;
	}

	public static boolean delete(String[] ids) {
		PreparedStatement pstmt = null;
		
		if (ids.length == 0)
			return true;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("'").append(ids[0]).append("'");
			for (int i = 1; i < ids.length; i++) {
				sb.append(",");
				sb.append("'").append(ids[i]).append("'");
			}
			 pstmt = con
					.prepareStatement("DELETE FROM trucks WHERE truck_id IN (" + sb.toString() + ")");
			if (pstmt.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return false;
	}
	
	public static int getTotal() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			 pstmt = con.prepareStatement("select count(*) from trucks");
			 rs = pstmt.executeQuery();
			if(rs.next())return rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public static float getMaxPrice() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			 pstmt = con.prepareStatement("select max(PURCHASE_PRICE) from trucks");
			 rs = pstmt.executeQuery();
			if(rs.next())return rs.getFloat(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public static float getMinPrice() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			 pstmt = con.prepareStatement("select min(PURCHASE_PRICE) from trucks");
			 rs = pstmt.executeQuery();
			if(rs.next())return rs.getFloat(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public static float getAvaragePrice() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			 pstmt = con.prepareStatement("select avg(PURCHASE_PRICE) from trucks");
			 rs = pstmt.executeQuery();
			if(rs.next())return rs.getFloat(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public static float getTotalPrice() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			 pstmt = con.prepareStatement("select sum(PURCHASE_PRICE) from trucks");
			 rs = pstmt.executeQuery();
			if(rs.next())return rs.getFloat(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public static float getAvarageMileage() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			 pstmt = con.prepareStatement("select avg(CURRENT_MILEAGE) from trucks");
			 rs = pstmt.executeQuery();
			if(rs.next())return rs.getFloat(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public static int getTotalCompanies() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			 pstmt = con.prepareStatement("select count(COMPANY_NAME) from trucks");
			 rs = pstmt.executeQuery();
			if(rs.next())return rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	
}

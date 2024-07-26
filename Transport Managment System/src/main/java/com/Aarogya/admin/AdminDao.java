package com.Aarogya.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Aarogya.DBConnection;

public class AdminDao {
	public static AdminBean login(String adminId, String password) {
		AdminBean adminBean = null;
		Connection con = DBConnection.getConnection();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("select * from Admin where AdminId=? and password=?");
			pstmt.setString(1, adminId);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				adminBean = new AdminBean();
				adminBean.setAdminId(adminId);
				adminBean.setName(rs.getString("Name"));
				adminBean.setPosition(rs.getString("Position"));
				adminBean.setEmail(rs.getString("Email"));
				adminBean.setPhoneNumber(rs.getString("PhoneNumber"));
				adminBean.setDateJoined(rs.getDate("DateJoined"));
				adminBean.setStatus(rs.getString("Status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return adminBean;
	}
}

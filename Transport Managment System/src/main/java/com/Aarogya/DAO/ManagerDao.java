package com.Aarogya.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Aarogya.DBConnection;
import com.Aarogya.bean.ManagerBean;



public class ManagerDao {
	static Connection con = DBConnection.getConnection();
	public static boolean add(ManagerBean manager) {
		try{
			PreparedStatement pstmt = con.prepareStatement("insert into manager(Manager_id,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,DATE_OF_BIRTH,HIRE_DATE,DEPARTMENT,ADDRESS, CITY,STATE,POSTAL_CODE,COUNTRY,BRANCH_ID,SALARY) values(getManagerId(),?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pstmt.setString(1, manager.getFirstName());
			pstmt.setString(2, manager.getLastName());
			pstmt.setString(3, manager.getEmail());
			pstmt.setString(4, manager.getPhoneNumber());
			pstmt.setDate(5, manager.getDateOfBirth());
			pstmt.setDate(6, manager.getHireDate());
			pstmt.setString(7, manager.getDepartment());
			pstmt.setString(8, manager.getAddress());
			pstmt.setString(9, manager.getCity());
			pstmt.setString(10, manager.getState());
			pstmt.setString(11, manager.getPostalCode());
			pstmt.setString(12, manager.getCountry());
			pstmt.setString(13, manager.getBranchId());
			pstmt.setFloat(14, manager.getSalary());
			 
			if(pstmt.executeUpdate()>0) return true; 
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	public static List<ManagerBean> view(){
		List<ManagerBean> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from manager");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ManagerBean managerBean = new ManagerBean();
				managerBean.setManagerId(rs.getString("Manager_id"));
				managerBean.setFirstName(rs.getString("first_name"));
				managerBean.setLastName(rs.getString("last_name"));
				managerBean.setEmail(rs.getString("email"));
				managerBean.setPhoneNumber(rs.getString("phone_number"));
				managerBean.setDateOfBirth(rs.getDate("date_of_birth"));
				managerBean.setHireDate(rs.getDate("hire_date"));
				managerBean.setDepartment(rs.getString("department"));
				managerBean.setAddress(rs.getString("address"));
				managerBean.setCity(rs.getString("city"));
				managerBean.setState(rs.getString("state"));
				managerBean.setPostalCode(rs.getString("postal_code"));
				managerBean.setCountry(rs.getString("country"));
				managerBean.setProfilePic(rs.getString("profile_pic"));
				managerBean.setBranchId(rs.getString("branch_id"));
				managerBean.setSalary(rs.getFloat("salary"));
				list.add(managerBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static boolean update(ManagerBean bean) {
		try {
			PreparedStatement pstmt = con.prepareStatement("update manager set first_name=?, last_Name=?, email=?, phone_Number=?, date_Of_Birth=?, hire_Date=?, department=?, address=?, city=?, state=?, postal_code=?, country=?, branch_Id=?, salary=? where manager_Id=?");
			pstmt.setString(1, bean.getFirstName());
			pstmt.setString(2, bean.getLastName());
			pstmt.setString(3, bean.getEmail());
			pstmt.setString(4, bean.getPhoneNumber());
			pstmt.setDate(5, bean.getDateOfBirth());
			pstmt.setDate(6, bean.getHireDate());
			pstmt.setString(7, bean.getDepartment());
			pstmt.setString(8, bean.getAddress());
			pstmt.setString(9, bean.getCity());
			pstmt.setString(10, bean.getState());
			pstmt.setString(11, bean.getPostalCode());
			pstmt.setString(12, bean.getCountry());
			pstmt.setString(13, bean.getBranchId());
			pstmt.setFloat(14, bean.getSalary());
			pstmt.setString(15, bean.getManagerId());
			if(pstmt.executeUpdate()>0)return true;
			else System.out.println("manger not found");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}
	public static boolean delete(String[] ids) {
		if(ids.length==0)return true;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("'"+ids[0]+"'");
			for(int i = 1 ; i<ids.length; i++) {
				sb.append(",");
				sb.append("'"+ids[i]+"'");
			}
			PreparedStatement pstmt = con.prepareStatement("delete from manager where manager_id in ("+sb.toString()+")");
			if(pstmt.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	public static int getTotal() {
		try {
			PreparedStatement pstmt = con.prepareStatement("select count(*) from manager");
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())return rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		return 0;
	}
}

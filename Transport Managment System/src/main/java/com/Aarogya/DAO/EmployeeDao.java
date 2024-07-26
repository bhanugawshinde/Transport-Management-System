package com.Aarogya.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Aarogya.DBConnection;
import com.Aarogya.bean.EmployeeBean;



public class EmployeeDao {
	static Connection con = DBConnection.getConnection();
	public static boolean add(EmployeeBean employee) {
		try{
			PreparedStatement pstmt = con.prepareStatement("insert into employee(Employee_id,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,DATE_OF_BIRTH,HIRE_DATE,DEPARTMENT,ADDRESS, CITY,STATE,POSTAL_CODE,COUNTRY,Manager_ID,BRANCH_ID,SALARY) values(getEmployeeId(),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pstmt.setString(1, employee.getFirstName());
			pstmt.setString(2, employee.getLastName());
			pstmt.setString(3, employee.getEmail());
			pstmt.setString(4, employee.getPhoneNumber());
			pstmt.setDate(5, employee.getDateOfBirth());
			pstmt.setDate(6, employee.getHireDate());
			pstmt.setString(7, employee.getDepartment());
			pstmt.setString(8, employee.getAddress());
			pstmt.setString(9, employee.getCity());
			pstmt.setString(10, employee.getState());
			pstmt.setString(11, employee.getPostalCode());
			pstmt.setString(12, employee.getCountry());
			pstmt.setString(13, employee.getManagerId());
			pstmt.setString(14, employee.getBranchId());
			pstmt.setFloat(15, employee.getSalary());
			 
			if(pstmt.executeUpdate()>0) return true; 
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	public static List<EmployeeBean> view(){
		List<EmployeeBean> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from employee");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				EmployeeBean employeeBean = new EmployeeBean();
				employeeBean.setEmployeeId(rs.getString("Employee_id"));
				employeeBean.setFirstName(rs.getString("first_name"));
				employeeBean.setLastName(rs.getString("last_name"));
				employeeBean.setEmail(rs.getString("email"));
				employeeBean.setPhoneNumber(rs.getString("phone_number"));
				employeeBean.setDateOfBirth(rs.getDate("date_of_birth"));
				employeeBean.setHireDate(rs.getDate("hire_date"));
				employeeBean.setDepartment(rs.getString("department"));
				employeeBean.setAddress(rs.getString("address"));
				employeeBean.setCity(rs.getString("city"));
				employeeBean.setState(rs.getString("state"));
				employeeBean.setPostalCode(rs.getString("postal_code"));
				employeeBean.setCountry(rs.getString("country"));
				employeeBean.setProfilePic(rs.getString("profile_pic"));
				employeeBean.setManagerId(rs.getString("manager_id"));
				employeeBean.setBranchId(rs.getString("branch_id"));
				employeeBean.setSalary(rs.getFloat("salary"));
				list.add(employeeBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static boolean update(EmployeeBean bean) {
		try {
			PreparedStatement pstmt = con.prepareStatement("update employee set first_name=?, last_Name=?, email=?, phone_Number=?, date_Of_Birth=?, hire_Date=?, department=?, address=?, city=?, state=?, postal_code=?, country=?, manager_id=?, branch_Id=?, salary=? where employee_Id=?");
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
			pstmt.setString(13, bean.getManagerId());
			pstmt.setString(14, bean.getBranchId());
			pstmt.setFloat(15, bean.getSalary());
			pstmt.setString(16, bean.getEmployeeId());
			if(pstmt.executeUpdate()>0)return true;
			else System.out.println("employee not found");
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
			PreparedStatement pstmt = con.prepareStatement("delete from employee where employee_id in ("+sb.toString()+")");
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
			PreparedStatement pstmt = con.prepareStatement("select count(*) from Employee");
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

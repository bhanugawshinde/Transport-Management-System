package com.Aarogya.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.Aarogya.DBConnection;
import com.Aarogya.bean.BranchBean;


public class BranchDao {
	private static Connection con = DBConnection.getConnection();
	
	public static boolean add(BranchBean branch) {
		PreparedStatement pstmt = null;
		try{
			pstmt = con.prepareStatement("insert into branch values(getBranchId(),?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pstmt.setString(1, branch.getBranchName());
			pstmt.setString(2, branch.getAddressLine1());
			pstmt.setString(3, branch.getCity());
			pstmt.setString(4, branch.getState());
			pstmt.setString(5, branch.getPostalCode());
			pstmt.setString(6, branch.getCountry());
			pstmt.setString(7, branch.getLatitude());
			pstmt.setString(8, branch.getLongitude());
			pstmt.setString(9, branch.getPhoneNumber());
			pstmt.setString(10, branch.getEmail());
			pstmt.setString(11, branch.getManagerId());
			pstmt.setString(12, branch.getStatus());
			
			Date date1 = branch.getDateEstablished();
			if(date1!=null) pstmt.setDate(13, new java.sql.Date(date1.getTime()));
			else pstmt.setDate(13, null);
			pstmt.setDate(14, null);
			
			 
			if(pstmt.executeUpdate()>0) return true; 
			
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
	public static List<BranchBean> view(){
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		List<BranchBean> list = new ArrayList<>();
		try {
			pstmt = con.prepareStatement("select * from branch");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BranchBean branchBean =  new BranchBean();
				branchBean.setBranchId(rs.getString("BranchId"));
				branchBean.setBranchName(rs.getString("BranchName"));
				branchBean.setManagerId(rs.getString("ManagerId"));;
				branchBean.setAddressLine1(rs.getString("AddressLine1"));
				branchBean.setCountry(rs.getString("Country"));
				branchBean.setState(rs.getString("State"));
				branchBean.setCity(rs.getString("City"));
				branchBean.setPostalCode(rs.getString("PostalCode"));
				branchBean.setLatitude(rs.getString("Latitude"));
				branchBean.setLongitude(rs.getString("Longitude"));
				branchBean.setPhoneNumber(rs.getString("PhoneNumber"));
				branchBean.setEmail(rs.getString("Email"));
				branchBean.setStatus(rs.getString("Status"));
				branchBean.setDateEstablished(rs.getDate("dateEstablished"));
				branchBean.setDateDeactivated(rs.getDate("dateDeactivated"));
				list.add(branchBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	public static boolean update(BranchBean bean) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("update branch set branchName=?, managerId=?, addressLine1=?, country=?, state=?, city=?, postalCode=?, latitude=?, longitude=?, phoneNumber=?, email=?, status=? where branchId=?");
			pstmt.setString(1, bean.getBranchName());
			pstmt.setString(2, bean.getManagerId());
			pstmt.setString(3, bean.getAddressLine1());
			pstmt.setString(4, bean.getCountry());
			pstmt.setString(5, bean.getState());
			pstmt.setString(6, bean.getCity());
			pstmt.setString(7, bean.getPostalCode());
			pstmt.setString(8, bean.getLatitude());
			pstmt.setString(9, bean.getLongitude());
			pstmt.setString(10, bean.getPhoneNumber());
			pstmt.setString(11, bean.getEmail());
			pstmt.setString(12, bean.getStatus());
			pstmt.setString(13, bean.getBranchId());
			if(pstmt.executeUpdate()>0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	
		if(ids.length==0)return true;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("'"+ids[0]+"'");
			for(int i = 1 ; i<ids.length; i++) {
				sb.append(",");
				sb.append("'"+ids[i]+"'");
			}
			pstmt = con.prepareStatement("delete from branch where branchId in ("+sb.toString()+")");
			if(pstmt.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			pstmt = con.prepareStatement("select count(*) from branch");
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
			
		}
		return 0;
	}
	public static int getTotalState() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("select count(distinct state) from branch");
			rs = pstmt.executeQuery();
			if(rs.next())return rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally {
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
	
	public static int getTotalManager() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("select count(Distinct MANAGERID) from branch ");
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
	public static int getTotalActive() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("select count(*) from branch where status='active'");
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

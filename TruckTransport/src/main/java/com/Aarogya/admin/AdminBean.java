package com.Aarogya.admin;

import java.util.Date;

import jakarta.servlet.http.HttpServlet;

@SuppressWarnings("serial")
public class AdminBean extends HttpServlet{
	private String adminId;
	private String name;
	private String position;
	private String email;
	private String phoneNumber;
	private Date dateJoined;
	private String status;
	
	public AdminBean() {
		super();
	}

	public AdminBean(String adminId, String name, String position, String email, String phoneNumber, Date dateJoined,
			String status) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.position = position;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateJoined = dateJoined;
		this.status = status;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AdminBean [adminId=" + adminId + ",\n<br> name=" + name + ",\n<br> position=" + position + ",\n<br> email=" + email
				+ ",\n<br> phoneNumber=" + phoneNumber + ",\n<br> dateJoined=" + dateJoined + ",\n<br> status=" + status + "]";
	}
	
	
}

package com.Aarogya.bean;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class BranchBean implements Serializable {
	private String branchId;
	private String branchName;
	private String managerId;
	private String AddressLine1;
	private String country;
	private String state;
	private String city;
	private String postalCode;
	private String latitude;
	private String longitude;
	private String phoneNumber;
	private String email;
	private String status;
	private Date dateEstablished;
	private Date dateDeactivated;
	public BranchBean() {
		super();
	}
	public BranchBean(String branchId, String branchName, String managerId, String addressLine1, String country,
			String state, String city, String postalCode, String latitude, String longitude, String phoneNumber,
			String email, String status, Date dateEstablished, Date dateDeactivated) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.managerId = managerId;
		AddressLine1 = addressLine1;
		this.country = country;
		this.state = state;
		this.city = city;
		this.postalCode = postalCode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.status = status;
		this.dateEstablished = dateEstablished;
		this.dateDeactivated = dateDeactivated;
	}
	public BranchBean(String branchName, String managerId, String addressLine1, String country, String state, String city,
			String postalCode, String latitude, String longitude, String phoneNumber, String email, String status,
			Date dateEstablished, Date dateDeactivated) {
		super();
		this.branchName = branchName;
		this.managerId = managerId;
		AddressLine1 = addressLine1;
		this.country = country;
		this.state = state;
		this.city = city;
		this.postalCode = postalCode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.status = status;
		this.dateEstablished = dateEstablished;
		this.dateDeactivated = dateDeactivated;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getAddressLine1() {
		return AddressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDateEstablished() {
		return dateEstablished;
	}
	public void setDateEstablished(Date dateEstablished) {
		this.dateEstablished = dateEstablished;
	}
	public Date getDateDeactivated() {
		return dateDeactivated;
	}
	public void setDateDeactivated(Date dateDeactivated) {
		this.dateDeactivated = dateDeactivated;
	}
	@Override
	public String toString() {
		return "Branch [\nbranchId=" + branchId + ",\n branchName=" + branchName + ",\n managerId=" + managerId
				+ ",\n AddressLine1=" + AddressLine1 + ",\n country=" + country + ",\n state=" + state + ",\n city=" + city
				+ ",\n postalCode=" + postalCode + ",\n latitude=" + latitude + ",\n longitude=" + longitude
				+ ",\n phoneNumber=" + phoneNumber + ",\n email=" + email + ",\n status=" + status + ",\n dateEstablished="
				+ dateEstablished + ",\n dateDeactivated=" + dateDeactivated + "\n]";
	}
	
	
}

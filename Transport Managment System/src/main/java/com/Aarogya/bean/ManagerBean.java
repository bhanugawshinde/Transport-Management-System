package com.Aarogya.bean;

import java.sql.Date;

public class ManagerBean {
    private String managerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date dateOfBirth;
    private Date hireDate;
    private String department;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String profilePic;
    private String branchId;
    private float salary;

    // No-argument constructor
    public ManagerBean() {}

    
    public ManagerBean(String managerId, String firstName, String lastName, String email, String phoneNumber,
			Date dateOfBirth, Date hireDate, String department, String address, String city, String state,
			String postalCode, String country, String profilePic, String branchId, float salary) {
		super();
		this.managerId = managerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.hireDate = hireDate;
		this.department = department;
		this.address = address;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.profilePic = profilePic;
		this.branchId = branchId;
		this.salary = salary;
	}


    
	public ManagerBean(String firstName, String lastName, String email, String phoneNumber, Date dateOfBirth,
			Date hireDate, String department, String address, String city, String state, String postalCode,
			String country, String profilePic, String branchId, float salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.hireDate = hireDate;
		this.department = department;
		this.address = address;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.profilePic = profilePic;
		this.branchId = branchId;
		this.salary = salary;
	}


	// Getters and Setters
    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public java.sql.Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(java.sql.Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public java.sql.Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(java.sql.Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }
    

	public float getSalary() {
		return salary;
	}


	public void setSalary(float salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "ManagerBean [managerId=" + managerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", dateOfBirth=" + dateOfBirth + ", hireDate="
				+ hireDate + ", department=" + department + ", address=" + address + ", city=" + city + ", state="
				+ state + ", postalCode=" + postalCode + ", country=" + country + ", profilePic=" + profilePic
				+ ", branchId=" + branchId + ", salary=" + salary + "]";
	}
    
}

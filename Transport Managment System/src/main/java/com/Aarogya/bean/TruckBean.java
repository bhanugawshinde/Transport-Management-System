package com.Aarogya.bean;

import java.sql.Date;

public class TruckBean {
    private String truckId;
    private String profile;
    private String licensePlate;
    private String companyName;
    private String model;
    private int yearOfManufacture;
    private String vehicleIdentificationNumber;
    private String color;
    private String type;
    private double capacityWeight;
    private double capacityVolume;
    private String registrationState;
    private Date registrationExpiryDate;
    private String insurancePolicyNumber;
    private Date insuranceExpiryDate;
    private Date inspectionDate;
    private String complianceCertificates;
    private float currentMileage;
    private String fuelType;
    private double fuelEfficiency;
    private String gpsTrackingId;
    private String assignedDriver;
    private Date maintenanceSchedule;
    private Date purchaseDate;
    private double purchasePrice;
    private double depreciation;
    private String additionalEquipment;
    private String safetyFeatures;
    private String telematicsSystem;
    private String specialPermits;
    private String branchId;

    
    
    public TruckBean() {
		super();
	}
    
    

	public TruckBean(String profile, String licensePlate, String companyName, String model, int yearOfManufacture,
			String vehicleIdentificationNumber, String color, String type, double capacityWeight, double capacityVolume,
			String registrationState, Date registrationExpiryDate, String insurancePolicyNumber,
			Date insuranceExpiryDate, Date inspectionDate, String complianceCertificates, float currentMileage,
			String fuelType, double fuelEfficiency, String gpsTrackingId, String assignedDriver,
			Date maintenanceSchedule, Date purchaseDate, double purchasePrice, double depreciation,
			String additionalEquipment, String safetyFeatures, String telematicsSystem, String specialPermits,
			String branchId) {
		super();
		this.profile = profile;
		this.licensePlate = licensePlate;
		this.companyName = companyName;
		this.model = model;
		this.yearOfManufacture = yearOfManufacture;
		this.vehicleIdentificationNumber = vehicleIdentificationNumber;
		this.color = color;
		this.type = type;
		this.capacityWeight = capacityWeight;
		this.capacityVolume = capacityVolume;
		this.registrationState = registrationState;
		this.registrationExpiryDate = registrationExpiryDate;
		this.insurancePolicyNumber = insurancePolicyNumber;
		this.insuranceExpiryDate = insuranceExpiryDate;
		this.inspectionDate = inspectionDate;
		this.complianceCertificates = complianceCertificates;
		this.currentMileage = currentMileage;
		this.fuelType = fuelType;
		this.fuelEfficiency = fuelEfficiency;
		this.gpsTrackingId = gpsTrackingId;
		this.assignedDriver = assignedDriver;
		this.maintenanceSchedule = maintenanceSchedule;
		this.purchaseDate = purchaseDate;
		this.purchasePrice = purchasePrice;
		this.depreciation = depreciation;
		this.additionalEquipment = additionalEquipment;
		this.safetyFeatures = safetyFeatures;
		this.telematicsSystem = telematicsSystem;
		this.specialPermits = specialPermits;
		this.branchId = branchId;
	}

	

	public TruckBean(String truckId, String profile, String licensePlate, String companyName, String model,
			int yearOfManufacture, String vehicleIdentificationNumber, String color, String type, double capacityWeight,
			double capacityVolume, String registrationState, Date registrationExpiryDate, String insurancePolicyNumber,
			Date insuranceExpiryDate, Date inspectionDate, String complianceCertificates, float currentMileage2,
			String fuelType, double fuelEfficiency, String gpsTrackingId, String assignedDriver,
			Date maintenanceSchedule, Date purchaseDate, double purchasePrice, double depreciation,
			String additionalEquipment, String safetyFeatures, String telematicsSystem, String specialPermits,
			String branchId) {
		super();
		this.truckId = truckId;
		this.profile = profile;
		this.licensePlate = licensePlate;
		this.companyName = companyName;
		this.model = model;
		this.yearOfManufacture = yearOfManufacture;
		this.vehicleIdentificationNumber = vehicleIdentificationNumber;
		this.color = color;
		this.type = type;
		this.capacityWeight = capacityWeight;
		this.capacityVolume = capacityVolume;
		this.registrationState = registrationState;
		this.registrationExpiryDate = registrationExpiryDate;
		this.insurancePolicyNumber = insurancePolicyNumber;
		this.insuranceExpiryDate = insuranceExpiryDate;
		this.inspectionDate = inspectionDate;
		this.complianceCertificates = complianceCertificates;
		this.currentMileage = currentMileage2;
		this.fuelType = fuelType;
		this.fuelEfficiency = fuelEfficiency;
		this.gpsTrackingId = gpsTrackingId;
		this.assignedDriver = assignedDriver;
		this.maintenanceSchedule = maintenanceSchedule;
		this.purchaseDate = purchaseDate;
		this.purchasePrice = purchasePrice;
		this.depreciation = depreciation;
		this.additionalEquipment = additionalEquipment;
		this.safetyFeatures = safetyFeatures;
		this.telematicsSystem = telematicsSystem;
		this.specialPermits = specialPermits;
		this.branchId = branchId;
	}



	// Getters and Setters
    public String getTruckId() {
        return truckId;
    }

    public void setTruckId(String truckId) {
        this.truckId = truckId;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getVehicleIdentificationNumber() {
        return vehicleIdentificationNumber;
    }

    public void setVehicleIdentificationNumber(String vehicleIdentificationNumber) {
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCapacityWeight() {
        return capacityWeight;
    }

    public void setCapacityWeight(double capacityWeight) {
        this.capacityWeight = capacityWeight;
    }

    public double getCapacityVolume() {
        return capacityVolume;
    }

    public void setCapacityVolume(double capacityVolume) {
        this.capacityVolume = capacityVolume;
    }

    public String getRegistrationState() {
        return registrationState;
    }

    public void setRegistrationState(String registrationState) {
        this.registrationState = registrationState;
    }

    public Date getRegistrationExpiryDate() {
        return registrationExpiryDate;
    }

    public void setRegistrationExpiryDate(Date registrationExpiryDate) {
        this.registrationExpiryDate = registrationExpiryDate;
    }

    public String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    public void setInsurancePolicyNumber(String insurancePolicyNumber) {
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public Date getInsuranceExpiryDate() {
        return insuranceExpiryDate;
    }

    public void setInsuranceExpiryDate(Date insuranceExpiryDate) {
        this.insuranceExpiryDate = insuranceExpiryDate;
    }

    public Date getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(Date inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getComplianceCertificates() {
        return complianceCertificates;
    }

    public void setComplianceCertificates(String complianceCertificates) {
        this.complianceCertificates = complianceCertificates;
    }

    public float getCurrentMileage() {
        return currentMileage;
    }

    public void setCurrentMileage(float currentMileage) {
        this.currentMileage = currentMileage;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public double getFuelEfficiency() {
        return fuelEfficiency;
    }

    public void setFuelEfficiency(double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }

    public String getGpsTrackingId() {
        return gpsTrackingId;
    }

    public void setGpsTrackingId(String gpsTrackingId) {
        this.gpsTrackingId = gpsTrackingId;
    }

    public String getAssignedDriver() {
        return assignedDriver;
    }

    public void setAssignedDriver(String assignedDriver) {
        this.assignedDriver = assignedDriver;
    }

    public Date getMaintenanceSchedule() {
        return maintenanceSchedule;
    }

    public void setMaintenanceSchedule(Date maintenanceSchedule) {
        this.maintenanceSchedule = maintenanceSchedule;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getDepreciation() {
        return depreciation;
    }

    public void setDepreciation(double depreciation) {
        this.depreciation = depreciation;
    }

    public String getAdditionalEquipment() {
        return additionalEquipment;
    }

    public void setAdditionalEquipment(String additionalEquipment) {
        this.additionalEquipment = additionalEquipment;
    }

    public String getSafetyFeatures() {
        return safetyFeatures;
    }

    public void setSafetyFeatures(String safetyFeatures) {
        this.safetyFeatures = safetyFeatures;
    }

    public String getTelematicsSystem() {
        return telematicsSystem;
    }

    public void setTelematicsSystem(String telematicsSystem) {
        this.telematicsSystem = telematicsSystem;
    }

    public String getSpecialPermits() {
        return specialPermits;
    }

    public void setSpecialPermits(String specialPermits) {
        this.specialPermits = specialPermits;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }


	@Override
	public String toString() {
	    return "TruckBean {\n" +
	            "  truckId='" + truckId + "',\n" +
	            "  profile='" + profile + "',\n" +
	            "  licensePlate='" + licensePlate + "',\n" +
	            "  companyName='" + companyName + "',\n" +
	            "  model='" + model + "',\n" +
	            "  yearOfManufacture=" + yearOfManufacture + ",\n" +
	            "  vehicleIdentificationNumber='" + vehicleIdentificationNumber + "',\n" +
	            "  color='" + color + "',\n" +
	            "  type='" + type + "',\n" +
	            "  capacityWeight=" + capacityWeight + ",\n" +
	            "  capacityVolume=" + capacityVolume + ",\n" +
	            "  registrationState='" + registrationState + "',\n" +
	            "  registrationExpiryDate=" + registrationExpiryDate + ",\n" +
	            "  insurancePolicyNumber='" + insurancePolicyNumber + "',\n" +
	            "  insuranceExpiryDate=" + insuranceExpiryDate + ",\n" +
	            "  inspectionDate=" + inspectionDate + ",\n" +
	            "  complianceCertificates='" + complianceCertificates + "',\n" +
	            "  currentMileage=" + currentMileage + ",\n" +
	            "  fuelType='" + fuelType + "',\n" +
	            "  fuelEfficiency=" + fuelEfficiency + ",\n" +
	            "  gpsTrackingId='" + gpsTrackingId + "',\n" +
	            "  assignedDriver='" + assignedDriver + "',\n" +
	            "  maintenanceSchedule=" + maintenanceSchedule + ",\n" +
	            "  purchaseDate=" + purchaseDate + ",\n" +
	            "  purchasePrice=" + purchasePrice + ",\n" +
	            "  depreciation=" + depreciation + ",\n" +
	            "  additionalEquipment='" + additionalEquipment + "',\n" +
	            "  safetyFeatures='" + safetyFeatures + "',\n" +
	            "  telematicsSystem='" + telematicsSystem + "',\n" +
	            "  specialPermits='" + specialPermits + "',\n" +
	            "  branchId='" + branchId + "'\n" +
	            "}";
	}

    
}

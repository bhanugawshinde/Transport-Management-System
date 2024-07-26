<html>
<head>
<title>Add Truck</title>
<style type="text/css">
#add-truck{
	border-radius: 15px;
    background-color: #272727;
    color: #ffffffd1;
    text-shadow: 1px 1px #043895;
    box-shadow: 0px 0px 5px white;
}
</style>
<script type="text/javascript" src="FrontEnd/src/js/script.js"></script>
</head>
<body >
<h2 class="formHead">Add Truck</h2>
<p id=resp></p>
<form method=post class="form" id=addTruck enctype="multipart/form-data">
	<h3 class="formGroupHead">Basic Details:</h3>
<div class="form-group">
	<div>
		<label for="profile">Profile</label>
		<input type="file" id="profile" name="profile" value="default.png" maxlength="50">	
	</div>
	<div>
		<label for="licensePlate">License Plate</label>
		<input type="text" id="licensePlate" name="licensePlate" maxlength="20" required>	
	</div>
	<div>
		<label for="companyName">Company Name</label>
		<input type="text" id="companyName" name="companyName" maxlength="50" required>	
	</div>
</div>

	<h3 class="formGroupHead">Vehicle Details:</h3>
<div class="form-group">
	<div>
		<label for="model">Model</label>
		<input type="text" id="model" name="model" maxlength="50" required>	
	</div>
	<div>
		<label for="yearOfManufacture">Year of Manufacture</label>
		<input type="number" value="0" id="yearOfManufacture" name="yearOfManufacture" min="1900" max="2100" required>	
	</div>
	<div>
		<label for="vin">Vehicle Identification Number</label>
		<input type="text" id="vin" name="vehicleIdentificationNumber" maxlength="50" required>	
	</div>
	<div>
		<label for="color">Color</label>
		<input type="text" id="color" name="color" maxlength="20">	
	</div>
	<div>
		<label for="type">Type</label>
		<input type="text" id="type" name="type" maxlength="50" required>	
	</div>
	<div>
		<label for="capacityWeight">Capacity Weight</label>
		<input type="number" value="0" id="capacityWeight" name="capacityWeight" step="0.01" required >	
	</div>
	<div>
		<label for="capacityVolume">Capacity Volume</label>
		<input type="number" value="0" id="capacityVolume" name="capacityVolume" step="0.01" required>	
	</div>
	<div>
		<label for="registrationState">Registration State</label>
		<input type="text" id="registrationState" name="registrationState" maxlength="50" required>	
	</div>
	<div>
		<label for="registrationExpiryDate">Registration Expiry Date</label>
		<input type="date" id="registrationExpiryDate" name="registrationExpiryDate" required>	
	</div>
</div>

	<h3 class="formGroupHead">Insurance and Compliance:</h3>
<div class="form-group">
	<div>
		<label for="insurancePolicyNumber">Insurance Policy Number</label>
		<input type="text" id="insurancePolicyNumber" name="insurancePolicyNumber" maxlength="50" required>	
	</div>
	<div>
		<label for="insuranceExpiryDate">Insurance Expiry Date</label>
		<input type="date" id="insuranceExpiryDate" name="insuranceExpiryDate" required>	
	</div>
	<div>
		<label for="inspectionDate">Inspection Date</label>
		<input type="date" id="inspectionDate" name="inspectionDate" required>	
	</div>
	<div>
		<label for="complianceCertificates">Compliance Certificates</label>
		<input type="file" id="complianceCertificates" name="complianceCertificates" maxlength="50">	
	</div>
</div>

	<h3 class="formGroupHead">Performance and Tracking:</h3>
<div class="form-group">
	<div>
		<label for="currentMileage">Current Mileage</label>
		<input type="number" value="0" id="currentMileage" name="currentMileage" required>	
	</div>
	<div>
		<label for="fuelType">Fuel Type</label>
		<input type="text" id="fuelType" name="fuelType" maxlength="20" required>	
	</div>
	<div>
		<label for="fuelEfficiency">Fuel Efficiency</label>
		<input type="number" value="0" id="fuelEfficiency" name="fuelEfficiency" step="0.01" required>	
	</div>
	<div>
		<label for="gpsTrackingId">GPS Tracking ID</label>
		<input type="text" id="gpsTrackingId" name="gpsTrackingId" maxlength="50">	
	</div>
	<div>
		<label for="assignedDriver">Assigned Driver</label>
		<input type="text" id="assignedDriver" name="assignedDriver" maxlength="50">	
	</div>
</div>

	<h3 class="formGroupHead">Maintenance and Financial:</h3>
<div class="form-group">
	<div>
		<label for="maintenanceSchedule">Maintenance Schedule</label>
		<input type="date" id="maintenanceSchedule" name="maintenanceSchedule" required>	
	</div>
	<div>
		<label for="purchaseDate">Purchase Date</label>
		<input type="date" id="purchaseDate" name="purchaseDate" required>	
	</div>
	<div>
		<label for="purchasePrice">Purchase Price</label>
		<input type="number" value="0" id="purchasePrice" name="purchasePrice" step="0.01" required>	
	</div>
	<div>
		<label for="depreciation">Depreciation</label>
		<input type="number" value="0" id="depreciation" name="depreciation" step="0.01" required>	
	</div>
</div>

	<h3 class="formGroupHead">Additional Details:</h3>
<div class="form-group">
	<div>
		<label for="additionalEquipment">Additional Equipment</label>
		<input type="text" id="additionalEquipment" name="additionalEquipment" maxlength="50">	
	</div>
	<div>
		<label for="safetyFeatures">Safety Features</label>
		<input type="text" id="safetyFeatures" name="safetyFeatures" maxlength="50">	
	</div>
	<div>
		<label for="telematicsSystem">Telematics System</label>
		<input type="text" id="telematicsSystem" name="telematicsSystem" maxlength="50">	
	</div>
	<div>
		<label for="specialPermits">Special Permits</label>
		<input type="text" id="specialPermits" name="specialPermits" maxlength="50">	
	</div>
	<div >
        <label for="branchId">Branch Id</label>
        <select id="branchId" name="branchId">
        	<option></option>
        </select>
     </div>
</div>
</form>
<button class=button type="button" onclick="submit(event,'http://localhost:8080/Transport-Managment-System/AddTruck','addTruck','http://localhost:8080/Transport-Managment-System/ViewTruck');">
Add Truck
</button>
<script type="text/javascript">
</script>
</body>
</html>

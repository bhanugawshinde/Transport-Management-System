<%@page import="java.util.Map"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="com.Aarogya.util.Util"%>
<html>
<head>
<title>Add Truck</title>
<style type="text/css">
#update-truck{
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
<h2 class="formHead">Update Truck</h2>
<% 
Map<String, Object> mapObject = Util.jsonToMap(request.getInputStream());
Map<String, String> map = mapObject.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry-> entry.getValue().toString()));
%>
<form method=post class="form" id=updateTruck enctype="multipart/form-data">
	<h3 class="formGroupHead">Basic Details:</h3>
<div class="form-group">
	<div>
		<label for="truckId">Truck Id</label>
		<input type="text" id="truckId" name="truckId" value="<%=map.get("truckId") %>" maxlength="50" readonly="readonly">	
	</div>
	<div>
		<label for="profile">Profile</label>
		<input type="file" id="profile" name="profile" <%=map.get("profile")%> maxlength="50">	
	</div>
	<div>
		<label for="licensePlate">License Plate</label>
		<input type="text" id="licensePlate" name="licensePlate" value="<%=map.get("licensePlate")==null?"":map.get("licensePlate")%>" maxlength="20" required>	
	</div>
	<div>
		<label for="companyName">Company Name</label>
		<input type="text" id="companyName" name="companyName" value="<%=map.get("companyName")==null?"":map.get("companyName")%>" maxlength="50" required>	
	</div>
</div>

	<h3 class="formGroupHead">Vehicle Details:</h3>
<div class="form-group">
	<div>
		<label for="model">Model</label>
		<input type="text" id="model" name="model" value="<%=map.get("model")==null?"":map.get("model")%>" maxlength="50" required>	
	</div>
	<div>
		<label for="yearOfManufacture">Year of Manufacture</label>
		<input type="number" id="yearOfManufacture" name="yearOfManufacture" value="<%=map.get("yearOfManufacture")==null?"0":(int) Double.parseDouble(map.get("yearOfManufacture"))%>"  min="1900" max="2100" step="1" required>
	</div>
	<div>
		<label for="vin">Vehicle Identification Number</label>
		<input type="text" id="vin" name="vehicleIdentificationNumber" value="<%=map.get("vehicleIdentificationNumber")==null?"":map.get("vehicleIdentificationNumber")%>" maxlength="50" required>	
	</div>
	<div>
		<label for="color">Color</label>
		<input type="text" id="color" name="color" value="<%=map.get("color")==null?"":map.get("color")%>" maxlength="20">	
	</div>
	<div>
		<label for="type">Type</label>
		<input type="text" id="type" name="type" value="<%=map.get("type")==null?"":map.get("type")%>" maxlength="50" required>	
	</div>
	<div>
		<label for="capacityWeight">Capacity Weight</label>
		<input type="number" id="capacityWeight" name="capacityWeight" value="<%=map.get("capacityWeight")==null?"0":map.get("capacityWeight")%>" step="0.01" required >	
	</div>
	<div>
		<label for="capacityVolume">Capacity Volume</label>
		<input type="number" id="capacityVolume" name="capacityVolume" value="<%=map.get("capacityVolume")==null?"0":map.get("capacityVolume")%>" step="0.01" required>	
	</div>
	<div>
		<label for="registrationState">Registration State</label>
		<input type="text" id="registrationState" name="registrationState" value="<%=map.get("registrationState")==null?"":map.get("registrationState")%>" maxlength="50" required>	
	</div>
	<div>
		<label for="registrationExpiryDate">Registration ExpiryDate</label>
		<input type="date" id="registrationExpiryDate" name="registrationExpiryDate" value="<%=Util.formatDate(map.get("registrationExpiryDate"))%>"  required>	
	</div>
</div>

	<h3 class="formGroupHead">Insurance and Compliance:</h3>
<div class="form-group">
	<div>
		<label for="insurancePolicyNumber">Insurance Policy Number</label>
		<input type="text" id="insurancePolicyNumber" name="insurancePolicyNumber" value="<%=map.get("insurancePolicyNumber")==null?"":map.get("insurancePolicyNumber")%>" maxlength="50" required>	
	</div>
	<div>
		<label for="insuranceExpiryDate">Insurance Expiry Date</label>
		<input type="date" id="insuranceExpiryDate" name="insuranceExpiryDate" value="<%=Util.formatDate(map.get("insuranceExpiryDate"))%>" required>	
	</div>
	<div>
		<label for="inspectionDate">Inspection Date</label>
		<input type="date" id="inspectionDate" name="inspectionDate" value="<%=Util.formatDate(map.get("inspectionDate"))%>" required>	
	</div>
	<div>
		<label for="complianceCertificates">Compliance Certificates</label>
		<input type="file" id="complianceCertificates" name="complianceCertificates" value="<%=map.get("complianceCertificates")==null?"":map.get("complianceCertificates")%>" maxlength="50">	
	</div>
</div>

	<h3 class="formGroupHead">Performance and Tracking:</h3>
<div class="form-group">
	<div>
		<label for="currentMileage">Current Mileage</label>
		<input type="number" id="currentMileage" name="currentMileage" value="<%=map.get("currentMileage")==null?"0":map.get("currentMileage")%>" required>	
	</div>
	<div>
		<label for="fuelType">Fuel Type</label>
		<input type="text" id="fuelType" name="fuelType" value="<%=map.get("fuelType")==null?"":map.get("fuelType")%>" maxlength="20" required>	
	</div>
	<div>
		<label for="fuelEfficiency">Fuel Efficiency</label>
		<input type="number"  id="fuelEfficiency" name="fuelEfficiency" value="<%=map.get("fuelEfficiency")==null?"0":map.get("fuelEfficiency")%>" step="0.01" required>	
	</div>
	<div>
		<label for="gpsTrackingId">GPS Tracking ID</label>
		<input type="text" id="gpsTrackingId" name="gpsTrackingId" value="<%=map.get("gpsTrackingId")==null?"0":map.get("gpsTrackingId")%>" maxlength="50">	
	</div>
	<div>
		<label for="assignedDriver">Assigned Driver</label>
		<input type="text" id="assignedDriver" name="assignedDriver" value="<%=map.get("assignedDriver")==null?"0":map.get("assignedDriver")%>" maxlength="50">	
	</div>
</div>

	<h3 class="formGroupHead">Maintenance and Financial:</h3>
<div class="form-group">
	<div>
		<label for="maintenanceSchedule">Maintenance Schedule</label>
		<input type="date" id="maintenanceSchedule" name="maintenanceSchedule" value="<%=Util.formatDate(map.get("maintenanceSchedule"))%>" required>	
	</div>
	<div>
		<label for="purchaseDate">Purchase Date</label>
		<input type="date" id="purchaseDate" name="purchaseDate" value="<%=Util.formatDate(map.get("purchaseDate"))%>" required>	
	</div>
	<div>
		<label for="purchasePrice">Purchase Price</label>
		<input type="number"  id="purchasePrice" name="purchasePrice" value="<%=map.get("purchasePrice")==null?"0":map.get("purchasePrice")%>" step="0.01" required>	
	</div>
	<div>
		<label for="depreciation">Depreciation</label>
		<input type="number"  id="depreciation" name="depreciation" value="<%=map.get("depreciation")==null?"0":map.get("depreciation")%>" step="0.01" required>	
	</div>
</div>

	<h3 class="formGroupHead">Additional Details:</h3>
<div class="form-group">
	<div>
		<label for="additionalEquipment">Additional Equipment</label>
		<input type="text" id="additionalEquipment" name="additionalEquipment"  value="<%=map.get("additionalEquipment")==null?"":map.get("additionalEquipment")%>" maxlength="50">	
	</div>
	<div>
		<label for="safetyFeatures">Safety Features</label>
		<input type="text" id="safetyFeatures" name="safetyFeatures" value="<%=map.get("safetyFeatures")==null?"":map.get("safetyFeatures")%>" maxlength="50">	
	</div>
	<div>
		<label for="telematicsSystem">Telematics System</label>
		<input type="text" id="telematicsSystem" name="telematicsSystem" value="<%=map.get("telematicsSystem")==null?"":map.get("telematicsSystem")%>" maxlength="50">	
	</div>
	<div>
		<label for="specialPermits">Special Permits</label>
		<input type="text" id="specialPermits" name="specialPermits" value="<%=map.get("specialPermits")==null?"":map.get("specialPermits")%>" maxlength="50">	
	</div>
	<div >
        <label for="branchId">Branch Id</label>
        <select id="branchId" name="branchId">
        	<option value="<%=map.get("branchId")==null?"":map.get("branchId")%>" selected="selected"></option>
        </select>
     </div>
</div>
</form>
<button class=button type="button" onclick="submit(event,'UpdateTruck','updateTruck','ViewTruck?var=update');">
Update Truck
</button>
<script type="text/javascript">
</script>
</body>
</html>

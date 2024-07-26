
<%@page import="com.Aarogya.util.Util"%>
<%@page import="com.Aarogya.bean.TruckBean"%>
<%@page import="com.Aarogya.bean.BranchBean"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>Delete Truck</title>
<style type="text/css">
#delete-Truck{
	border-radius: 15px;
    background-color: #272727;
    color: #ffffffd1;
    text-shadow: 1px 1px #043895;
    box-shadow: 0px 0px 5px white;
}
</style>
</head>
<body>
<h2 class="formHead">Delete Truck</h2>
<%List<TruckBean> list = (List<TruckBean>)request.getAttribute("list");%>
<table class="table">
<thead>
    <tr>
        <th>Truck Id</th>
        <th>Profile</th>
        <th>License Plate</th>
        <th>Company Name</th>
        <th>Model</th>
        <th>Year Of Manufacture</th>
        <th>Vehicle Identification Number</th>
        <th>Color</th>
        <th>Type</th>
        <th>Capacity Weight</th>
        <th>Capacity Volume</th>
        <th>Registration State</th>
        <th>Registration ExpiryDate</th>
        <th>Insurance Policy Number</th>
        <th>Insurance ExpiryDate</th>
        <th>Inspection Date</th>
        <th>Compliance Certificates</th>
        <th>Current Mileage</th>
        <th>FuelType</th>
        <th>FuelEfficiency</th>
        <th>gpsTrackingId</th>
        <th>assignedDriver</th>
        <th>maintenanceSchedule</th>
        <th>purchaseDate</th>
        <th>purchasePrice</th>
        <th>depreciation</th>
        <th>additionalEquipment</th>
        <th>safetyFeatures</th>
        <th>telematicsSystem</th>
        <th>specialPermits</th>
        <th>branchId</th>
    </tr>
</thead>
<tbody>
<% 
	for(TruckBean bean : list){
	String jsonString = Util.ObjectToString(bean);
	%>
	 
    <tr select="no" id=<%=bean.getTruckId()%> onclick="selectRow('<%=bean.getTruckId()%>')" >
       <td><%=bean.getTruckId() %></td>
        <td><%=bean.getProfile() %></td>
        <td><%=bean.getLicensePlate() %></td>
        <td><%=bean.getCompanyName() %></td>
        <td><%=bean.getModel() %></td>
        <td><%=bean.getYearOfManufacture() %></td>
        <td><%=bean.getVehicleIdentificationNumber() %></td>
        <td><%=bean.getColor() %></td>
        <td><%=bean.getType() %></td>
        <td><%=bean.getCapacityWeight() %></td>
        <td><%=bean.getCapacityVolume() %></td>
        <td><%=bean.getRegistrationState() %></td>
        <td><%=bean.getRegistrationExpiryDate() %></td>
        <td><%=bean.getInsurancePolicyNumber() %></td>
        <td><%=bean.getInsuranceExpiryDate() %></td>
        <td><%=bean.getInspectionDate() %></td>
        <td><%=bean.getComplianceCertificates() %></td>
        <td><%=bean.getCurrentMileage() %></td>
        <td><%=bean.getFuelType() %></td>
        <td><%=bean.getFuelEfficiency() %></td>
        <td><%=bean.getGpsTrackingId() %></td>
        <td><%=bean.getAssignedDriver() %></td>
        <td><%=bean.getMaintenanceSchedule() %></td>
        <td><%=bean.getPurchaseDate() %></td>
        <td><%=bean.getPurchasePrice() %></td>
        <td><%=bean.getDepreciation() %></td>
        <td><%=bean.getAdditionalEquipment() %></td>
        <td><%=bean.getSafetyFeatures() %></td>
        <td><%=bean.getTelematicsSystem() %></td>
        <td><%=bean.getSpecialPermits() %></td>
        <td><%=bean.getBranchId() %></td>
     	
    </tr>
	<% 	
	}
%>
</tbody>

<tfoot>

</tfoot>
</table>
<button class="delete" onclick="deleteRow('http://localhost:8080/Transport-Managment-System/DeleteTruck','http://localhost:8080/Transport-Managment-System/ViewTruck?var=delete')">Delete</button>

</body>
</html>

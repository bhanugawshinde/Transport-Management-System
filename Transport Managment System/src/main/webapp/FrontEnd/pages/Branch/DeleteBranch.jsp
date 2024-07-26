
<%@page import="com.Aarogya.bean.BranchBean"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>Delete</title>
<style type="text/css">
#delete-branch{
	border-radius: 15px;
    background-color: #272727;
    color: #ffffffd1;
    text-shadow: 1px 1px #043895;
    box-shadow: 0px 0px 5px white;
}
</style>
</head>
<body>
<h2 class="formHead">Delete Branch</h2>
<%List<BranchBean> list = (List<BranchBean>)request.getAttribute("list");%>
<table class="table">
<thead>
    <tr>
        <th>Branch Id</th>
        <th>Branch Name</th>
        <th>Manager Id</th>
        <th>Address Line1</th>
        <th>Country</th>
        <th>State</th>
        <th>city</th>
        <th>postalCode</th>
        <th>Latitude</th>
        <th>Longitude</th>
        <th>Phone Number</th>
        <th>Email</th>
        <th>Status</th>
        <th>Date Established</th>
        <th>Date Deactivated</th>
    </tr>
</thead>
<tbody>
<% 
	for(BranchBean bean : list){
		%>
	
    <tr select="no" id=<%=bean.getBranchId()%> onclick="selectRow('<%=bean.getBranchId()%>')" >
        <td><%=bean.getBranchId() %></td>
        <td><%=bean.getBranchName() %></td>
        <td><%=bean.getManagerId() %></td>
        <td><%=bean.getAddressLine1() %></td>
        <td><%=bean.getCountry() %></td>
        <td><%=bean.getState() %></td>
        <td><%=bean.getCity() %></td>
        <td><%=bean.getPostalCode() %></td>
        <td><%=bean.getLatitude() %></td>
        <td><%=bean.getLongitude() %></td>
        <td><%=bean.getPhoneNumber() %></td>
        <td><%=bean.getEmail() %></td>
        <td><%=bean.getState() %></td>
        <td><%=bean.getDateEstablished() %></td>
        <td><%=bean.getDateDeactivated() %></td>
    </tr>
	<% 	
	}
%>
</tbody>

</table>
<button class="delete" onclick="deleteRow('http://localhost:8080/Transport-Managment-System/DeleteBranch','http://localhost:8080/Transport-Managment-System/ViewBranch?var=delete')">Delete</button>
</body>
</html>

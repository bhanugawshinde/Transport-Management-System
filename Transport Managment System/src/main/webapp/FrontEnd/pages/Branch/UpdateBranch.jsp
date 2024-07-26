
<%@page import="com.Aarogya.bean.BranchBean"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>View</title>
<style type="text/css">
#update-branch{
	border-radius: 15px;
    background-color: #272727;
    color: #ffffffd1;
    text-shadow: 1px 1px #043895;
    box-shadow: 0px 0px 5px white;
}
</style>
</head>
<body>
<h2 class="formHead">Update Branch</h2>
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
		String params = "branchId=" + bean.getBranchId() +
                "&branchName=" + bean.getBranchName() +
                "&managerId=" + bean.getManagerId() +
                "&addressLine1=" + bean.getAddressLine1() +
                "&country=" + bean.getCountry() +
                "&state=" + bean.getState() +
                "&city=" + bean.getCity() +
                "&postalCode=" + bean.getPostalCode() +
                "&latitude=" + bean.getLatitude() +
                "&longitude=" + bean.getLongitude() +
                "&phoneNumber=" + bean.getPhoneNumber() +
                "&email=" + bean.getEmail() +
                "&status=" + bean.getStatus() +
                "&dateEstablished=" + bean.getDateEstablished() +
                "&dateDeactivated=" + bean.getDateDeactivated(); 
     %>
	
    <tr id=<%=bean.getBranchId()%> onclick="get('FrontEnd/pages/Branch/UpdateBranchForm.jsp?<%=params%>','page-content')">
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
        <td><%=bean.getStatus()%></td>
        <td><%=bean.getDateEstablished() %></td>
        <td><%=bean.getDateDeactivated() %></td>
    </tr>
	<% 	
	}
%>
</tbody>

<tfoot>

</tfoot>
</table>

</body>
</html>

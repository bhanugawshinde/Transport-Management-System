
<%@page import="com.Aarogya.util.Util"%>
<%@page import="com.Aarogya.bean.EmployeeBean"%>
<%@page import="com.Aarogya.bean.BranchBean"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>Delete Employee</title>
<style type="text/css">
#delete-Employee{
	border-radius: 15px;
    background-color: #272727;
    color: #ffffffd1;
    text-shadow: 1px 1px #043895;
    box-shadow: 0px 0px 5px white;
}
</style>
</head>
<body>
<h2 class="formHead">Delete Employee</h2>
<%List<EmployeeBean> list = (List<EmployeeBean>)request.getAttribute("list");%>
<table class="table">
<thead>
    <tr>
        <th>Employee Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Phone Number</th>
        <th>Date Of Birth</th>
        <th>Hire Date</th>
        <th>Department</th>
        <th>Address</th>
        <th>City</th>
        <th>State</th>
        <th>postalCode</th>
        <th>Country</th>
        <th>Profile Pic</th>
        <th>Manager Id</th>
        <th>Branch Id</th>
        <th>Salary</th>
    </tr>
</thead>
<tbody>
<% 
	for(EmployeeBean bean : list){
	String jsonString = Util.ObjectToString(bean);
	%>
	 
    <tr select="no" id=<%=bean.getEmployeeId()%> onclick="selectRow('<%=bean.getEmployeeId()%>')" >
        <td><%=bean.getEmployeeId() %></td>
        <td><%=bean.getFirstName()%></td>
        <td><%=bean.getLastName() %></td>
        <td><%=bean.getPhoneNumber() %></td>
        <td><%=bean.getDateOfBirth() %></td>
        <td><%=bean.getHireDate() %></td>
        <td><%=bean.getDepartment() %></td>
        <td><%=bean.getEmail() %></td>
        <td><%=bean.getAddress() %></td>
        <td><%=bean.getCity() %></td>
        <td><%=bean.getState() %></td>
        <td><%=bean.getPostalCode() %></td>
        <td><%=bean.getCountry() %></td>
        <td><%=bean.getProfilePic() %></td>
        <td><%=bean.getManagerId() %></td>
        <td><%=bean.getBranchId() %></td>
        <td><%=bean.getSalary() %></td>
    </tr>
	<% 	
	}
%>
</tbody>

<tfoot>

</tfoot>
</table>
<button class="delete" onclick="deleteRow('DeleteEmployee','ViewEmployee?var=delete')">Delete</button>

</body>
</html>

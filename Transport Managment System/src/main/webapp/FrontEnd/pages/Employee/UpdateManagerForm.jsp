<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.Map"%>
<%@page import="com.Aarogya.util.Util"%>
<%@page import="com.Aarogya.bean.ManagerBean"%>
<html>
<head>
<title>Update Manger Form</title>
<style type="text/css">
#update-manager{
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
<h2 class="formHead">Update Manager</h2>
<% 
Map<String, Object> mapObject = Util.jsonToMap(request.getInputStream());
Map<String, String> map = mapObject.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry-> entry.getValue().toString()));

%>
	
<p id=resp></p>
<form method=post class="form" id=updateManager >
	<h3 class="formGroupHead">General Details:</h3>
<div class="form-group">
	<div>
	<label for="managerId">Manager Id</label>
	<input type="text" id=managerId name="managerId" maxlength="50" value="<%=map.get("managerId")%>" readonly="readonly">	
	</div>
	<div>
	<label for="firstName">First Name</label>
	<input type="text" id=firstName name="firstName" maxlength="50" value="<%=map.get("firstName")%>">	
	</div>
	<div>
	<label for="lastName">Last Name</label>
	<input type="text" id=lastName name="lastName" maxlength="50" value="<%=map.get("lastName")%>">	
	</div>
	<div>
	<label for="dateOfBirth">Date Of Birth</label>
	<input type="date" id=dateOfBirth name="dateOfBirth" value="<%=Util.formatDate(map.get("dateOfBirth"))%>">
	</div>
</div>
	<h3 class="formGroupHead">Address:</h3>
<div class="form-group">
	<div>	
	<label for="address">Address </label>
    <input type="text" id="address" name="address" maxlength="50" required value="<%=map.get("address")%>">
	</div>
   		<div >
            <label for="country" onclick="call()">Country</label>
            <select id="country" name="country" required>
                    <option selected="selected" value="<%=map.get("country")%>"><%=map.get("country")%></option>
            </select>    
        </div>
            <div >
                <label for="state">State</label>
                <select id="state" name="state" required>
                    <option selected="selected" value="<%=map.get("state")%>"><%=map.get("state")%></option>
                </select>
            </div>
            <div >
                <label for="city">City</label>
                <select id="city" name="city" required>
                    <option selected="selected" value="<%=map.get("city")%>"><%=map.get("city")%>"</option>
                </select>
            </div>
            <div >
                <label for="postalCode">Postal Code</label>
                <input type="text" id="postalCode" name="postalCode" maxlength="20" required value="<%=map.get("postalCode")%>">
            </div>
</div>
	<h3 class="formGroupHead">Contact Details:</h3>
<div class="form-group">
	<div>
	<label for="phoneNumber">Phone Number</label>
    <input type="text" id="phoneNumber" name="phoneNumber" maxlength="20" value="<%=map.get("phoneNumber")%>">
    </div>
    <div>
	<label for="email">Email</label>
    <input type="email" id="email" name="email" maxlength="50" value="<%=map.get("email")%>">
    </div>
</div>
	<h3 class="formGroupHead">Company Details</h3>
<div class="form-group">
	 <div >
        <label for="branchId">Branch Id</label>
        <select id="branchId" name="branchId">
        	<option selected="selected"><%=map.get("branchId")%></option>
        </select>
     </div>
	 <div >
        <label for="department">Department</label>
        <select id="department" name="department">
        	<option selected="selected"><%=map.get("department")%></option>
        </select>
     </div>
	 <div>
	<label for="hireDate">HireDate</label>
	<input type="date" id=hireDate name="hireDate" value="<%=Util.formatDate(map.get("hireDate"))%>">
	</div>
	 <div >
        <label for="salary">Salary</label>
        <input type="number" id="salary" name="salary" value="<%=map.get("salary")%>">
     </div>    
</div>
</form>
<button class=button type="button" onclick="submit(event,'http://localhost:8080/Transport-Managment-System/UpdateManager','updateManager','http://localhost:8080/Transport-Managment-System/ViewManager');">
Update Manager
</button>
<script type="text/javascript">
</script>
</body>
</html>

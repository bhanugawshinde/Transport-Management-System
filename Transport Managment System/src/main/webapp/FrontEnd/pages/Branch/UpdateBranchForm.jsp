<html>
<head>
<title>Insert title here</title>
<style type="text/css">
#update-branch{
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
<h2 class="formHead">Update Branch</h2>
<p id=resp></p>
<form method=post class="form" id=updateBranch >
	<h3 class="formGroupHead">General Details:</h3>
<div class="form-group">
	<div>
	<label for="branchId">Branch Id</label>
	<input type="text" id=branchId name="branchId" maxlength="50" value=<%=request.getParameter("branchId")%> readonly="readonly">	
	</div>
	<div>
	<label for="branchName">Branch Name</label>
	<input type="text" id=branchName name="branchName" maxlength="50" value=<%=request.getParameter("branchName")%>>	
	</div>
	<div>
	<label for="managerId">Manager Id</label>
	<input type="text" id=managerId name="managerId" value=<%=request.getParameter("managerId")%>>
	</div>
</div>
	<h3 class="formGroupHead">Address:</h3>
<div class="form-group">
	<div>	
	<label for="addressLine1">Address Line 1</label>
    <input type="text" id="addressLine1" name="addressLine1" maxlength="50" required value=<%=request.getParameter("addressLine1")%>>
	</div>
   		<div >
            <label for="country" onclick="call()">Country</label>
            <select id="country" name="country" required>
                    <option selected="selected" value=<%=request.getParameter("country")%>><%=request.getParameter("country") %></option>
            </select>    
        </div>
            <div >
                <label for="state">State</label>
                <select id="state" name="state" required>
                    <option selected="selected" value=<%=request.getParameter("state")%>><%=request.getParameter("state") %></option>
                </select>
            </div>
            <div >
                <label for="city">City</label>
                <select id="city" name="city" required>
                    <option selected="selected" value=<%=request.getParameter("city")%>><%=request.getParameter("city") %></option>
                </select>
            </div>
            <div >
                <label for="postalCode">Postal Code</label>
                <input type="text" id="postalCode" name="postalCode" maxlength="20" required value=<%=request.getParameter("postalCode")%>>
            </div>
          	<div>
			    <label for="latitude">Latitude</label>
			    <input type="number" id="latitude" name="latitude" step="0.000001" value=<%=request.getParameter("latitude")%>>          	
          	</div>
          	<div>
			    <label for="longitude">Longitude</label>
			    <input type="number" id="longitude" name="longitude" step="0.000001" value=<%=request.getParameter("longitude")%>>			          
          	</div>
</div>
	<h3 class="formGroupHead">Contact Details:</h3>
<div class="form-group">
	<div>
	<label for="phoneNumber">Phone Number</label>
    <input type="text" id="phoneNumber" name="phoneNumber" maxlength="20" value=<%=request.getParameter("phoneNumber")%>>
    </div>
    <div>
	<label for="email">Email</label>
    <input type="email" id="email" name="email" maxlength="50" value=<%=request.getParameter("email")%>>
    </div>
</div>
	<h3 class="formGroupHead">Status:</h3>
<div class="form-group">
	 <div >
        <label for="status">Is Active</label>
        <select id="status" name="status">
        <option selected="selected" value=<%=request.getParameter("status")%>><%=request.getParameter("status")%></option>
        <option value="active">active</option>
        <option value="inactive">inactive</option>
        
        </select>
     </div>
     <div >
         <label for="dateEstablished">Date Established</label>
         <input type="date" id="dateEstablished" name="dateEstablished" value=<%=request.getParameter("dateEstablished")%> disabled="disabled">
     </div>	
</div>
</form>
<button class=button type="button" onclick="submit(event,'UpdateBranch','updateBranch','ViewBranch?var=update');">Update Branch</button>
<script type="text/javascript">
</script>
</body>
</html>

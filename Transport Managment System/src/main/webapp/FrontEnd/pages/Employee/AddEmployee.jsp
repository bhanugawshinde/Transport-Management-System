<html>
<head>
<title>Insert title here</title>
<style type="text/css">
#add-employee{
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
<h2 class="formHead">Add Employee</h2>
<p id=resp></p>
<form method=post class="form" id=addemployee >
	<h3 class="formGroupHead">General Details:</h3>
<div class="form-group">
	<div>
	<label for="firstName">First Name</label>
	<input type="text" id=firstName name="firstName" maxlength="50">	
	</div>
	<div>
	<label for="lastName">First Name</label>
	<input type="text" id=lastName name="lastName" maxlength="50">	
	</div>
	<div>
	<label for="dateOfBirth">Date Of Birth</label>
	<input type="date" id=dateOfBirth name="dateOfBirth" >
	</div>
</div>
	<h3 class="formGroupHead">Address:</h3>
<div class="form-group">
	<div>	
	<label for="address">Address </label>
    <input type="text" id="address" name="address" maxlength="50" required>
	</div>
   		<div >
            <label for="country">Country</label>
            <select id="country" name="country" required>
                    <option selected="selected" value="none">select</option>
            </select>    
        </div>
            <div >
                <label for="state">State</label>
                <select id="state" name="state" required>
                    <option selected="selected" value="none">select</option>
                </select>
            </div>
            <div >
                <label for="city">City</label>
                <select id="city" name="city" required>
                    <option selected="selected" value="none">select</option>
                </select>
            </div>
            <div >
                <label for="postalCode">Postal Code</label>
                <input type="text" id="postalCode" name="postalCode" maxlength="20" required>
            </div>
</div>
	<h3 class="formGroupHead">Contact Details:</h3>
<div class="form-group">
	<div>
	<label for="phoneNumber">Phone Number</label>
    <input type="text" id="phoneNumber" name="phoneNumber" maxlength="20">
    </div>
    <div>
	<label for="email">Email</label>
    <input type="email" id="email" name="email" maxlength="50">
    </div>
</div>
	<h3 class="formGroupHead">Company Details</h3>
<div class="form-group">
	 <div >
        <label for="branchId">Branch Id</label>
        <select id="branchId" name="branchId">
        	<option></option>
        </select>
     </div>
	 <div >
        <label for="managerId">Manager Id</label>
        <select id="managerId" name="managerId">
        	<option>MAN021</option>
        </select>
     </div>
	 <div >
        <label for="department">Department</label>
        <select id="department" name="department">
        	<option>select</option>
        </select>
     </div>
     <div>
	<label for="hireDate">HireDate</label>
	<input type="date" id=hireDate name="hireDate" >
	</div>
	 <div >
        <label for="salary">Salary</label>
        <input type="number" id="salary" name="salary">
     </div>    
</div>
</form>
<button class=button type="button" onclick="submit(event,'http://localhost:8080/TruckTransport/AddEmployee','addemployee','http://localhost:8080/TruckTransport/ViewEmployee');">
Add Employee
</button>
<script type="text/javascript">
</script>
</body>
</html>

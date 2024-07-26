<html>
<head>
<title>Insert title here</title>
<style type="text/css">
#add-branch {
	border-radius: 15px;
	background-color: #272727;
	color: #ffffffd1;
	text-shadow: 1px 1px #043895;
	box-shadow: 0px 0px 5px white;
}
</style>
<script type="text/javascript" src="FrontEnd/src/js/script.js"></script>
</head>
<body>
	<h2 class="formHead">Add Branch</h2>
	<p id=resp></p>
	<form method=post class="form" id=addBranch>
		<h3 class="formGroupHead">General Details:</h3>
		<div class="form-group">
			<div>
				<label for="branchName">Branch Name</label> <input type="text"
					id=branchName name="branchName" maxlength="50">
			</div>
			<div>
				<label for="managerId">Manager Id</label> <input type="text"
					id=managerId name="managerId">
			</div>
		</div>
		<h3 class="formGroupHead">Address:</h3>
		<div class="form-group">
			<div>
				<label for="addressLine1">Address Line 1</label> <input type="text"
					id="addressLine1" name="addressLine1" maxlength="50" required>
			</div>
			<div>
				<label for="country">Country</label> <select id="country"
					name="country" required>
					<option selected="selected" value="none">select</option>
				</select>
			</div>
			<div>
				<label for="state">State</label> <select id="state" name="state"
					required>
					<option selected="selected" value="none">select</option>
				</select>
			</div>
			<div>
				<label for="city">City</label> <select id="city" name="city"
					required>
					<option selected="selected" value="none">select</option>
				</select>
			</div>
			<div>
				<label for="postalCode">Postal Code</label> <input type="text"
					id="postalCode" name="postalCode" maxlength="20" required>
			</div>
			<div>
				<label for="latitude">Latitude</label> <input type="number"
					id="latitude" name="latitude" step="0.000001">
			</div>
			<div>
				<label for="longitude">Longitude</label> <input type="number"
					id="longitude" name="longitude" step="0.000001">
			</div>
		</div>
		<h3 class="formGroupHead">Contact Details:</h3>
		<div class="form-group">
			<div>
				<label for="phoneNumber">Phone Number</label> <input type="text"
					id="phoneNumber" name="phoneNumber" maxlength="20">
			</div>
			<div>
				<label for="email">Email</label> <input type="email" id="email"
					name="email" maxlength="50">
			</div>
		</div>
		<h3 class="formGroupHead">Status:</h3>
		<div class="form-group">
			<div>
				<label for="status">Is Active</label> <select id="status"
					name="status">
					<option value="active">active</option>
					<option value="inactive">inactive</option>
				</select>
			</div>
			<div>
				<label for="dateEstablished">Date Established</label> <input
					type="date" id="dateEstablished" name="dateEstablished">
			</div>
		</div>
	</form>
	<button class=button type="button"
		onclick="submit(event,'htt p://localhost:8080/TruckTransport/AddBranch','addBranch','http://localhost:8080/TruckTransport/ViewBranch');">
		Add Branch</button>
	<script type="text/javascript">
		
	</script>
</body>
</html>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

	<form action="Login" method="post" class="form">
		<select name=position>
			<option>Admin</option>
			<option>Manager</option>
			<option>Employee</option>
			<option>Driver</option>
		</select> 
		<input type="text" name="id" id="id" required="required"> 
		<input type="password" name="password" id="password">
		<button  type="submit">Login</button>
	</form>

</body>
</html>
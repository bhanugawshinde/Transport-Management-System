<!--  https://cb1a-27-6-129-125.ngrok-free.app-->
<html>
<head>
<title>Employee</title>
<STYLE type="text/css">
#emp {
	background-color: #b10eae;
	box-shadow: 0px 0px 2px black;
}
</STYLE>


<link rel="stylesheet" type="text/css"
	href="../../node_modules/bootstrap-icons/font/bootstrap-icons.css"></link>
<!--  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.5/font/bootstrap-icons.min.css">
 -->
<link rel="stylesheet" href="FrontEnd/src/css/style2.css"></link>
</head>
<body>
	<span id="menu-btn" onclick="toggleMenu()">&#9776;</span>
	<section id="sideMenu" class="side-menu">
		<button class="close-btn" onclick="toggleMenu()">&times;</button>
		<button id=add-manager class="menu-itam"
			onclick="get('FrontEnd/pages/Employee/AddManager.jsp','page-content');">Add
			Manager</button>
		<button id=view-manager class="menu-itam"
			onclick="get('http://localhost:8080/Transport-Managment-System/ViewManager','page-content')">View
			Manager</button>
		<button id=update-manager class="menu-itam"
			onclick="get('http://localhost:8080/Transport-Managment-System/ViewManager?var=update','page-content')">Update
			Manager</button>
		<button id=delete-manager class="menu-itam"
			onclick="get('http://localhost:8080/Transport-Managment-System/ViewManager?var=delete','page-content')">Delete
			Manager</button>

		<button id=add-employee class="menu-itam"
			onclick="get('FrontEnd/pages/Employee/AddEmployee.jsp','page-content');">Add
			employee</button>
		<button id=view-employee class="menu-itam"
			onclick="get('http://localhost:8080/Transport-Managment-System/ViewEmployee','page-content')">View
			employee</button>
		<button id=update-employee class="menu-itam"
			onclick="get('http://localhost:8080/Transport-Managment-System/ViewEmployee?var=update','page-content')">Update
			employee</button>
		<button id=delete-employee class="menu-itam"
			onclick="get('http://localhost:8080/Transport-Managment-System/ViewEmployee?var=delete','page-content')">Delete
			employee</button>
	</section>
	<div id="main-content">
		<div id=page-content>
			<div class="box">
				<div class="item">
					<div class="box"
						onclick="event.stopPropagation(); executeSequentially('Employee', 'main', 'http://localhost:8080/Transport-Managment-System/ViewEmployee', 'page-content')">
						<span class="bi bi-plus-square addButton"
							onclick="event.stopPropagation(); executeSequentially('Employee', 'main', 'FrontEnd/pages/Employee/AddEmployee.jsp', 'page-content')"></span>

						<span class="bi bi-gear-wide-connected updateButton"
							onclick="event.stopPropagation(); executeSequentially('Employee', 'main', 'http://localhost:8080/Transport-Managment-System/ViewEmployee?var=update', 'page-content')"></span>

						<span class="bi bi-trash3 deleteButton"
							onclick="event.stopPropagation(); executeSequentially('Employee', 'main', 'http://localhost:8080/Transport-Managment-System/ViewEmployee?var=delete', 'page-content')"></span>

					</div>
					<h2 class="mt-3">Total Employee</h2>
					<div class="value">${totalEmployee }</div>
				</div>

				<div class="item">
					<div class="box"
						onclick="event.stopPropagation(); executeSequentially('Employee', 'main', 'http://localhost:8080/Transport-Managment-System/ViewManager', 'page-content')">
						<span class="bi bi-plus-square addButton"
							onclick="event.stopPropagation(); executeSequentially('Employee', 'main', 'FrontEnd/pages/Employee/AddManager.jsp', 'page-content')"></span>

						<span class="bi bi-gear-wide-connected updateButton"
							onclick="event.stopPropagation(); executeSequentially('Employee', 'main', 'http://localhost:8080/Transport-Managment-System/ViewManager?var=update', 'page-content')"></span>

						<span class="bi bi-trash3 deleteButton"
							onclick="event.stopPropagation(); executeSequentially('Employee', 'main', 'http://localhost:8080/Transport-Managment-System/ViewManager?var=delete', 'page-content')"></span>

					</div>
					<h2 class="mt-3">Total Manager</h2>
					<div class="value">${totalManager }</div>
				</div>

				

			</div>

			<div class="box">
				<div class="item color-1">Manager Max Salary: ${managerMaxSalary }</div>
				<div class="item color-1" >Employee Max Salary: ${employeeMaxSalary }</div>
				<div class="item color-1" >Manager Avg Salary: ${managerAvarageSalary }</div>
				<div class="item color-1" >Employee Avg Salary: ${employeeAvarageSalary }</div>
				<div class="item color-1" >Department: ${totalDepartment }</div>
			</div>
		</div>


	</div>


	<script type="text/javascript">
		
	</script>

</body>
</html>

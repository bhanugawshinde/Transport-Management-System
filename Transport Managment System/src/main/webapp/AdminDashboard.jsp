<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Insert title here</title>
<style type="text/css">

</style>
<link rel="stylesheet" type="text/css"
	href="FrontEnd/node_modules/bootstrap-icons/font/bootstrap-icons.css"></link>
<link rel="stylesheet" type="text/css"
	href="FrontEnd/node_modules/bootstrap/dist/css/bootstrap.css"></link>
<link rel="stylesheet" href="FrontEnd/src/css/common.css"></link>
<link rel="stylesheet" href="FrontEnd/src/css/style.css"></link>
<link rel="stylesheet" href="FrontEnd/src/css/style2.css"></link>

<script type="text/javascript" src="FrontEnd/src/js/script.js"></script>
</head>
<body id="body">
	<div id=loader></div>
	<div id="popup" class="popup">
		<h2 id="popupHead">head</h2>
		<p id="popupMessage">message</p>
	</div>
	<div id=Info>
		<%
		out.print("Etiantail Information<br>");
		out.print(session.getAttribute("adminBean") + "<br>");
		out.print("Session: " + session.getId());
		%>

	</div>
	<nav>
		<ul>
			<li onclick="get('Login','body') ">Home</li>
			<li id=branch onclick="get('Branch','main') ">Branch</li>
			<li id=emp onclick="get('Employee','main')">Employee</li>
			<li id=truck onclick="get('Truck','main')">Truck</li>
			<li id=cus onclick="get('Customer','main')">Customer</li>
			<li id=fin onclick="get('Finance','main')">Finance</li>
			<li id=logout><a href="Logout">Logout</a></li>
		</ul>
	</nav>
	<main id=main>
		<div id="main-content">
			<div id=page-content>
				<div class="box">
					<div class="item" onclick="event.stopPropagation(); executeSequentially('Branch', 'main', 'http://localhost:8080/Transport-Managment-System/ViewBranch', 'page-content')">
						<div class="box">
						<span class="bi bi-plus-square addButton"
							onclick="event.stopPropagation(); executeSequentially('Branch', 'main', 'FrontEnd/pages/Branch/AddBranch.jsp', 'page-content')"></span>
						
						<span class="bi bi-gear-wide-connected updateButton"
							onclick="event.stopPropagation(); executeSequentially('Branch', 'main', 'http://localhost:8080/Transport-Managment-System/ViewBranch?var=update', 'page-content')"></span>
						
						<span class="bi bi-trash3 deleteButton"
							onclick="event.stopPropagation(); executeSequentially('Branch', 'main', 'http://localhost:8080/Transport-Managment-System/ViewBranch?var=delete', 'page-content')"></span>
						
						</div>
						<h2 class="mt-3">Total Branch</h2>
						<div class="value">${totalBranch }</div>
					</div>
					
					<div class="item" onclick="event.stopPropagation(); executeSequentially('Employee', 'main', 'http://localhost:8080/Transport-Managment-System/ViewEmployee', 'page-content')">
						<div class="box">
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
					
					<div class="item" onclick="event.stopPropagation(); executeSequentially('Truck', 'main', 'http://localhost:8080/Transport-Managment-System/ViewTruck', 'page-content')">
						<div class="box">
						<span class="bi bi-plus-square addButton"
							onclick="event.stopPropagation(); executeSequentially('Truck', 'main', 'FrontEnd/pages/Truck/Truck.jsp', 'page-content')"></span>
						
						<span class="bi bi-gear-wide-connected updateButton"
							onclick="event.stopPropagation(); executeSequentially('Truck', 'main', 'http://localhost:8080/Transport-Managment-System/ViewTruck?var=update', 'page-content')"></span>
						
						<span class="bi bi-trash3 deleteButton"
							onclick="event.stopPropagation(); executeSequentially('Truck', 'main', 'http://localhost:8080/Transport-Managment-System/ViewTruck?var=delete', 'page-content')"></span>
						
						</div>
						<h2 class="mt-3">Total Truck</h2>
						<div class="value">${totalTruck }</div>
					</div>
					
					<div class="item" onclick="event.stopPropagation(); executeSequentially('Branch', 'main', 'http://localhost:8080/Transport-Managment-System/ViewBranch', 'page-content')">
						<div class="box">
						<span class="bi bi-plus-square addButton"
							onclick="event.stopPropagation(); executeSequentially('Branch', 'main', 'FrontEnd/pages/Branch/AddBranch.jsp', 'page-content')"></span>
						
						<span class="bi bi-gear-wide-connected updateButton"
							onclick="event.stopPropagation(); executeSequentially('Branch', 'main', 'http://localhost:8080/Transport-Managment-System/ViewBranch?var=update', 'page-content')"></span>
						
						<span class="bi bi-trash3 deleteButton"
							onclick="event.stopPropagation(); executeSequentially('Branch', 'main', 'http://localhost:8080/Transport-Managment-System/ViewBranch?var=delete', 'page-content')"></span>
						
						</div>
						<h2 class="mt-3">Total Customer</h2>
						<div class="value">${totalCustomer } -</div>
					</div>
					
				</div>

				<div class="container"></div>
			</div>
		</div>

	</main>

</body>
</html>

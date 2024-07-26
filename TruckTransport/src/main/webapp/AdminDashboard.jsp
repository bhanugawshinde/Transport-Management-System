<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Insert title here</title>
<style type="text/css">
.addButton {
	font-size: 1.8rem;
	color: #007bff;
}

.addButton:hover {
	text-shadow: 0px 0px 3px #007bff;
}
</style>
<link rel="stylesheet" type="text/css"
	href="FrontEnd/node_modules/bootstrap-icons/font/bootstrap-icons.css"></link>
<link rel="stylesheet" type="text/css" href="FrontEnd/src/css/style.css"></link>
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
				<div class="container">
					<div class="item"
						onclick="get('Branch','main'); get('http://localhost:8080/TruckTransport/ViewBranch','page-content')">
						<span class="bi bi-plus-lg addButton"
							onclick=" get('Branch','main');  get('FrontEnd/pages/Branch/AddBranch.jsp','page-content'); event.stopPropagation(); "></span>
						<h2>Total Branch</h2>
						<div class="value">${totalBranch }</div>
					</div>
					<div class="item"
						onclick="event.stopPropagation(); get('Employee','main');  get( 'http://localhost:8080/TruckTransport/ViewEmployee','page-content') ">
						<h2>Total Employee</h2>
						<div class="value">${totalEmployee }</div>
					</div>
					<div class="item"
						onclick="get('Truck','main'); get('http://localhost:8080/TruckTransport/ViewTruck','page-content')">
						<h2>Total Truck</h2>
						<div class="value">${totalTruck }</div>
					</div>
					<div class="item">
						<h2>Total Customer</h2>
						<div class="value">${totalCustomer }</div>
					</div>
				</div>

				<div class="container"></div>
			</div>
		</div>

	</main>

</body>
</html>

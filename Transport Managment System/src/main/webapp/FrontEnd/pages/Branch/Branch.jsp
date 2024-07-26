<!--  https://cb1a-27-6-129-125.ngrok-free.app-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<head>
<title>Branch</title>
<STYLE type="text/css">
#branch {
	background-color: #b10eae;
	box-shadow: 0px 0px 2px black;
}

#home {
	border-radius: 15px;
	background-color: #272727;
	color: #ffffffd1;
	text-shadow: 1px 1px #043895;
	box-shadow: 0px 0px 5px white;
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
		<button id=home class="menu-itam" onclick="get('Branch','main')">Home</button>
		<button id=view-branch class="menu-itam"
			onclick="get('http://localhost:8080/TruckTransport/ViewBranch','page-content')">View
			Branch</button>
		<button id=add-branch class="menu-itam"
			onclick="get('FrontEnd/pages/Branch/AddBranch.jsp','page-content');">Add
			Branch</button>
		<button id=update-branch class="menu-itam"
			onclick="get('http://localhost:8080/TruckTransport/ViewBranch?var=update','page-content')">Update
			Branch</button>
		<button id=delete-branch class="menu-itam"
			onclick="get('http://localhost:8080/TruckTransport/ViewBranch?var=delete','page-content')">Delete
			Branch</button>
	</section>
	<div id="main-content">
		<div id=page-content>
			<div class="container">
				<div class="item">
					<h2>Total Branch</h2>
					<div class="value">${total }</div>
				</div>
				<div class="item">
					<h2>Total State</h2>
					<div class="value">${state }</div>
				</div>
				<div class="item">
					<h2>Total Manager</h2>
					<div class="value">${manager }</div>
				</div>
				<div class="item">
					<h2>Total Active</h2>
					<div class="value">${active }</div>
				</div>
			</div>
			
			<div class="container">
				
			</div>
		</div>
	
	</div>
	
	
	<script type="text/javascript">
		
	</script>

</body>
</html>

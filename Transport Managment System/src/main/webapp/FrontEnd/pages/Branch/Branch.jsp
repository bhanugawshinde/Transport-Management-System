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

<link rel="stylesheet" href="FrontEnd/src/css/style2.css"></link>
</head>
<body>
	<span id="menu-btn" onclick="toggleMenu()">&#9776;</span>
	<section id="sideMenu" class="side-menu">
		<button class="close-btn" onclick="toggleMenu()">&times;</button>
		<button id=home class="menu-itam" onclick="get('Branch','main')">Home</button>
		<button id=view-branch class="menu-itam"
			onclick="get('ViewBranch','page-content')">View
			Branch</button>
		<button id=add-branch class="menu-itam"
			onclick="get('FrontEnd/pages/Branch/AddBranch.jsp','page-content');">Add
			Branch</button>
		<button id=update-branch class="menu-itam"
			onclick="get('ViewBranch?var=update','page-content')">Update
			Branch</button>
		<button id=delete-branch class="menu-itam"
			onclick="get('ViewBranch?var=delete','page-content')">Delete
			Branch</button>
	</section>
	<div id="main-content">
		<div id=page-content>
			<div class="box">
				<div class="item" onclick="event.stopPropagation(); executeSequentially('Branch', 'main', 'ViewBranch', 'page-content')">
					<div class="box" >
						<span class="bi bi-plus-square addButton"
							onclick="event.stopPropagation(); executeSequentially('Branch', 'main', 'FrontEnd/pages/Branch/AddBranch.jsp', 'page-content')"></span>
						
						<span class="bi bi-gear-wide-connected updateButton"
							onclick="event.stopPropagation(); executeSequentially('Branch', 'main', 'ViewBranch?var=update', 'page-content')"></span>
						
						<span class="bi bi-trash3 deleteButton"
							onclick="event.stopPropagation(); executeSequentially('Branch', 'main', 'ViewBranch?var=delete', 'page-content')"></span>
						
						</div>
					<h2 class="mt-3">Total Branch</h2>
					<div class="value">${total }</div>
				</div>
				<div class="item">
					<h2 class="mt-3">Total State</h2>
					<div class="value">${state }</div>
				</div>
				<div class="item" >
					<div class="box" onclick="event.stopPropagation(); executeSequentially('Employee', 'main', 'ViewManager', 'page-content')">
						<span class="bi bi-plus-square addButton"
							onclick="event.stopPropagation(); executeSequentially('Employee', 'main', 'FrontEnd/pages/Employee/AddManager.jsp', 'page-content')"></span>
						
						<span class="bi bi-gear-wide-connected updateButton"
							onclick="event.stopPropagation(); executeSequentially('Employee', 'main', 'ViewManager?var=update', 'page-content')"></span>
						
						<span class="bi bi-trash3 deleteButton"
							onclick="event.stopPropagation(); executeSequentially('Employee', 'main', 'ViewManager?var=delete', 'page-content')"></span>
						
						</div>
					<h2 class="mt-3">Total Manager</h2>
					<div class="value">${manager }</div>
				</div>
				
				<div class="item">
					<h2 class="mt-3">Total Active</h2>
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

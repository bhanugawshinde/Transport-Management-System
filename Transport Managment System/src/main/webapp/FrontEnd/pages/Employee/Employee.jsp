<!--  https://cb1a-27-6-129-125.ngrok-free.app-->
<html>
<head>
<title>Employee</title>
<STYLE type="text/css">
#emp{
background-color: #b10eae;
box-shadow: 0px 0px 2px black;
}

</STYLE>


 <link rel="stylesheet" type="text/css" href="../../node_modules/bootstrap-icons/font/bootstrap-icons.css"></link>
<!--  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.5/font/bootstrap-icons.min.css">
 --> 
 <link rel="stylesheet" href="FrontEnd/src/css/style2.css"></link>
 </head>
<body>
<span id="menu-btn" onclick="toggleMenu()">&#9776;</span>
<section id="sideMenu" class="side-menu">
	<button class="close-btn" onclick="toggleMenu()">&times;</button>
	<button id=add-manager class="menu-itam" onclick="get('FrontEnd/pages/Employee/AddManager.jsp','page-content');" >Add Manager</button>
	<button id=view-manager class="menu-itam" onclick="get('http://localhost:8080/Transport-Managment-System/ViewManager','page-content')">View Manager</button>
	<button id=update-manager class="menu-itam" onclick="get('http://localhost:8080/Transport-Managment-System/ViewManager?var=update','page-content')">Update Manager</button>
	<button id=delete-manager class="menu-itam" onclick="get('http://localhost:8080/Transport-Managment-System/ViewManager?var=delete','page-content')">Delete Manager</button>
	
	<button id=add-employee class="menu-itam" onclick="get('FrontEnd/pages/Employee/AddEmployee.jsp','page-content');" >Add employee</button>
	<button id=view-employee class="menu-itam" onclick="get('http://localhost:8080/Transport-Managment-System/ViewEmployee','page-content')">View employee</button>
	<button id=update-employee class="menu-itam" onclick="get('http://localhost:8080/Transport-Managment-System/ViewEmployee?var=update','page-content')">Update employee</button>
	<button id=delete-employee class="menu-itam" onclick="get('http://localhost:8080/Transport-Managment-System/ViewEmployee?var=delete','page-content')">Delete employee</button>
</section>
<div id="main-content">
	<h1 class=head1>Employee Page</h1>
	<div id=page-content>
	
	</div>
</div>

<script type="text/javascript">
 
 </script>

</body>
</html>

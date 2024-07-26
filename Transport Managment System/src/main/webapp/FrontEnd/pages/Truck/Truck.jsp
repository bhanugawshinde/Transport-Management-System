<!--  https://cb1a-27-6-129-125.ngrok-free.app-->
<html>
<head>
<title>Truck</title>
<STYLE type="text/css">
#truck{
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
	<button id=view-truck class="menu-itam" onclick="get('http://localhost:8080/Transport-Managment-System/ViewTruck','page-content')">View Truck</button>
	<button id=add-truck class="menu-itam" onclick="get('FrontEnd/pages/Truck/AddTruck.jsp','page-content');" >Add Truck</button>
	<button id=update-truck class="menu-itam" onclick="get('http://localhost:8080/Transport-Managment-System/ViewTruck?var=update','page-content')">Update Truck</button>
	<button id=delete-truck class="menu-itam" onclick="get('http://localhost:8080/Transport-Managment-System/ViewTruck?var=delete','page-content')">Delete Truck</button>
</section>
<div id="main-content">
	<h1 class=head1>Truck Page</h1>
	<div id=page-content>
	
	</div>
</div>

<script type="text/javascript">
 
 </script>

</body>
</html>

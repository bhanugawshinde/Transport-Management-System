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
	<div id=page-content>
		<div class="box">
				<div class="item" onclick="event.stopPropagation(); executeSequentially('Truck', 'main', 'http://localhost:8080/Transport-Managment-System/ViewTruck', 'page-content')">
					<div class="box" >
						<span class="bi bi-plus-square addButton"
							onclick="event.stopPropagation(); executeSequentially('Truck', 'main', 'FrontEnd/pages/Truck/AddTruck.jsp', 'page-content')"></span>
						
						<span class="bi bi-gear-wide-connected updateButton"
							onclick="event.stopPropagation(); executeSequentially('Truck', 'main', 'http://localhost:8080/Transport-Managment-System/ViewTruck?var=update', 'page-content')"></span>
						
						<span class="bi bi-trash3 deleteButton"
							onclick="event.stopPropagation(); executeSequentially('Truck', 'main', 'http://localhost:8080/Transport-Managment-System/ViewTruck?var=delete', 'page-content')"></span>
						
						</div>
					<h2 class="mt-3">Total Truck</h2>
					<div class="value">${totalTruck }</div>
				</div>				
		</div>
			<div class="box">
				<div class="item color-1">Max Price: ${maxPrice }</div>
				<div class="item color-1" >Min Price: ${minPrice }</div>
				<div class="item color-1" >Total Price: ${totalPrice }</div>
				<div class="item color-1" >Avg Mileage: ${avgMileage }</div>
				<div class="item color-1" >Total Companies: ${totalCompanies }</div>
			</div>
	
	
	</div>
</div>

<script type="text/javascript">
 
 </script>

</body>
</html>

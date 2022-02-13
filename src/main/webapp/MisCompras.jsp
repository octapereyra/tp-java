<%@page import="entities.Producto" %>
<%@page import="entities.Venta" %>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Mis compras</title>
	<link rel="stylesheet" href="Carrito_style.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF" crossorigin="anonymous">
	<!-- JavaScript Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<%LinkedList<Producto> list = (LinkedList<Producto>)request.getAttribute("listaProductos"); %>
	<%if (list == null){ list = new LinkedList<Producto>();};%>
	
	<%Venta v = (Venta)request.getAttribute("venta");%>
	<%if (v == null){ v = new Venta();};%>
</head>
<body>
	<!--CABECERA-->
		<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">
					<img src="img/java-logo.png" width="150px">
				</a>
				<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      			<span class="navbar-toggler-icon"></span>
	    		</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
	    			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
	    				<li class="nav-item">
	    					<a class="nav-link" aria-current="page" href="MainPage?accion=home"> Home</a>
	    				</li>
	    				<li class="nav-item">
	    					<a class="nav-link" aria-current="page" href="listProducts.jsp">Productos</a>
	    				</li>
	    				<li class="nav-item dropdown"> 
	    					<a class="nav-link active dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false" href="#">Mi cuenta</a>
	    					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
	    						<li><a class="dropdown-item" href="miPerfil.jsp">Perfil</a></li>
	    						<li><a class="dropdown-item" href="MainPage?accion=logout">Cerrar Sesión</a></li>
	    					</ul>
	    				</li>
	    			</ul>
	    			<ul class="navbar-nav me-4 mb-2 mb-lg-end">
	    				<li class="nav-item">
	    					<a class="nav-link" aria-current="page" href="Carro_de_compras.jsp">Mi carrito</a>
	    				</li>
	    			</ul>
	    			<form class="d-flex">
	        			<input class="form-control me-2" type="search" placeholder="¿Qué estas buscando?" aria-label="Search"
	        			size="40">
	        			<button class="btn btn-outline-success" type="submit">Buscar</button>
	      			</form>
	    		</div>
			</div>
		</nav>
	<!--CABECERA-->
	
	<%for(Producto prod : list){ %>
	<div class="card w-50">
  		<div class="card-body">
		    <h5 class="card-title"><%=prod.getDescripcion() %></h5>
		    <p class="card-text">Estado:<%= v.getEstado()%></p>
		    <p class="card-text">LLega el:<%= v.getFechaVenta()%></p>
	  	</div>
	</div>
	<%}%>

</body>
</html>
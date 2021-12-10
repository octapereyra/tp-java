<%@page import="entities.Producto"%>
<%@page import="entities.Categoria" %>
<%@page import="java.util.LinkedList"%>
<%@page import="logic.LogicProducto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Productos</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF" crossorigin="anonymous">
	
	
</head>
<body>
	<%LogicProducto lp = new LogicProducto();%>
	<%LinkedList<Producto> list = (LinkedList<Producto>)request.getAttribute("lista");%>
	<%if(list == null) {list = lp.getAll();}%>
	<div class="container mt-3">
		<h3>Búsqueda por precio</h3>
		<form method="get" action="listProducts">
			<div class="input-group mb-3">
	  			<button class="btn btn-outline-secondary" name="button" value="mayor" type="submit">Mayor que</button>
	  			<button class="btn btn-outline-secondary" name="button" value="menor" type="submit">Menor que</button>
	  			<input type="text" name="precio" class="form-control me-1" placeholder="Ingrese precio..." aria-label="Example text with two button addons">
				<div class="list-group list-group-horizontal">
  					<a href="ABMCproducto?accion=nuevo" class="list-group-item list-group-item-action" aria-current="true">Nuevo</a>
  				</div>			
			</div>	
		</form>
	</div>
	<div class="container">
			<table class="table table-striped">
		  <thead>
		    <tr>
<!-- 		      <th scope="col">ID</th> -->
		      <th scope="col">Categoria</th>
		      <th scope="col">Descripción</th>
		      <th scope="col">Precio</th>
<!-- 		      <th scope="col">Stock</th> -->
		    </tr>
		  </thead>
		  <tbody>
		  <% for (Producto pr : list) { %>
		  <% Categoria cat = new Categoria(); %>
		  <% cat = pr.getCategoria(); %>
		    <tr>
<%-- 		      <td><%=pr.getId() %></td> --%>
		      <td><%=cat.getDenominacion() %></td>
		      <td><%=pr.getDescripcion() %></td>
		      <td><%=pr.getPrecio() %></td>
<%-- 		      <td><%=pr.getStock() %></td> --%>
		    </tr>
		    <% } %>
		  </tbody>
		</table>	
	</div>
	
	<!-- JavaScript Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	
</body>
</html>
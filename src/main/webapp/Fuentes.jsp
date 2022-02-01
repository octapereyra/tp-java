<%@page import="entities.Producto"%>
<%@page import="data.DataProducto"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<meta charset="ISO-8859-1">
	<title>Productos</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF" crossorigin="anonymous">
</head>
<body>
	<%	
	DataProducto dp = new DataProducto();
	LinkedList<Producto> list = dp.getByCategoria("Fuente de alimentación");
	
	%>
	<div class="container">
		<table class="table table-striped">
		  <thead>
		    <tr>
		      <th scope="col">Descripción</th>
		      <th scope="col">Precio</th>
		    </tr>
		  </thead>
		  <tbody>
		  <% for (Producto pr : list) { %>
		    <tr>
		      <td><%=pr.getDescripcion() %></td>
		      <td><%=pr.getPrecio() %></td>
		    </tr>
		    <% } %>
		  </tbody>
		</table>	
	</div>
	
	<!-- JavaScript Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	
</body>
</html>
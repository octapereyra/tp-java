<%@page import="entities.Producto"%>
<%@page import="entities.Categoria" %>
<%@page import="java.util.LinkedList"%>
<%@page import="logic.LogicCategoria"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Productos</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<form action="ABMCproducto?accion=insert" method="POST" autocomplete="off">
			<div class="mb-3">
		    	<label class="form-label">Descripcion</label>
		    	<input id="descripcion" name="descripcion" type="text" class="form-control">
		  	</div>
		  	<div class="mb-3">
		    	<label class="form-label">Precio</label>
		    	<input id="precio" name="precio" type="text" class="form-control">
		  	</div>
		  	<div class="mb-3">
		    	<label class="form-label">Stock</label>
		    	<input id="stock" name="stock" type="text" class="form-control">
		  	</div>
		  	<%LogicCategoria lc = new LogicCategoria();%>
			<%LinkedList<Categoria> list =  (LinkedList<Categoria>)request.getAttribute("listaCat");%>
			<%if(list == null) {list = lc.getAll();}%>
		  	
		  	<div class="btn-group-vertical" role="group" aria-label="Basic checkbox toggle button group">
		  	<label class="label px-1">Seleccione una categoria</label>
		  	
		   <% Integer i=0;
		   	String id = null;
		   for (Categoria cat : list) { 
		   		i++;
		   		id = "btncheck"+i;
		   %>
		  	<input name="tipoProducto" type="radio" class="btn-check" id=<%=id%> autocomplete="off" value="<%=cat.getDenominacion()%>">
			<label class="btn btn-outline-primary" for=<%=id%>><%=cat.getDenominacion()%></label>
				
			<% }%>>

			</div>
	  		<button type="submit" class="btn btn-primary">Guardar</button>
		</form>
	</div>
</body>
</html>
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
		  	
		  	<div class="btn-group-vertical" role="group" aria-label="Basic checkbox toggle button group">
		  		<label class="label px-1">Seleccione una categoria</label>
		  		
			 	<input name="tipoProducto" type="radio" class="btn-check" id="btncheck1" autocomplete="off" value="Microprocesador">
				<label class="btn btn-outline-primary" for="btncheck1">Microprocesador</label>
				
				<input name="tipoProducto" type="radio" class="btn-check" id="btncheck2" autocomplete="off" value="Motherboard">
				<label class="btn btn-outline-primary" for="btncheck2">Motherboard</label>
				
				<input name="tipoProducto" type="radio" class="btn-check" id="btncheck3" autocomplete="off" value="MemoriaRam">
				<label class="btn btn-outline-primary" for="btncheck3">Memoria Ram</label>
				
				<input name="tipoProducto" type="radio" class="btn-check" id="btncheck4" autocomplete="off" value="DiscoRigido">
				<label class="btn btn-outline-primary" for="btncheck4">Disco rígido</label>
				
				<input name="tipoProducto" type="radio" class="btn-check" id="btncheck5" autocomplete="off" value="PlacaVideo">
				<label class="btn btn-outline-primary" for="btncheck5">Placa de video</label>
				
				<input name="tipoProducto" type="radio" class="btn-check" id="btncheck6" autocomplete="off" value="Gabinete">
				<label class="btn btn-outline-primary" for="btncheck6">Gabinete</label>
				
				<input name="tipoProducto" type="radio" class="btn-check" id="btncheck7" autocomplete="off" value="Fuente">
				<label class="btn btn-outline-primary" for="btncheck7">Fuente</label>
				
				<input name="tipoProducto" type="radio" class="btn-check" id="btncheck8" autocomplete="off" value="Cooler">
				<label class="btn btn-outline-primary" for="btncheck8">Cooler</label>
			</div>
	  		<button type="submit" class="btn btn-primary">Guardar</button>
		</form>
	</div>
</body>
</html>
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
		  	
		  	<div class="input-group mb-3">
		  		<label class="form-label px-1">Seleccione una categoria</label>
  				<div class="input-group-text">
    				<input name="tipoProducto" class="form-check-input mx-1" type="radio" value="Microprocesador">
  					<input type="text" class="form-control" placeholder="Microprocesador">
  				</div>
  				<div class="input-group-text">
    				<input name="tipoProducto" class="form-check-input mx-1" type="radio" value="Motherboard">
  					<input type="text" class="form-control" placeholder="Motherboard">
  				</div>
  				<div class="input-group-text">
    				<input name="tipoProducto" class="form-check-input mx-1" type="radio" value="MemoriaRam">
  					<input type="text" class="form-control" placeholder="Memoria Ram">
  				</div>
  				<div class="input-group-text">
    				<input name="tipoProducto" class="form-check-input mx-1" type="radio" value="DiscoRigido">
  					<input type="text" class="form-control" placeholder="Disco rígido">
  				</div>
  				<div class="input-group-text">
    				<input name="tipoProducto" class="form-check-input mx-1" type="radio" value="PlacaVideo">
  					<input type="text" class="form-control" placeholder="Placa de video">
  				</div>
  				<div class="input-group-text">
    				<input name="tipoProducto" class="form-check-input mx-1" type="radio" value="Gabinete">
  					<input type="text" class="form-control" placeholder="Gabinete">
  				</div>
  				<div class="input-group-text">
    				<input name="tipoProducto" class="form-check-input mx-1" type="radio" value="Fuente">
  					<input type="text" class="form-control" placeholder="Fuente">
  				</div>
  				<div class="input-group-text">
    				<input name="tipoProducto" class="form-check-input mx-1" type="radio" value="Cooler">
  					<input type="text" class="form-control" placeholder="Cooler">
  				</div>
			</div>
	  		<button type="submit" class="btn btn-primary">Guardar</button>
		</form>
	</div>
</body>
</html>
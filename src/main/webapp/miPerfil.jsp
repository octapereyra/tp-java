<%@page import="entities.Usuario"%>
<%@page import="logic.LogicUsuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Mi Perfil</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF" crossorigin="anonymous">

</head>
<body>
<div class="col-lg-8 mx-auto p-3 py-md-5">
  <header class="d-flex align-items-center pb-3 mb-5 border-bottom">
    <a href="/" class="d-flex align-items-center text-dark text-decoration-none">
      <svg xmlns="http://www.w3.org/2000/svg" width="40" height="32" class="me-2" viewBox="0 0 118 94" role="img"><title>Bootstrap</title><path fill-rule="evenodd" clip-rule="evenodd" d="M24.509 0c-6.733 0-11.715 5.893-11.492 12.284.214 6.14-.064 14.092-2.066 20.577C8.943 39.365 5.547 43.485 0 44.014v5.972c5.547.529 8.943 4.649 10.951 11.153 2.002 6.485 2.28 14.437 2.066 20.577C12.794 88.106 17.776 94 24.51 94H93.5c6.733 0 11.714-5.893 11.491-12.284-.214-6.14.064-14.092 2.066-20.577 2.009-6.504 5.396-10.624 10.943-11.153v-5.972c-5.547-.529-8.934-4.649-10.943-11.153-2.002-6.484-2.28-14.437-2.066-20.577C105.214 5.894 100.233 0 93.5 0H24.508zM80 57.863C80 66.663 73.436 72 62.543 72H44a2 2 0 01-2-2V24a2 2 0 012-2h18.437c9.083 0 15.044 4.92 15.044 12.474 0 5.302-4.01 10.049-9.119 10.88v.277C75.317 46.394 80 51.21 80 57.863zM60.521 28.34H49.948v14.934h8.905c6.884 0 10.68-2.772 10.68-7.727 0-4.643-3.264-7.207-9.012-7.207zM49.948 49.2v16.458H60.91c7.167 0 10.964-2.876 10.964-8.281 0-5.406-3.903-8.178-11.425-8.178H49.948z" fill="currentColor"></path></svg>
      <span class="fs-4">Mi Perfil</span>
    </a>
  </header>

  <main>
  	<%LogicUsuario lu = new LogicUsuario();%>
  	<%Usuario us = (Usuario)session.getAttribute("user");%>

    <form method="post" action="UserMB?accion=update" class="bg-light mt-1">
    <div class="col-md-4">
	    <div class="col-sm-10">
      		<input type="hidden" name="id_user" class="form-control" value=<%=us.getId_usuario() %>>
    	</div>
	  </div>
	  <div class="col-md-4">
	    <div class="col-sm-10">
      		<input type="hidden" name="usertype" class="form-control" value=<%=us.getTipoUsuario().getId_TipoUsuario() %>>
    	</div>
	  </div>
	  <div class="col-md-4">
	    <label for="inputName" class="col-sm-2 col-form-label">Nombre</label>
	    <div class="col-sm-10">
      		<input type="text" name="nombre" class="form-control" value=<%=us.getNombre() %>>
    	</div>
	  </div>
	  <div class="col-md-4">
	    <label for="inputApellido" class="col-sm-2 col-form-label">Apellido</label>
	    <div class="col-sm-10">
	    	<input type="text" name="apellido" class="form-control" value=<%=us.getApellido() %> >
    	</div>
	  </div>
	  <div class="col-md-4">
	    <label for="inputUser" class="form-label">Username</label>
	    <div class="col-sm-10">
	    	<input type="text" name="username" class="form-control" value=<%=us.getNombreUsuario() %>>
    	</div>
	  </div>
	  <div class="col-md-6">
	    <label for="inputMail" class="form-label">Email</label>
	    <div class="col-sm-10">
	    	<input type="email" name="mail" class="form-control" value=<%=us.getEmail() %>>
    	</div>
	  </div>
	  <div class="col-md-3">
	    <label for="inputPassword" class="form-label">Contrase�a</label>
	    <div class="col-sm-10">
	     	<input type="password" name="clave" class="form-control" value=<%=us.getClave() %>>
     	</div>
	  </div>
	  <div class="col-12-mt-5">
	    <button class="btn btn-primary" type="submit">Modificar datos</button>
	  </div>
	  <div class="col-12-mt-10">
	    <button type="submit" class="btn btn-danger" formaction="UserMB?accion=delete">Eliminar usuario</button>
	  </div>
	</form>

  </main>
  <footer class="pt-5 my-5 text-muted border-top">
    &copy; 2021
  </footer>
  </div>


</body>
</html>
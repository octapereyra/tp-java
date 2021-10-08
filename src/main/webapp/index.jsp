<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>
	<link rel="stylesheet" href="css/Login_style.css"> 
</head>
<body>
	<div class="container">
		<form method="post" action="login" class="formlogin">
			<div class="imagen">
				<img alt="" src="img/icon_login.png" width="90" height="90">
				<p id="welcome"><strong>Welcome</strong></p>
			</div>
			<div class="username">
				<label> Usuario:</label>
				<input type="text" name="user">
			</div>
			<div class="pass">
				<label> Contraseña:</label>
				<input type="password" name="pass">
			</div>
			<div class="btnlogin">
				<input type="submit" value="Iniciar Sesión"> 
			</div>
		</form>	
	</div>
	
</body>
</html>
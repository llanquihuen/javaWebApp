<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="d-flex flex-column mx-auto py-5" style="background:#eff;min-height:86vh">
			<h1 style="text-align:center">Login</h1>
	
		<h1 style="text-align:center">Productos de Limpieza</h1>
		<div class="d-flex justify-content-center align-items-center">
			<img style="width:70%" src="img/login.png"alt="User Icon" />
		</div>
		<h4 style="text-align:center;color:#444;margin:20px 0 20px 0">Login: Luis - Pasword: pass</h4>
		<div class="d-flex justify-content-center align-items-center">
			<form class="d-flex flex-column gap-2" action="procesaLogin" method="POST">
			<label for="login">Login:</label>
				<input type="text" id="login" name="login" placeholder="login">
			<label class="mt-3"for="login">Password:</label>
				
				<input type="text" id="password" name="pass" placeholder="password">
				<input type="submit" value="Log In">
			</form>
		</div>
	</div>
	<footer style="color:white"class="py-5 container-fluid bg-success d-flex justify-content-center align-items-center">
		
	<h3> Pantalla de login</h3>
	</footer>
</body>
</html>
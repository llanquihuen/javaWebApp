<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<meta charset="UTF-8">
<meta http-equiv=”Content-Language” content=”es”/>
<title>Borrar Productos</title>
</head>
<style type="text/css">
.jumbotron {
	padding: 4rem 2rem;
	margin-bottom: 2rem;
	background-color: #eee;
	border-radius: .3rem;
}
</style>
<body>
<%HttpSession sesion = request.getSession();
String nombre;
nombre = (String)sesion.getAttribute("Nombre");
%>
	<% if(nombre != null){ %>
<jsp:include page="header.jsp"></jsp:include>

<h1 class="text-center mt-5">Borrar Producto de lista</h1>
	
	<div class="container my-5 m-auto">
		<form action="borraProducto" method="POST">
			<div class="mb-3">
				<label for="id producto" class="form-label">Ingrese Id del producto a borrar</label>
				<input type="number" class="form-control" id="idProducto" name="idProducto">
			</div>
			<button type="submit" class="btn btn-danger">Eliminar</button>
		</form>
	</div>
	
		<jsp:include page="listaModular.jsp"></jsp:include>

<footer class="bg-dark text-center text-lg-start d-flex" style="height:150px;color:white">
  <div class="text-center p-3 align-self-center m-auto ">
  	<h4>Modulo 4 Julio 2021 - Luis Ramirez</h4>		
  </div>
</footer>
		<%
		}else{
		%>
		<jsp:include page="error.jsp"></jsp:include>
		<%}%>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
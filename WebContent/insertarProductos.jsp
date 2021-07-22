<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.desafiolatam.modelo.Producto"%>
<%@ page import="com.desafiolatam.modelo.Categoria"%>

<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Productos</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<style type="text/css">
.jumbotron {
	padding: 4rem 2rem;
	margin-bottom: 2rem;
	background-color: #eee;
	border-radius: .3rem;
	
}
.form-group{
	padding-top:1.5rem;
}
</style>
<%
	List<Producto> productos;
List<Categoria> categorias;// capturamos informacion que viene desde el request
productos = (List) request.getAttribute("productosR");
categorias = (List) request.getAttribute("categoriasR");
//cookie
%>
<body>
	<%HttpSession sesion = request.getSession();
String nombre;
nombre = (String)sesion.getAttribute("Nombre");
%>
	<% if(nombre != null){ %>
	<jsp:include page="header.jsp"></jsp:include>
	
<h1 class="text-center mt-5">Agregar producto nuevo</h1>

	<div class="container pt-5 py-5">
		<form action="insertProducto">
			<div class="form-group">
				<label for="nombre">Nombre:</label> <input type="text"
					class="form-control" id="nombre" name="nombreProducto">
			</div>
			<div class="form-group">
				<label for="precio">Precio:</label> <input type="number"
					class="form-control" id="precio" name="precioProducto">
			</div>
			<div class="form-group">
				<label for="descripcion">Descripcion:</label> <input type="text"
					class="form-control" id="descrip" name="descripcionProducto">
			</div>
			<div class="form-group">
				<label for="categoria">Categorias:</label> <select name="idCategoria">
					<%
						for (Categoria c : categorias) {
					%>
					<option value="<%=c.getIdCategoria()%>">
						<%=c.getNombreCategoria()%>
					</option>
					<%
					}
					%>
				</select><br>
			</div>
			<button type="submit" class="btn btn-success my-4">Agregar</button>
		</form>
	</div>
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
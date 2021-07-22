<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.desafiolatam.modelo.Producto"%>
<%@ page import="com.desafiolatam.modelo.Categoria"%>

<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Productos</title>
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
Producto editar;
List<Producto> elProducto;
List<Categoria> laCategoria;// capturamos informacion que viene desde el request
elProducto = (List) request.getAttribute("ListaDeproductos");
laCategoria = (List) request.getAttribute("ListaDeCategorias");
editar = (Producto) request.getAttribute("paraEditar");

%>

<body>
	<%HttpSession sesion = request.getSession();
String nombre;
nombre = (String)sesion.getAttribute("Nombre");
%>
	<% if(nombre != null){ %>
<jsp:include page="header.jsp"></jsp:include>
<h1 class="text-center mt-5">Editar Productos</h1>
	<% if(editar == null){ %>

	<div class="container my-5 m-auto">
		<form action="editarProducto" method="POST">
			<div class="mb-3">
				<label for="id producto" class="form-label" >Ingrese Id del producto a editar</label>
				<input type="number" class="form-control" id="idProducto" name="idProducto" required>
			</div>
			<button type="submit" class="btn btn-warning">Editar</button>
			
		</form>
	</div>
	<%
	}
	%>
	
	<% if(editar != null){ %>
	<div class="container pt-5">
		<form action="editarProducto" method="GET">
			<div class="form-group d-none">
				<label for="id">Id de tabla a Editar:</label>
				 <input type="text"	class="form-control" value="<%=editar.getIdProducto()%>" id="id" name="idProducto" >
			</div>
			<div class="form-group">
				<label for="nombre">Nombre:</label> <input type="text"
					class="form-control" value="<%= editar.getNombreProducto()%>" id="nombre" name="nombreProducto">
			</div>
			<div class="form-group">
				<label for="precio">Precio:</label> <input type="number"
					class="form-control" value="<%= editar.getPrecioProducto()%>" id="precio" name="precioProducto">
			</div>
			<div class="form-group">
				<label for="descripcion">Descripcion:</label> <input type="text"
					class="form-control" value="<%= editar.getDescripcionProducto()%>" id="descrip" name="descripcionProducto">
			</div>
			<div class="form-group">
				<label for="cursos">Categorias:</label> <select name="idCategoria">
					<%
						for (Categoria c : laCategoria) {
					%>
					<option value="<%=c.getIdCategoria()%>" <%=(c.getIdCategoria()==editar.getIdCategoria())? "selected" : "" %>>
						<%=c.getNombreCategoria()%> 
						
					</option>
					<%
					}
					%>
				</select><br>
			</div>
			<div class="my-4">
				<button type="submit" class="btn btn-warning me-4">Editar</button>
				<button onclick="event.preventDefault();location.href='PreEditarProductos'" class="btn btn-secondary">Cancelar</button>
			</div>
			
		</form>
	</div>
	<%
	}
	%>
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
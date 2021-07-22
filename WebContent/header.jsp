<%HttpSession sesion = request.getSession();
String nombre;
nombre = (String)sesion.getAttribute("Nombre");
%>
<body>
	<div class="jumbotron text-center" style="margin-bottom: 0">
		<h1>Prueba modulo 4</h1>
		<p>Para el curso de JEE</p>
	</div>

			<div style="background:#777" class="d-flex justify-content-end p-3 ">
				<span style="color:white; font-size:1.4rem;align-self:center:">Bienvenido, <%=nombre%></span>
				<a href="logout" class="btn btn-success mx-1 ms-5">Cerrar Sesion</a>
			</div>
	<nav class="navbar navbar-expand-sm px-5 bg-dark navbar-dark">
		<a class="navbar-brand" href="ProductoServlet">Lista De Productos</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="preInsertarProductos">Agregar Productos</a></li>
				<li class="nav-item"><a class="nav-link" href="PreEditarProductos">Editar Productos</a></li>
				<li class="nav-item"><a class="nav-link" href="borraProducto">Borrar Productos</a></li>

			</ul>
		</div>
	</nav>
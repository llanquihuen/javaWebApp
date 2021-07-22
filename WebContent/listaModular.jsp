<%@ page import="java.util.List"%>
<%@ page import="com.desafiolatam.modelo.Producto"%>
<%@ page import="com.desafiolatam.modelo.Categoria"%>
	<%
		List<Producto> elProducto;
	List<Categoria> laCategoria;
	// capturamos informacion que viene desde el request
	elProducto = (List) request.getAttribute("ListaDeproductos");
	laCategoria = (List) request.getAttribute("ListaDeCategorias");
	//cookie
	%>
<div class="container my-5 m-auto py-4">

		<table class="table table-dark">
			<tbody>
			<thead>
				<tr>
					<th>N° Producto</th>
					<th>Nombre Producto</th>
					<th>Precio</th>
					<th>Descripcion</th>
					<th>Categoria</th>
				</tr>
			</thead>
		<%
			for (Producto pr : elProducto) {
		%>
			<tr>
				<td><%=pr.getIdProducto() %></td>
				<td><%=pr.getNombreProducto()%></td>
				<td>$<%=pr.getPrecioProducto()%></td>
				<td><%=pr.getDescripcionProducto()%></td>
				<%
				for (int i=0; i<=laCategoria.size();i++) {
					if(pr.getIdCategoria()==i){
						String cat = laCategoria.get(i-1).getNombreCategoria();
				%>
				<td><%=cat%></td>
				<%
					}
				}
				%>
			</tr>
		<%
			}
		%>
			</tbody>
		</table>
	</div>
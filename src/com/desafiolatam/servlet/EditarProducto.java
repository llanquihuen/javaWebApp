package com.desafiolatam.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.facade.Facade;
import com.desafiolatam.modelo.Categoria;
import com.desafiolatam.modelo.Producto;

/**
 * Servlet implementation class EditarProducto
 */
@WebServlet("/editarProducto")
public class EditarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  int idProducto = Integer.parseInt(request.getParameter("idProducto"));
	      String nombre = request.getParameter("nombreProducto");
	      int precio = Integer.parseInt(request.getParameter("precioProducto"));
	      String descripcion = request.getParameter("descripcionProducto");
	      int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
	       // instancio el DTO y le asigno los datos
	      Producto dto = new Producto();
	      dto.setNombreProducto(nombre);
	      dto.setPrecioProducto(precio);
	      dto.setDescripcionProducto(descripcion);
	      dto.setIdCategoria(idCategoria);
	      dto.setIdProducto(idProducto);
	      // invoco al facade para procesar la inscripcion
	      Facade facade = new Facade();
			try {
				facade.editarProducto(dto);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}   
			List<Producto> listaProductos = null;
			try {
				listaProductos = facade.obtieneProductos();
			} catch (Exception e) {
				e.printStackTrace();
			}
			List<Categoria> listaCategorias = null;
			try {
				listaCategorias = facade.obtenerCategorias();
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("ListaDeproductos", listaProductos);
			request.setAttribute("ListaDeCategorias", listaCategorias);
	       // redirecciono el control hacia la siguiente vista,
	       // es decir: hacia su servlet de pre-confirmacion
	      request.getRequestDispatcher("editarProductos.jsp").forward(request, response);
	   }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numProducto = Integer.parseInt(request.getParameter("idProducto"));
		Facade facade = new Facade();
		Producto editar = null;
		try {
			editar = facade.obtieneProductos(numProducto);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		request.setAttribute("paraEditar", editar);
		request.getRequestDispatcher("PreEditarProductos").forward(request,response);

	}

}

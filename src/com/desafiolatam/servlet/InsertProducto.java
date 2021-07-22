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
import com.desafiolatam.modelo.Producto;

/**
 * Servlet implementation class InsertProducto
 */
@WebServlet("/insertProducto")
public class InsertProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// obtengo los datos del formulario
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
	      // invoco al facade para procesar la inscripcion
	      Facade facade = new Facade();
			try {
				facade.insertarProducto(dto);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}    
	       // redirecciono el control hacia la siguiente vista,
	       // es decir: hacia su servlet de pre-confirmacion
	      request.getRequestDispatcher("/ProductoServlet").forward(request, response);
	  
	}

}

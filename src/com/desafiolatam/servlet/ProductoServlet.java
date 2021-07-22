package com.desafiolatam.servlet;

import java.io.IOException;
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
 * Servlet implementation class ProductoServlet
 */
@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ProductoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Facade facade = new Facade();
		try {
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

			request.getRequestDispatcher("paginaProductos.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

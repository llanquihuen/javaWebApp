package com.desafiolatam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/procesaLogin")
public class ProcesaLogin extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private final String LOGIN = "Luis";
	private final String PASS = "pass";
	
	protected void doPost (HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException{
		String requestLogin ="";
		String requestPass ="";
		//Imprimir en HTML
		PrintWriter wr = res.getWriter();
		//Obtener valores desde el formulario
		requestLogin = req.getParameter("login");
		requestPass = req.getParameter("pass");
		
		//COMPARARLO CON EL LOGIN y PASS
		
		if(!LOGIN.contentEquals(requestLogin)|| !PASS.contentEquals(requestPass)) {
			wr.println("<script type=\"text/javascript\">");
			wr.println("alert('Usuario o password incorrecto');");
			wr.println("location='login.jsp';");
			wr.println("</script>");
		}else {
			//ve si hay una sesion, si no lo hay crea una nueva.
			HttpSession sesionUsuario = req.getSession(true);
			
			//Se crea atributo para estar en la cookie
			sesionUsuario.setAttribute("Nombre", requestLogin);
			//Envuelve y envia hacia un lugar
			RequestDispatcher rd = req.getRequestDispatcher("ProductoServlet");
			//lo envia a un HTML o JSP
			rd.forward(req, res);

			
		}
	}
	
	
	
}
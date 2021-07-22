package com.desafiolatam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class Logout extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
		HttpSession sesion = req.getSession();
		PrintWriter wr = res.getWriter();
		wr.println("<script type=\"text/javascript\">");
		wr.println("alert('Ha cerrado sesion correctamente');");
		wr.println("</script>");
		//invalidate destruye la sesion
		sesion.invalidate();
		//el metodo sendRedirect redirige al formulario de ingreso
		res.sendRedirect("login.jsp");
		return;
	}
}
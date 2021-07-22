package com.desafiolatam.procesaConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;

public class AdministradorConexion {
	protected Connection conn = null;
	protected PreparedStatement pstm = null;
	protected ResultSet rs = null;
	protected Connection generaPoolConexion() {
		Context initContext;
		if (conn == null) {
			try {
				initContext = new InitialContext();
				String usr = "root";
				String pwd = "admin";
				String driver = "com.mysql.cj.jdbc.Driver";
				String url = "jdbc:mysql://localhost/ProductosLimpieza";
				Class.forName(driver);
				conn = DriverManager.getConnection(url, usr, pwd);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return conn;
		} else {
			return conn;
		}
	}
}

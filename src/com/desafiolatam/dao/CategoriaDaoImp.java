package com.desafiolatam.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.desafiolatam.modelo.Categoria;
import com.desafiolatam.procesaConexion.AdministradorConexion;

public class CategoriaDaoImp extends AdministradorConexion implements CategoriaDao {
	public CategoriaDaoImp() {
		// extiende de AdministradorConexion
		Connection conn = generaPoolConexion();
	}

//implementa la interface DepartamentoDao
	@Override
	public List<Categoria> obtieneCategoria() {

		List<Categoria> categorias = new ArrayList<Categoria>();
		String sql = "SELECT * FROM Categoria";
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Categoria objCat = new Categoria();
				objCat.setIdCategoria(rs.getInt("id_categoria"));
				objCat.setNombreCategoria(rs.getString("nombre_categoria"));
				categorias.add(objCat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categorias;
	}
}

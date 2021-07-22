package com.desafiolatam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desafiolatam.modelo.Producto;
import com.desafiolatam.procesaConexion.AdministradorConexion;

public class ProductoDaoImp extends AdministradorConexion implements ProductoDao{
	public ProductoDaoImp() {
		//extiende de AdministradorConexion
			Connection conn = generaPoolConexion();
		}
		
		//implementa la interface DepartamentoDao
		@Override
		public List<Producto> obtieneProducto(){
			
		List<Producto> productos = new ArrayList<Producto>();
			String sql = "SELECT * FROM Producto";
			try {
				pstm = conn.prepareStatement(sql);
				rs = pstm.executeQuery();
				while (rs.next()) {
								
					Producto objProd = new Producto();
					objProd.setIdProducto(rs.getInt("id_producto"));
					objProd.setNombreProducto(rs.getString("nombre_producto"));
					objProd.setPrecioProducto(rs.getInt("precio_producto"));
					objProd.setDescripcionProducto(rs.getString("descripcion_producto"));
					objProd.setIdCategoria(rs.getInt("id_categoria"));				
					productos.add(objProd);
				}
			} catch (Exception e) {
				e.printStackTrace();
		}
			return productos;
		}
		public Producto obtieneProducto(int num){
			
			String sql = "SELECT * FROM Producto WHERE id_producto = ?";
			Producto objProd = new Producto();

			try {
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1,num);
				rs = pstm.executeQuery();
				while (rs.next()) {

					objProd.setIdProducto(rs.getInt("id_producto"));
					objProd.setNombreProducto(rs.getString("nombre_producto"));
					objProd.setPrecioProducto(rs.getInt("precio_producto"));
					objProd.setDescripcionProducto(rs.getString("descripcion_producto"));
					objProd.setIdCategoria(rs.getInt("id_categoria"));	
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return objProd;
		}
		
		public void deleteProducto(int borrar) {
				try {
			
				String sql = "DELETE FROM Producto WHERE id_producto = ?";
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1,borrar);
				int resultado = pstm.executeUpdate();
				if (resultado>0) {
					System.out.println("Fila correctamente eliminada!");				
				} else {
					System.out.println("Ocurrio un error eliminando el producto!");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				try {
					if (pstm != null) pstm.close();
					if (conn != null) conn.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		public void editaProducto(Producto dto) {

			try {
				String sql = "UPDATE Producto SET nombre_producto = ?, precio_producto = ?,descripcion_producto = ?, id_categoria = ? WHERE id_producto = ?";
				pstm = conn.prepareStatement(sql);
				try {
					pstm.setString(1, dto.getNombreProducto());
					pstm.setInt(2, dto.getPrecioProducto());
					pstm.setString(3, dto.getDescripcionProducto());
					pstm.setInt(4, dto.getIdCategoria());
					pstm.setInt(5, dto.getIdProducto());
					pstm.executeUpdate();
				}catch(Exception ex) {
					ex.printStackTrace();
					throw new RuntimeException("A ocurrido un error	inesperado" + ex);
				}
				int resultado = pstm.executeUpdate();
				if (resultado>0) {
					System.out.println("Fila correctamente actualizada!");				
				} else {
					System.out.println("Ocurrio un error actualizar!");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				try {
					if (pstm != null) pstm.close();
					if (conn != null) conn.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		
		public void insertarProducto(Producto dto) throws SQLException, ClassNotFoundException {
			// Query para obtener el una secuencia y asignar un id
			String insertarProducto = " INSERT INTO Producto(" 
									+ " nombre_producto, precio_producto,descripcion_producto, id_categoria)"
									+ " VALUES (?,?,?,?) ";
			// conexion a la base de datos y ejecucion de la sentencia

			try {
				PreparedStatement stmt2 = conn.prepareStatement(insertarProducto);
				stmt2.setString(1, dto.getNombreProducto());
				stmt2.setInt(2, dto.getPrecioProducto());
				stmt2.setString(3, dto.getDescripcionProducto());
				stmt2.setInt(4, dto.getIdCategoria());
				if (stmt2.executeUpdate() != 1) {
					throw new RuntimeException("A ocurrido un error inesperado");
				}
			}catch(Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException("A ocurrido un error	inesperado" + ex);
			}
		}

		
		
		
		
}

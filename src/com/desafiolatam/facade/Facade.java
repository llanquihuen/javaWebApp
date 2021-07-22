package com.desafiolatam.facade;

import java.sql.SQLException;
import java.util.List;

import com.desafiolatam.dao.CategoriaDaoImp;
import com.desafiolatam.dao.ProductoDaoImp;
import com.desafiolatam.modelo.Categoria;
import com.desafiolatam.modelo.Producto;

public class Facade {

		public List<Producto> obtieneProductos(){
			ProductoDaoImp dao = new ProductoDaoImp();
			List<Producto> listaResult = dao.obtieneProducto();
			return listaResult;
		}
		public Producto obtieneProductos(int num)throws
		SQLException, ClassNotFoundException {		
			ProductoDaoImp dao = new ProductoDaoImp();
			Producto result = dao.obtieneProducto(num);
			return result;
		}
		
		public List<Categoria> obtenerCategorias(){
			CategoriaDaoImp dao = new CategoriaDaoImp();
			List<Categoria> listaResult = dao.obtieneCategoria();
			return listaResult;
		}
		
		public void insertarProducto(Producto dto) throws
		SQLException, ClassNotFoundException {
			ProductoDaoImp dao = new ProductoDaoImp();
			dao.insertarProducto(dto);
		}
		
		public void borrarProducto(int num) {
			ProductoDaoImp dao = new ProductoDaoImp();
			dao.deleteProducto(num);
		}
		public void editarProducto(Producto dto)throws
		SQLException, ClassNotFoundException  {
			ProductoDaoImp dao = new ProductoDaoImp();
			dao.editaProducto(dto);
		}
		
}

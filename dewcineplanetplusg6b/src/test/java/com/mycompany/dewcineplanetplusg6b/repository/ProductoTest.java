package com.mycompany.dewcineplanetplusg6b.repository;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.mycompany.dewcineplanetplusg6b.model.Producto;
import com.mycompany.dewcineplanetplusg6b.model.Usuario;

public class ProductoTest {
	ProductoRepository  productoRepository = new ProductoRepository();
	
	@Test
	public void obtenerProductos(){
		
		List<Producto> productos = productoRepository.obtenerTodosProdcutos();
			assertTrue (productos.size()>0);
			/*for(int i=0; i<usuarios.size();i++){
				assertEquals("I", usuarios.get(i).getTipoUsuario());
				break;
			}*/
			//assertEquals("I", usuarios.get(0).getTipoUsuario());
	}
}

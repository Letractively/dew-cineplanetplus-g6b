package com.mycompany.dewcineplanetplusg6b.repository;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.mycompany.dewcineplanetplusg6b.model.Carrito;
import com.mycompany.dewcineplanetplusg6b.model.Usuario;

public class CarritoTest {
	
	CarritoRepository  carritoRepository = new CarritoRepository();
	
	@Test
	public void obtenerDetalle(){
		
		List<Carrito> carritos = carritoRepository.obtenerTodosDetalles();
			assertTrue (carritos.size()>0);
			/*for(int i=0; i<usuarios.size();i++){
				assertEquals("I", usuarios.get(i).getTipoUsuario());
				break;
			}*/
			//assertEquals("I", usuarios.get(0).getTipoUsuario());
	}
	
	@Test
	public void AgregarCarrito(){
		String usuario;
		String producto;
		//List<Usuario> listausuario = new ArrayList<Usuario>();
		usuario = "duke";
		producto = "coca";
		assertTrue(carritoRepository.agregarCarrito(usuario,producto));
	
	}

}

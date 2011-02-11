package com.mycompany.dewcineplanetplusg6b.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mycompany.dewcineplanetplusg6b.model.Carrito;
import com.mycompany.dewcineplanetplusg6b.model.Usuario;

public class CarritoRepository {
	List<Carrito> lista = new ArrayList<Carrito>();
	public List<Carrito> obtenerTodosDetalles() {
		//List<Carrito> lista = new ArrayList<Carrito>();
		Carrito c1 = new Carrito("usuario1","producto1");
		Carrito c2 = new Carrito("usuario1","producto2");
		Carrito c3 = new Carrito("usuario2","producto2");
		lista.add(c1);
		lista.add(c2);
		lista.add(c3);
		return lista;
	}

	public boolean agregarCarrito(String usuario, String producto) {
		
		List<Carrito> listacarrito = obtenerTodosDetalles();
		Carrito c4 = new Carrito(usuario,producto);
		listacarrito.add(c4);
		
		for( Iterator it = listacarrito.iterator(); it.hasNext(); ) { 
		    Carrito x = (Carrito)it.next();
		    System.out.println(x.getUsuario() + " " + x.getProducto());
		}

		return true;
	}

}

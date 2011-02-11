package com.mycompany.dewcineplanetplusg6b.repository;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.dewcineplanetplusg6b.model.Producto;
import com.mycompany.dewcineplanetplusg6b.model.Usuario;

public class ProductoRepository {

	public List<Producto> obtenerTodosProdcutos() {
		List<Producto> lista = new ArrayList<Producto>();
		Producto u1 = new Producto("pro1");
		Producto u2 = new Producto("pro2");
		Producto u3 = new Producto("pro3");
		lista.add(u1);
		lista.add(u2);
		lista.add(u3);
		return lista;
	}

}

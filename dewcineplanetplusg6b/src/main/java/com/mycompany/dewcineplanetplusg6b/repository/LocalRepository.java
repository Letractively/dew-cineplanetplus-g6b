package com.mycompany.dewcineplanetplusg6b.repository;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.dewcineplanetplusg6b.model.Carrito;
import com.mycompany.dewcineplanetplusg6b.model.Local;

public class LocalRepository {

	public List<Local> obtenerTodosLocales() {
		List<Local> lista = new ArrayList<Local>();
		Local l1 = new Local("l1","sala1","Miraflores");
		Local l2 = new Local("l2","sala1","San Miguel");
		Local l3 = new Local("l3","sala2","Chorrillos");
		lista.add(l1);
		lista.add(l2);
		lista.add(l3);
		return lista;
	}

}

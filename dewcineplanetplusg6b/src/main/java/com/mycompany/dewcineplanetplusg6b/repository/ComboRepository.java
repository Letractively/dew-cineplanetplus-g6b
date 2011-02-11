package com.mycompany.dewcineplanetplusg6b.repository;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.dewcineplanetplusg6b.model.Butaca;
import com.mycompany.dewcineplanetplusg6b.model.Combo;

public class ComboRepository {

	public List<Combo> obtenerTodosCombos() {
		List<Combo> lista = new ArrayList<Combo>();
		Combo c1 = new Combo("c1");
		Combo c2 = new Combo("c2");
		Combo c3 = new Combo("c3");
		lista.add(c1);
		lista.add(c2);
		lista.add(c3);
		return lista;
	}

}

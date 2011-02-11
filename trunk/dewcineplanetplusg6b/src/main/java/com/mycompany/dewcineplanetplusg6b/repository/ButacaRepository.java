package com.mycompany.dewcineplanetplusg6b.repository;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.dewcineplanetplusg6b.model.Butaca;
import com.mycompany.dewcineplanetplusg6b.model.Usuario;

public class ButacaRepository {

	public List<Butaca> obtenerTodasButacas() {
		List<Butaca> lista = new ArrayList<Butaca>();
		Butaca b1 = new Butaca("b1");
		Butaca b2 = new Butaca("b2");
		Butaca b3 = new Butaca("b3");
		lista.add(b1);
		lista.add(b2);
		lista.add(b3);
		return lista;
	}

}

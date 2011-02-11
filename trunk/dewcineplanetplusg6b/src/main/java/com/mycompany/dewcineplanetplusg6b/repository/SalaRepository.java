package com.mycompany.dewcineplanetplusg6b.repository;

import java.util.ArrayList;
import java.util.List;
 
import com.mycompany.dewcineplanetplusg6b.model.Sala;

public class SalaRepository {

	public List<Sala> obtenerTodasSalas() {
		List<Sala> lista = new ArrayList<Sala>();
		Sala s1 = new Sala("s1","A","1","RESERVADO");
		Sala s2 = new Sala("s1","A","2","LIBRE");
		Sala s3 = new Sala("s1","B","2","RESERVADO");
		lista.add(s1);
		lista.add(s2);
		lista.add(s3);
		return lista;
	}

}

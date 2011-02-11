package com.mycompany.dewcineplanetplusg6b.repository;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.mycompany.dewcineplanetplusg6b.model.Butaca;

public class ButacaTest {

	ButacaRepository butacaRepository = new ButacaRepository();
	
	@Test
	public void obtenerButacas(){
		List<Butaca> butacas = butacaRepository.obtenerTodasButacas();
			assertTrue (butacas.size()>0);
		
	}
	
	
}

package com.mycompany.dewcineplanetplusg6b.repository;

import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Test;

import com.mycompany.dewcineplanetplusg6b.model.Combo;

public class ComboTest {
	
	ComboRepository comboRepository = new ComboRepository();
	@Test
	public void obtenerCombos(){
		List<Combo> combos = comboRepository.obtenerTodosCombos();
			assertTrue (combos.size()>0);
		
	}

}

package com.mycompany.dewcineplanetplusg6b.repository;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.mycompany.dewcineplanetplusg6b.model.Carrito;
import com.mycompany.dewcineplanetplusg6b.model.Local;

public class LocalTest {
	LocalRepository  localRepository = new LocalRepository();
	
	@Test
	public void obtenerLocales(){
		
		List<Local> locales = localRepository.obtenerTodosLocales();
			assertTrue (locales.size()>0);
			/*for(int i=0; i<usuarios.size();i++){
				assertEquals("I", usuarios.get(i).getTipoUsuario());
				break;
			}*/
			//assertEquals("I", usuarios.get(0).getTipoUsuario());
	}
}

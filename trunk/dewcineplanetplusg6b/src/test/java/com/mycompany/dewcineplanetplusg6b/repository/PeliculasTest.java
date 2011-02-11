package com.mycompany.dewcineplanetplusg6b.repository;


import static org.junit.Assert.*;
 
import java.util.List;

import org.junit.Test;


import com.mycompany.dewcineplanetplusg6b.model.Pelicula;




public class PeliculasTest {
	
	PeliculaRepository peliculaRepository = new PeliculaRepository();
	

	@Test
	public void obtenerPeliculas(){
		List<Pelicula> peliculas = peliculaRepository.obtenerTodasPeliculas();
			assertTrue (peliculas.size()>0);
		
	}
}

 
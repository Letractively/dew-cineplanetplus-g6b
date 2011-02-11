//El usuario registrado o no registrado puede ver el 
//merchandizing relacionado a una pelicula

package com.mycompany.dewcineplanetplusg6b.repository;

import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

import com.mycompany.dewcineplanetplusg6b.model.Pelicula;

public class MerchandisingTest {
	PeliculaRepository  peliculaRepository = new PeliculaRepository();
	List<Pelicula> peliculas = peliculaRepository.obtenerTodasPeliculas();
	
	@Test
	public void peliculasMerchandising(){
		 	String pelicula;	
		 	pelicula = "Spiderman - 4";
		 	assertTrue(peliculaRepository.verificarMerchandasing(pelicula));
		}
	  }

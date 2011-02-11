package com.mycompany.dewcineplanetplusg6b.repository;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.mycompany.dewcineplanetplusg6b.model.Pelicula;


public class DetallePeliculaCarteleraTest {
	
	PeliculaRepository pelicularepository = new PeliculaRepository();
	
	@Test
	public void obtenerPeliculaCartelera(){
		String pelicula ="El Centinela";
		List<Pelicula> peliculas = pelicularepository.obtenerTodasPeliculas();
		
		for(int i=0; i<peliculas.size();i++){
			if(pelicula.equals(peliculas.get(i).getNombre()) && peliculas.get(i).getEstado().equals("ACTIVA")){
				System.out.print("La Pelicula " + peliculas.get(i).getNombre() + " Se encuentra en Cartelera");
				assertEquals("ACTIVA",peliculas.get(i).getEstado());
				break;
			}
		 
		}
		
		
	}
	
	
	
}

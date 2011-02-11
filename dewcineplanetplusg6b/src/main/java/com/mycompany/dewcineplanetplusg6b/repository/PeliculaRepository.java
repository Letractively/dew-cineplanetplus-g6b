package com.mycompany.dewcineplanetplusg6b.repository;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.dewcineplanetplusg6b.model.Pelicula;

public class PeliculaRepository {

	public List<Pelicula> obtenerTodasPeliculas() {
		List<Pelicula> lista = new ArrayList<Pelicula>();
		Pelicula p1 = new Pelicula("Enredados","SALA 1","SI","ACTIVA");
		Pelicula p2 = new Pelicula("Thor","SALA 2","NO","INACTIVA");
		Pelicula p3 = new Pelicula("El Centinela","SALA 3","SI","ACTIVA");
		Pelicula p4 = new Pelicula("Spiderman - 4","SALA 4","SI","ACTIVA");
		Pelicula p5 = new Pelicula("The Keeper","SALA 5","NO","INACTIVA");

		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		lista.add(p4);
		lista.add(p5);

		return lista;
	}
	public boolean verificarMerchandasing(String pelicula) {
		List<Pelicula> peliculas = obtenerTodasPeliculas();
		     for (Pelicula pelicula2 : peliculas) {
				if(pelicula2.getNombre().equals(pelicula)){
					if(pelicula2.getMerchandising().equals("SI")){
				return true;
				}
				}
			}
	    return false;
			}

	}



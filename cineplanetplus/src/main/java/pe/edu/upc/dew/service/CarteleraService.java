package pe.edu.upc.dew.service;

import java.util.List;

import pe.edu.upc.dew.model.ConsultaPelicula;
import pe.edu.upc.dew.model.Pelicula;
import pe.edu.upc.dew.model.ProgramacionPelicula;

public interface CarteleraService {

	/**
	 * @param idSala Id de la sala a la que se programara peliculas
	 * @param peliculas Lista de peliculas pendientes de asignar a cartelera(estado = 1)
	 * @param fechaInicio 
	 * @param fechaFin
	 */
	void crearCarteleraMasivamente(String idSala, List<Pelicula> peliculas, String fechaInicio, String fechaFin);
	
	void crearCarteleraPorPelicula(ProgramacionPelicula programacionPelicula);
	
	public List<ConsultaPelicula> consultarCartelera(String idCine, String IdSala, String titulo, String idHorario,String genero);
	
	public ConsultaPelicula obtenerCarteleraId(String idProgPel);
}

package pe.edu.upc.dew.dao;

import java.util.List;

import pe.edu.upc.dew.model.ConsultaPelicula;
import pe.edu.upc.dew.model.Horario;
import pe.edu.upc.dew.model.ProgramacionPelicula;

public interface CarteleraDao {

	void agregarProgramacionPelicula(ProgramacionPelicula programacionPelicula);

	void establecerProgramacionPeliculaHorario(ProgramacionPelicula programacionPelicula, Horario horario);

	public List<ConsultaPelicula> consultarCartelera(String idCine, String IdSala, String titulo, String idHorario,String genero);	
	
	void eliminar(ProgramacionPelicula programacionPelicula);

	void actualizar(ProgramacionPelicula programacionPelicula);

	public String obtenerCorrelativoId();
	
	public ConsultaPelicula obtenerCarteleraId(String idProgPel);
}

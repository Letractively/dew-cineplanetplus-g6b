package pe.edu.upc.dew.service;

import java.util.List;

import pe.edu.upc.dew.model.FilaAsiento;
import pe.edu.upc.dew.model.ProgramacionPelicula;
import pe.edu.upc.dew.model.Reservacion;
import pe.edu.upc.dew.model.ReservacionFilaAsiento;

public interface ReservacionService {

	/**
	 *  Retorna filas con asientos reservados y disponibles
	 * @param programacionPelicula
	 * @return
	 */
	List<FilaAsiento> obtenerFilasAsientoPorSalaPorFuncion(ProgramacionPelicula programacionPelicula,String fechaReservada);

	int cantidadAsientosSala(String idSala);

	int cantidadAsientosReservadosFuncion(String idProgramacionPelicula);
	
	void reservar(Reservacion reservacion, List<ReservacionFilaAsiento> asientosReservados);
}

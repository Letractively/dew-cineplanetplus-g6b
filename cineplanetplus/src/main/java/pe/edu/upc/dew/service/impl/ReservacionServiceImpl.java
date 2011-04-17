package pe.edu.upc.dew.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.dew.dao.FilaAsientoDao;
import pe.edu.upc.dew.dao.ReservacionDao;
import pe.edu.upc.dew.model.Asiento;
import pe.edu.upc.dew.model.FilaAsiento;
import pe.edu.upc.dew.model.FilaAsientoReservado;
import pe.edu.upc.dew.model.ProgramacionPelicula;
import pe.edu.upc.dew.model.Reservacion;
import pe.edu.upc.dew.model.ReservacionFilaAsiento;
import pe.edu.upc.dew.service.ReservacionService;

@Service
public class ReservacionServiceImpl implements ReservacionService {
	@Autowired
	private ReservacionDao reservacionDao;

	@Autowired
	private FilaAsientoDao filaAsientoDao;

	public void setReservacionDao(ReservacionDao reservacionDao) {
		this.reservacionDao = reservacionDao;
	}
	

	public void setFilaAsientoDao(FilaAsientoDao filaAsientoDao) {
		this.filaAsientoDao = filaAsientoDao;
	}


	public List<FilaAsiento> obtenerFilasAsientoPorSalaPorFuncion(ProgramacionPelicula programacionPelicula,String fechaReservada) {
		List<FilaAsiento> filasSala = filaAsientoDao.getFilasPorSala(programacionPelicula.getSala().getIdSala());
		//Generar los asientos d cada fila d esta sala
		for (FilaAsiento filaAsiento : filasSala) {
			List<Asiento> asientos = new ArrayList<Asiento>();
			for (int i = 1; i <= filaAsiento.getCantAsientos(); i++) {
				Asiento asiento = new Asiento();
				asiento.setNumero(i);
				asiento.setEstado("D");//D = disponible	; R = Reservado			
				asientos.add(asiento);
			}
			filaAsiento.setAsientos(asientos);
		}
		//----
		//obtener asientos reservados para esa funcion
		List<FilaAsientoReservado> filaAsientosReserv = reservacionDao
				.obtenerFilaAsientosReservados(programacionPelicula,fechaReservada);
		//por cada fila d asientos reservado
		for (FilaAsientoReservado filaAsientoReservado : filaAsientosReserv) {
			// recorrer las filas de la sala
			for (FilaAsiento filaAsiento : filasSala) {
				// solo si las filas coinciden
				if (filaAsientoReservado.getIdFilaAsiento() == filaAsiento.getIdFilaAsiento()) {
					List<Asiento> asientosGen = filaAsiento.getAsientos();
					// recorrer cada asiento
					for (Asiento asiento : asientosGen) {
						if (filaAsientoReservado.getNumeroAsiento() == asiento.getNumero()) {
							// actualizar estado
							asiento.setEstado("R");
						}
					}
				}
			}
		}
		//retornar filas con asientos reservados y disponibles
		return filasSala;
	}

	public int cantidadAsientosSala(String idSala) {
		return reservacionDao.cantidadAsientosSala(idSala);
	}

	public int cantidadAsientosReservadosFuncion(String idProgramacionPelicula) {
		return reservacionDao.cantidadAsientosReservadosFuncion(idProgramacionPelicula);
	}

	@Override
	public void reservar(Reservacion reservacion, List<ReservacionFilaAsiento> asientosReservados) {
		// se realiza la reservacion (se registra en tabla reservacion)-----------------------
		reservacionDao.agregarReservacion(reservacion);
		// A cont. se registra los asientos q seran reservados	
		//solo despues d haber registrado reservacion se genera el id y es lo q a cont se recupera
		reservacion.setIdReservacion(reservacionDao.obtenerMaxCorrelativoReservacion());
		for (ReservacionFilaAsiento reservacionFilaAsiento : asientosReservados) {
			reservacionDao.agregarReservacionFilaAsiento(reservacionFilaAsiento);
		}
	}

}

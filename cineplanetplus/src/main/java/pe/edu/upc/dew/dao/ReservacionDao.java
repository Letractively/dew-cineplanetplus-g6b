package pe.edu.upc.dew.dao;

import java.util.List;

import pe.edu.upc.dew.model.FilaAsientoReservado;
import pe.edu.upc.dew.model.ProgramacionPelicula;
import pe.edu.upc.dew.model.Reservacion;
import pe.edu.upc.dew.model.ReservacionFilaAsiento;

public interface ReservacionDao
{

    void agregarReservacion(Reservacion reservacion);

    void agregarReservacionFilaAsiento(ReservacionFilaAsiento reservacionFilaAsiento);

    public List<FilaAsientoReservado> obtenerFilaAsientosReservados(ProgramacionPelicula programacionPelicula,
            String fechaReservada);

    int cantidadAsientosSala(String idSala);

    int cantidadAsientosReservadosFuncion(String idProgramacionPelicula);

    String obtenerMaxCorrelativoReservacion();
}

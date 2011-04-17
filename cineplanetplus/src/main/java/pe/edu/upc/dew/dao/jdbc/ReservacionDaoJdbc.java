package pe.edu.upc.dew.dao.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import pe.edu.upc.dew.dao.ReservacionDao;
import pe.edu.upc.dew.model.FilaAsientoReservado;
import pe.edu.upc.dew.model.ProgramacionPelicula;
import pe.edu.upc.dew.model.Reservacion;
import pe.edu.upc.dew.model.ReservacionFilaAsiento;
import pe.edu.upc.dew.util.Util;

public class ReservacionDaoJdbc extends SimpleJdbcDaoSupport implements ReservacionDao
{

    @Override
    public void agregarReservacion(Reservacion reservacion)
    {
        String sql = "insert into reservacion(idReservacion,idUsuario,idProgramacionPelicula,fechaReservacion,cantAsientosReservados) values(?,?,?,?,?);";
        getSimpleJdbcTemplate().update(sql, obtenerCorrelativoId(), reservacion.getUsuario().getIdUsuario(),
                reservacion.getProgramacionPelicula().getId(), reservacion.getFechaReservacion(),
                reservacion.getCantAsientosReservados());

    }

    @Override
    public void agregarReservacionFilaAsiento(ReservacionFilaAsiento reservacionFilaAsiento)
    {
        String sql = "insert into reservacionfilaasiento(idReservacionFilaAsiento,idFilaAsiento,numeroAsiento,idReservacion,fechaReservada) values(?,?,?,?,?);";
        getSimpleJdbcTemplate().update(sql, obtenerCorrelativoIdReservacionFilaAsiento(),
                reservacionFilaAsiento.getIdFilaAsiento(), reservacionFilaAsiento.getNumeroAsiento(),
                reservacionFilaAsiento.getReservacion().getIdReservacion(),reservacionFilaAsiento.getFechaReservada());

    }

    public String obtenerCorrelativoIdReservacionFilaAsiento()
    {
        String correlativoId = "";
        String sql = "SELECT max(idReservacionFilaAsiento) FROM reservacionfilaasiento";
        String codigoMax = getSimpleJdbcTemplate().queryForObject(sql, String.class);
        if (codigoMax == null || codigoMax.equals(""))
        {
            correlativoId = "RFA00000001";
        }
        else
        {
            String codigo = codigoMax.substring(3);
            Integer cod = Integer.parseInt(codigo) + 1;
            correlativoId = Util.caracterIzquierda(cod.toString(), 8, "0");
            correlativoId = "RFA" + correlativoId;
        }
        return correlativoId;
    }

    public String obtenerCorrelativoId()
    {
        String correlativoId = "";
        String sql = "SELECT max(idReservacion) FROM reservacion";
        String codigoMax = getSimpleJdbcTemplate().queryForObject(sql, String.class);
        if (codigoMax == null || codigoMax.equals(""))
        {
            correlativoId = "RE00000001";
        }
        else
        {
            String codigo = codigoMax.substring(2);
            Integer cod = Integer.parseInt(codigo) + 1;
            correlativoId = Util.caracterIzquierda(cod.toString(), 8, "0");
            correlativoId = "RE" + correlativoId;
        }
        return correlativoId;
    }

    @SuppressWarnings("deprecation")
    @Override
    public List<FilaAsientoReservado> obtenerFilaAsientosReservados(ProgramacionPelicula programacionPelicula,
            String fechaReservada)
    {
        List<FilaAsientoReservado> filas = new ArrayList<FilaAsientoReservado>();
        String sql = "SELECT rfa.idFilaAsiento, rfa.numeroAsiento "
                + "FROM reservacion r, reservacionfilaasiento rfa, programacionpelicula pp WHERE r.idReservacion = rfa.idReservacion and r.idProgramacionPelicula = pp.id  and r.idProgramacionPelicula =? and rfa.fechaReservada=?";
        filas = getSimpleJdbcTemplate().query(sql, new FilaAsientoReservadoRowMapper(), programacionPelicula.getId(),
                fechaReservada);
        return filas;
    }

    @Override
    public int cantidadAsientosSala(String idSala)
    {
        String sql = "SELECT sum(fa.cantAsientos) FROM filaasiento fa WHERE fa.idSala = ?";
        int cantidad = getSimpleJdbcTemplate().queryForObject(sql, Integer.class, idSala);
        return cantidad;
    }

    @Override
    public int cantidadAsientosReservadosFuncion(String idProgramacionPelicula)
    {
        String sql = "SELECT count(r.idReservacion) FROM reservacion r, reservacionfilaasiento rfa, programacionpelicula pp WHERE r.idReservacion = rfa.idReservacion and r.idProgramacionPelicula = pp.id and r.idProgramacionPelicula = ?";
        int cantidad = getSimpleJdbcTemplate().queryForObject(sql, Integer.class, idProgramacionPelicula);
        return cantidad;
    }

    @Override
    public String obtenerMaxCorrelativoReservacion()
    {
        String sql = "SELECT max(idReservacion) FROM reservacion";
        return getSimpleJdbcTemplate().queryForObject(sql, String.class);
    }

}

package pe.edu.upc.dew.dao.jdbc;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.dew.dao.CarteleraDao;
import pe.edu.upc.dew.dao.FilaAsientoDao;
import pe.edu.upc.dew.dao.ReservacionDao;
import pe.edu.upc.dew.dao.UsuarioDao;
import pe.edu.upc.dew.model.Asiento;
import pe.edu.upc.dew.model.ConsultaPelicula;
import pe.edu.upc.dew.model.FilaAsiento;
import pe.edu.upc.dew.model.FilaAsientoReservado;
import pe.edu.upc.dew.model.ProgramacionPelicula;
import pe.edu.upc.dew.model.Reservacion;
import pe.edu.upc.dew.model.ReservacionFilaAsiento;
import pe.edu.upc.dew.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:pe/edu/upc/dew/test-infrastructure-config.xml" })
public class ReservacionDaoTest
{

    @Autowired
    private ReservacionDao reservacionDao;

    @Autowired
    private CarteleraDao carteleraDao;

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private FilaAsientoDao filaAsientoDao;

    List<FilaAsiento> filasSala;

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    @Before
    public void before()
    {
        // obtener las filas - asientos de una sala
        filasSala = filaAsientoDao.getFilasPorSala("S01");
        // Generar los asientos d cada fila d esta sala
        for (FilaAsiento filaAsiento : filasSala)
        {
            List<Asiento> asientos = new ArrayList<Asiento>();
            for (int i = 1; i <= filaAsiento.getCantAsientos(); i++)
            {
                Asiento asiento = new Asiento();
                asiento.setNumero(i);
                asiento.setEstado("D");// D = disponible ; R = Reservado
                asientos.add(asiento);
            }
            filaAsiento.setAsientos(asientos);
        }
    }

    @Test
    public void asientosPorSala()
    {
        for (FilaAsiento filaAsiento : filasSala)
        {
            List<Asiento> asientosGen = filaAsiento.getAsientos();
            for (Asiento asiento : asientosGen)
            {
                assertEquals("D", asiento.getEstado());
            }
        }
    }

    @Test
    public void asientosReservadosPorFuncion()
    {
        // de la funcion PP00000001
        ProgramacionPelicula programacionPelicula = new ProgramacionPelicula();
        programacionPelicula.setId("PP00000001");
        // obtener asientos disponible para esa funcion
        List<FilaAsientoReservado> filaAsientosReserv = reservacionDao.obtenerFilaAsientosReservados(
                programacionPelicula, "2011-02-02");
        // por cada fila d asientos reservado
        for (FilaAsientoReservado filaAsientoReservado : filaAsientosReserv)
        {
            // recorrer las filas de la sala
            for (FilaAsiento filaAsiento : filasSala)
            {
                // solo si las filas coinciden
                if (filaAsientoReservado.getIdFilaAsiento() == filaAsiento.getIdFilaAsiento())
                {
                    List<Asiento> asientosGen = filaAsiento.getAsientos();
                    // recorrer cada asiento
                    for (Asiento asiento : asientosGen)
                    {
                        if (filaAsientoReservado.getNumeroAsiento() == asiento.getNumero())
                        {
                            // actualizar estado
                            asiento.setEstado("R");
                        }
                    }
                }
            }
        }

        // probar q todos asientos d fila 1 estan reservados
        FilaAsiento filaAsiento01 = filasSala.get(0);
        List<Asiento> filasReservadas01 = filaAsiento01.getAsientos();
        for (Asiento asiento : filasReservadas01)
        {
            assertEquals("R", asiento.getEstado());
        }
        // probar q 1 asiento d fila 2 esta reservado
        FilaAsiento filaAsiento02 = filasSala.get(1);
        List<Asiento> asientosReservados = filaAsiento02.getAsientos();
        assertEquals("R", asientosReservados.get(0).getEstado());
        // probar q los demas asientos d fila 2 estan disponibles
        for (int i = 1; i < asientosReservados.size(); i++)
        {
            Asiento asiento = asientosReservados.get(i);
            assertEquals("D", asiento.getEstado());
        }

    }

    @Test
    public void obtenerMaxIdReservacion()
    {
        assertEquals("RE00000004", reservacionDao.obtenerMaxCorrelativoReservacion());
    }

    @Test
    public void cantidadAsientosSala()
    {
        assertEquals((new Integer(49)).intValue(), reservacionDao.cantidadAsientosSala("S01"));
    }

    @Test
    public void cantidadAsientosReservadosFuncion()
    {
        assertEquals((new Integer(8)).intValue(), reservacionDao.cantidadAsientosReservadosFuncion("PP00000001"));
    }

    @Test
    @Transactional
    public void reservarAsientosDisponibles()
    {
        // usuario con id USU00000010 sera quien reservara
        Usuario usuario = usuarioDao.getUsuarioPorId("USU00000011");
        assertEquals("USU00000011", usuario.getIdUsuario());

        // Est consulta las funciones x cine x sala x pelicula x horario y
        // seleccionada
        List<ConsultaPelicula> peliculas = carteleraDao.consultarCartelera("C01", "S01", "PEL0001", "1", "Drama");
        // se verifica si en esa funcion hay disponibilidad de asientos(se
        // obtiene cant asientos disponibles)
        // se obtiene el id de la programacion seleccionada
        ConsultaPelicula consultaPelicula = peliculas.get(0);

        // si es que hay disponibilidad se realiza la reservacion
        Reservacion reservacion = new Reservacion();
        reservacion.setUsuario(usuario);
        ProgramacionPelicula programacionPelicula = new ProgramacionPelicula();
        programacionPelicula.setId(consultaPelicula.getId());
        reservacion.setProgramacionPelicula(programacionPelicula);
        try
        {
            reservacion.setFechaReservada(formato.parse("02/02/2011"));
            reservacion.setFechaReservacion(formato.parse("01/02/2011"));

            reservacion.setCantAsientosReservados(new Integer(3));

            // se realiza la reservacion (se registra en tabla
            // reservacion)-----------------------
            reservacionDao.agregarReservacion(reservacion);

            // A cont. se registra los asientos q seran reservados
            // solo despues d haber registrado reservacion se genera el id y es
            // lo q a cont se recupera
            reservacion.setIdReservacion(reservacionDao.obtenerMaxCorrelativoReservacion());
            // Como sabemos q en fila 2 a partir de asiento 2 estan disponibles
            List<ReservacionFilaAsiento> asientosReservados = new ArrayList<ReservacionFilaAsiento>();
            {
                ReservacionFilaAsiento reservacionFilaAsiento = new ReservacionFilaAsiento();
                reservacionFilaAsiento.setIdFilaAsiento(new Integer(2));
                reservacionFilaAsiento.setNumeroAsiento(new Integer(1));
                reservacionFilaAsiento.setReservacion(reservacion);
                reservacionFilaAsiento.setFechaReservada(formato.parse("02/02/2011"));
                asientosReservados.add(reservacionFilaAsiento);
            }
            {
                ReservacionFilaAsiento reservacionFilaAsiento = new ReservacionFilaAsiento();
                reservacionFilaAsiento.setIdFilaAsiento(new Integer(2));
                reservacionFilaAsiento.setNumeroAsiento(new Integer(2));
                reservacionFilaAsiento.setFechaReservada(formato.parse("02/02/2011"));
                reservacionFilaAsiento.setReservacion(reservacion);
                asientosReservados.add(reservacionFilaAsiento);
            }
            {
                ReservacionFilaAsiento reservacionFilaAsiento = new ReservacionFilaAsiento();
                reservacionFilaAsiento.setIdFilaAsiento(new Integer(2));
                reservacionFilaAsiento.setNumeroAsiento(new Integer(3));
                reservacionFilaAsiento.setFechaReservada(formato.parse("02/02/2011"));
                reservacionFilaAsiento.setReservacion(reservacion);
                asientosReservados.add(reservacionFilaAsiento);
            }

            for (ReservacionFilaAsiento reservacionFilaAsiento : asientosReservados)
            {
                reservacionDao.agregarReservacionFilaAsiento(reservacionFilaAsiento);
            }
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        // Comprobacion(inicialmente habia 8 como se han reservado 3 asientos
        // deberia incrementarse)
        assertEquals((new Integer(11)).intValue(), reservacionDao.cantidadAsientosReservadosFuncion("PP00000001"));

    }

}

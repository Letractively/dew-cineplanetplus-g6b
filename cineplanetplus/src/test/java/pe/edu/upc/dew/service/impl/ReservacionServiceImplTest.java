package pe.edu.upc.dew.service.impl;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.dew.dao.CarteleraDao;
import pe.edu.upc.dew.dao.UsuarioDao;
import pe.edu.upc.dew.model.Asiento;
import pe.edu.upc.dew.model.ConsultaPelicula;
import pe.edu.upc.dew.model.FilaAsiento;
import pe.edu.upc.dew.model.ProgramacionPelicula;
import pe.edu.upc.dew.model.Reservacion;
import pe.edu.upc.dew.model.ReservacionFilaAsiento;
import pe.edu.upc.dew.model.Sala;
import pe.edu.upc.dew.model.Usuario;
import pe.edu.upc.dew.service.ReservacionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:pe/edu/upc/dew/test-infrastructure-config.xml" })
public class ReservacionServiceImplTest {
	@Autowired
	ReservacionService reservacionService;

	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private CarteleraDao carteleraDao;

	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	@Test
	public void cantidadAsientosSala() {
		assertEquals((new Integer(49)).intValue(), reservacionService.cantidadAsientosSala("S01"));
	}

	@Test
	public void cantidadAsientosReservadosFuncion() {
		assertEquals((new Integer(8)).intValue(), reservacionService.cantidadAsientosReservadosFuncion("PP00000001"));
	}

	@Test
	public void obtenerFilasAsientoPorSalaPorFuncion() {

		ProgramacionPelicula programacionPelicula = new ProgramacionPelicula();
		programacionPelicula.setId("PP00000001");
		Sala sala = new Sala();
		sala.setIdSala("S01");
		programacionPelicula.setSala(sala);

		List<FilaAsiento> filasSala = reservacionService.obtenerFilasAsientoPorSalaPorFuncion(programacionPelicula, "2011-02-02");

		//probar q todos asientos d fila 1 estan reservados	
		FilaAsiento filaAsiento01 = filasSala.get(0);
		List<Asiento> filasReservadas01 = filaAsiento01.getAsientos();
		for (Asiento asiento : filasReservadas01) {
			assertEquals("R", asiento.getEstado());
		}
		//probar q 1 asiento d fila 2 esta reservado
		FilaAsiento filaAsiento02 = filasSala.get(1);
		List<Asiento> asientosReservados = filaAsiento02.getAsientos();
		assertEquals("R", asientosReservados.get(0).getEstado());
		//probar q los demas asientos d fila 2 estan disponibles
		for (int i = 1; i < asientosReservados.size(); i++) {
			Asiento asiento = asientosReservados.get(i);
			assertEquals("D", asiento.getEstado());
		}
	}

	@Test
	@Transactional
	public void reservarAsientosDisponibles() {
		// usuario con id USU00000010 sera quien reservara
		Usuario usuario = usuarioDao.getUsuarioPorId("USU00000011");
		assertEquals("USU00000011", usuario.getIdUsuario());

		// Est consulta las funciones x cine x sala x pelicula x horario y seleccionada 
		List<ConsultaPelicula> peliculas = carteleraDao.consultarCartelera("C01", "S01", "PEL0001", "1", "Drama");
		//se verifica si en esa funcion hay disponibilidad de asientos(se obtiene cant asientos disponibles)
		// se obtiene el id de la programacion seleccionada
		ConsultaPelicula consultaPelicula = peliculas.get(0);

		Reservacion reservacion = new Reservacion();
		reservacion.setUsuario(usuario);
		ProgramacionPelicula programacionPelicula = new ProgramacionPelicula();
		programacionPelicula.setId(consultaPelicula.getId());
		reservacion.setProgramacionPelicula(programacionPelicula);
		try {
		    reservacion.setFechaReservada(formato.parse("02/02/2011"));
			reservacion.setFechaReservacion(formato.parse("01/02/2011"));

		reservacion.setCantAsientosReservados(new Integer(3));

		// Como sabemos q en fila 2 a partir de asiento 2 estan disponibles
		List<ReservacionFilaAsiento> asientosReservados = new ArrayList<ReservacionFilaAsiento>();
		{
			ReservacionFilaAsiento reservacionFilaAsiento = new ReservacionFilaAsiento();
			reservacionFilaAsiento.setIdFilaAsiento(new Integer(2));
			reservacionFilaAsiento.setNumeroAsiento(new Integer(9));
			reservacionFilaAsiento.setReservacion(reservacion);
			reservacionFilaAsiento.setFechaReservada(formato.parse("02/02/2011"));
			asientosReservados.add(reservacionFilaAsiento);
		}
		{
			ReservacionFilaAsiento reservacionFilaAsiento = new ReservacionFilaAsiento();
			reservacionFilaAsiento.setIdFilaAsiento(new Integer(2));
			reservacionFilaAsiento.setNumeroAsiento(new Integer(10));
			reservacionFilaAsiento.setReservacion(reservacion);
			reservacionFilaAsiento.setFechaReservada(formato.parse("02/02/2011"));
			asientosReservados.add(reservacionFilaAsiento);
		}
		{
			ReservacionFilaAsiento reservacionFilaAsiento = new ReservacionFilaAsiento();
			reservacionFilaAsiento.setIdFilaAsiento(new Integer(2));
			reservacionFilaAsiento.setNumeroAsiento(new Integer(11));
			reservacionFilaAsiento.setReservacion(reservacion);
			reservacionFilaAsiento.setFechaReservada(formato.parse("02/02/2011"));
			asientosReservados.add(reservacionFilaAsiento);
		}

		reservacionService.reservar(reservacion, asientosReservados);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		//Comprobacion(inicialmente habia 8 como se han reservado 3 asientos deberia incrementarse)
		assertEquals((new Integer(11)).intValue(),
				reservacionService.cantidadAsientosReservadosFuncion(consultaPelicula.getId()));
	}

}

package pe.edu.upc.dew.dao.jdbc;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.dew.dao.CarteleraDao;
import pe.edu.upc.dew.dao.HorarioDao;
import pe.edu.upc.dew.dao.PeliculaDao;
import pe.edu.upc.dew.dao.SalaDao;
import pe.edu.upc.dew.model.ConsultaPelicula;
import pe.edu.upc.dew.model.Horario;
import pe.edu.upc.dew.model.Pelicula;
import pe.edu.upc.dew.model.ProgramacionPelicula;
import pe.edu.upc.dew.model.Sala;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:pe/edu/upc/dew/test-infrastructure-config.xml" })
public class CarteleraDaoTest {

	@Autowired
	private CarteleraDao carteleraDao;

	@Autowired
	private SalaDao salaDao;

	@Autowired
	private PeliculaDao peliculaDao;

	@Autowired
	private HorarioDao horarioDao;

	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	@Test
	public void obtenerCorrelativo() {
		assertEquals("PP00000016", carteleraDao.obtenerCorrelativoId());

	}

	@Test
	public void obtenerHorarioPorId() {
		{
			Horario horario = horarioDao.getHorarioPorId("1");
			assertEquals("13:00:00", horario.getHoraInicio());
			assertEquals("15:00:00", horario.getHoraFin());
		}
		{
			Horario horario = horarioDao.getHorarioPorId("2");
			assertEquals("15:00:00", horario.getHoraInicio());
			assertEquals("17:00:00", horario.getHoraFin());
		}
		{
			Horario horario = horarioDao.getHorarioPorId("5");
			assertEquals("21:00:00", horario.getHoraInicio());
			assertEquals("23:00:00", horario.getHoraFin());
		}
	}

	@Test
	public void obtenerHorarios() {
		assertEquals(5, horarioDao.getHorarios().size());
	}

	@Test
	@Transactional
	public void crearCarteleraMasivamente() {
		try {
			String codHorario = "";
			Integer contador = 0;
			Sala sala = salaDao.getSalaPorId("S01");
			//Se obtiene las peliculas con estado = 1(pendiente asignar a cartelera)
			List<Pelicula> peliculas = peliculaDao.getPeliculasParaCartelera();
			// se asignara masivamente en grupos de 5 peliculas (xq son 5 horarios diferentes)
			for (Pelicula pelicula : peliculas) {
				ProgramacionPelicula programacionPelicula = new ProgramacionPelicula();
				programacionPelicula.setSala(sala);
				programacionPelicula.setPelicula(pelicula);

				programacionPelicula.setDesde(formato.parse("01/03/2011"));
				programacionPelicula.setHasta(formato.parse("15/03/2011"));

				contador++;
				if (contador == 5)
                {
                    break;
                }						
				codHorario = contador.toString();
				programacionPelicula.setHorario(horarioDao.getHorarioPorId(codHorario));

				carteleraDao.agregarProgramacionPelicula(programacionPelicula);
				//cambiar de estado pelicula a 2(asignado a cartelera)
				pelicula.setEstado(new Integer(2));
				peliculaDao.modificar(pelicula);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void consultarCartelera() {
		{
			// Consulta cartelera x cine
			List<ConsultaPelicula> peliculas = carteleraDao.consultarCartelera("C01", "--Seleccione--",
					"--Seleccione--", "--Seleccione--", "--Seleccione--");
			assertEquals(10, peliculas.size());
			assertEquals("El Cisne Negro", peliculas.get(0).getTitulo());
			assertEquals("Drama", peliculas.get(0).getGenero());
		}
		{
			// Consulta cartelera x cine x sala
			List<ConsultaPelicula> peliculas = carteleraDao.consultarCartelera("C01", "S02", "--Seleccione--",
					"--Seleccione--", "--Seleccione--");
			assertEquals(5, peliculas.size());
			assertEquals("El Cisne Negro", peliculas.get(0).getTitulo());
			assertEquals("Drama", peliculas.get(0).getGenero());
		}
		{
			// Consulta x pelicula
			List<ConsultaPelicula> peliculas = carteleraDao.consultarCartelera("--Seleccione--", "--Seleccione--",
					"PEL0001", "--Seleccione--", "--Seleccione--");
			assertEquals(3, peliculas.size());
			assertEquals("El Cisne Negro", peliculas.get(0).getTitulo());
			assertEquals("Drama", peliculas.get(0).getGenero());
		}
		{
			// Consulta cartelera x cine, sala, pelicula,horario y genero
			List<ConsultaPelicula> peliculas = carteleraDao.consultarCartelera("C01", "S01", "PEL0001", "1", "Drama");
			assertEquals(1, peliculas.size());
			assertEquals("El Cisne Negro", peliculas.get(0).getTitulo());
			assertEquals("Drama", peliculas.get(0).getGenero());
		}
		{// Consulta en sala q no esta programada
			List<ConsultaPelicula> peliculas = carteleraDao.consultarCartelera("C02", "S01", "PEL0001", "1", "Drama");
			assertEquals(0, peliculas.size());

		}
	}

}

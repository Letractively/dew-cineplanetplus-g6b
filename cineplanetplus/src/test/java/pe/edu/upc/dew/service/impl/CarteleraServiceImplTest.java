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

import pe.edu.upc.dew.dao.PeliculaDao;
import pe.edu.upc.dew.model.ConsultaPelicula;
import pe.edu.upc.dew.model.Horario;
import pe.edu.upc.dew.model.Pelicula;
import pe.edu.upc.dew.model.ProgramacionPelicula;
import pe.edu.upc.dew.model.Sala;
import pe.edu.upc.dew.service.CarteleraService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:pe/edu/upc/dew/test-infrastructure-config.xml" })
public class CarteleraServiceImplTest {

	@Autowired
	CarteleraService carteleraService;
	
	@Autowired
	private PeliculaDao peliculaDao;

	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	@Test
	public void consultarCartelera() {
		{
			// Consulta cartelera x cine
			List<ConsultaPelicula> peliculas = carteleraService.consultarCartelera("C01", "--Seleccione--",
					"--Seleccione--", "--Seleccione--", "--Seleccione--");
            assertEquals(10, peliculas.size());
            assertEquals("El Cisne Negro", peliculas.get(0).getTitulo());
            assertEquals("Drama", peliculas.get(0).getGenero());
		}

		{
			// Consulta cartelera x cine x sala
			List<ConsultaPelicula> peliculas = carteleraService.consultarCartelera("C01", "S02", "--Seleccione--",
					"--Seleccione--", "--Seleccione--");
            assertEquals(5, peliculas.size());
            assertEquals("El Cisne Negro", peliculas.get(0).getTitulo());
            assertEquals("Drama", peliculas.get(0).getGenero());
		}
		{
			// Consulta x pelicula
			List<ConsultaPelicula> peliculas = carteleraService.consultarCartelera("--Seleccione--", "--Seleccione--",
					"PEL0001", "--Seleccione--", "--Seleccione--");
            assertEquals(3, peliculas.size());
            assertEquals("El Cisne Negro", peliculas.get(0).getTitulo());
            assertEquals("Drama", peliculas.get(0).getGenero());
		}
		{
			// Consulta cartelera x cine, sala, pelicula y horario
			List<ConsultaPelicula> peliculas = carteleraService.consultarCartelera("C01", "S01", "PEL0001", "1", "Drama");
            assertEquals(1, peliculas.size());
            assertEquals("El Cisne Negro", peliculas.get(0).getTitulo());
            assertEquals("Drama", peliculas.get(0).getGenero());
		}
		{
			// Consulta en sala q no esta programada
			List<ConsultaPelicula> peliculas = carteleraService.consultarCartelera("C02", "S01", "PEL0001", "1", "Drama");
			assertEquals(0, peliculas.size());
		}
	}

	@Test @Transactional
	public void crearCarteleraMasivamente() {		
		//Se obtiene las 5 peliculas con estado = 1(pendiente asignar a cartelera)
		List<Pelicula> peliculas = peliculaDao.getPeliculasParaCartelera();	
		assertEquals(10, peliculas.size());
		List<Pelicula> peliculasSeleccionadas = new ArrayList<Pelicula>();
		for (int i = 0; i < 5; i++)
        {
		    peliculasSeleccionadas.add(peliculas.get(i));            
        }
		
		carteleraService.crearCarteleraMasivamente("S01", peliculasSeleccionadas, "01/03/2011", "15/03/2011");		
	}
	
	@Test @Transactional
	public void crearCarteleraPorPelicula() {	
		ProgramacionPelicula programacionPelicula = new ProgramacionPelicula();
		Sala sala = new Sala();
		sala.setIdSala("S03");
		programacionPelicula.setSala(sala);
		try {
			programacionPelicula.setDesde(formato.parse("01/03/2011"));
			programacionPelicula.setHasta(formato.parse("01/03/2011"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Pelicula pelicula = new Pelicula();
		pelicula.setIdPelicula("PEL0002");
		
		Horario horario = new Horario();
		horario.setId("1");
		
		programacionPelicula.setPelicula(pelicula);
		programacionPelicula.setHorario(horario);
		
		carteleraService.crearCarteleraPorPelicula(programacionPelicula);
	}
}

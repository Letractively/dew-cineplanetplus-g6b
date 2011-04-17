package pe.edu.upc.dew.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.dew.model.Pelicula;
import pe.edu.upc.dew.service.PeliculaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:pe/edu/upc/dew/test-infrastructure-config.xml" })
public class PeliculaServiceImplTest {

	@Autowired
	private PeliculaService peliculaService;

	@Test
	public void getPeliculaPorId() {
		Pelicula pelicula = peliculaService.getPeliculaPorId("PEL0001");
		assertEquals("El Cisne Negro", pelicula.getTitulo());
        assertEquals("Drama", pelicula.getGenero());
        assertEquals("d_peliculas/fotos_cartelera/cisne_negro.jpg", pelicula.getImagen());
        assertEquals("Darren Aronofsky.", pelicula.getDirector());
        assertEquals("Natalie Portman, Mila Kunis, Vincent Cassel.", pelicula.getReparto());
		assertEquals(new Integer("1"), pelicula.getEstado());
	}

	@Test
	public void getPeliculasParaCartelera() {
		assertEquals(10, peliculaService.getPeliculasParaCartelera().size());
	}

	@Test
	public void getTodasPeliculas() {
		assertEquals(11, peliculaService.getTodasPeliculas().size());
	}

	@Test
	@Transactional
	public void agregarPelicula() {
		Pelicula pelicula = new Pelicula("El Aro", "Terror", "synopsis synopsis synopsis", "www.elaro.com", "imagen01",
				"Director1", "Actor 1, Actor 2", 120, "USA", 0, "Mayores 18", "S");
		peliculaService.agregar(pelicula);
		assertEquals(12, peliculaService.getTodasPeliculas().size());
	}

	@Test
	@Transactional
	public void eliminarPelicula() {
		Pelicula pelicula = new Pelicula("El Aro", "Terror", "synopsis synopsis synopsis", "www.elaro.com", "imagen01",
				"Director1", "Actor 1, Actor 2", 120, "USA", 0, "Mayores 18", "S");
		peliculaService.agregar(pelicula);
		assertEquals(12, peliculaService.getTodasPeliculas().size());
		//eliminamos
		peliculaService.eliminar("PEL0012");	
		assertEquals(11, peliculaService.getTodasPeliculas().size());
	}
	
	
	@Test
	@Transactional
	public void modificarPelicula() {
		{//se cambia titulo
			Pelicula pelicula = peliculaService.getPeliculaPorId("PEL0011");
			//cambia de estado creado(0) a estado pendiente d asignar a cartelera(1)
			pelicula.setTitulo("Alien");
			peliculaService.modificar(pelicula);
			Pelicula peliculaAct = peliculaService.getPeliculaPorId("PEL0011");
			assertEquals("Alien", peliculaAct.getTitulo());
		}
	}
	
	@Test
	@Transactional
	public void modificarEstadoPelicula() {
		{
			Pelicula pelicula = peliculaService.getPeliculaPorId("PEL0011");
			//cambia de estado creado(0) a estado pendiente d asignar a cartelera(1)
			pelicula.setEstado(new Integer(1));
			peliculaService.modificar(pelicula);
			assertEquals(new Integer(1), peliculaService.getPeliculaPorId("PEL0011").getEstado());
		}
		{
			Pelicula pelicula = peliculaService.getPeliculaPorId("PEL0011");
			//cambia de estado creado(1) a estado asignado a cartelera(2)
			pelicula.setEstado(new Integer(2));
			peliculaService.modificar(pelicula);
			assertEquals(new Integer(2), peliculaService.getPeliculaPorId("PEL0011").getEstado());
		}
		{
			Pelicula pelicula = peliculaService.getPeliculaPorId("PEL0011");
			//cambia de estado en cartelera (2) a estado fuera d cartelera(3)
			pelicula.setEstado(new Integer(3));
			peliculaService.modificar(pelicula);
			assertEquals(new Integer(3), peliculaService.getPeliculaPorId("PEL0011").getEstado());
		}
	}

}

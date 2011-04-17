package pe.edu.upc.dew.dao.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.dew.dao.PeliculaDao;
import pe.edu.upc.dew.model.Pelicula;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:pe/edu/upc/dew/test-infrastructure-config.xml" })
public class PeliculaDaoTest {

	@Autowired
	private PeliculaDao peliculaDao;

	@Test
	public void getPeliculaPorId() {
		Pelicula pelicula = peliculaDao.getPeliculaPorId("PEL0001");
		assertEquals("El Cisne Negro", pelicula.getTitulo());
		assertEquals("Drama", pelicula.getGenero());
		assertEquals("d_peliculas/fotos_cartelera/cisne_negro.jpg", pelicula.getImagen());
		assertEquals("Darren Aronofsky.", pelicula.getDirector());
		assertEquals("Natalie Portman, Mila Kunis, Vincent Cassel.", pelicula.getReparto());
		assertEquals(new Integer("1"), pelicula.getEstado());
	}

	@Test
	public void getPeliculasParaCartelera() {
		assertEquals(10, peliculaDao.getPeliculasParaCartelera().size());
	}

	@Test
	public void getTodasPeliculas() {
		assertEquals(11, peliculaDao.getTodasPeliculas().size());
	}
	
	@Test
	@Transactional
	public void agregarPelicula() {
		Pelicula pelicula = new Pelicula("El Aro", "Terror", "synopsis synopsis synopsis", "www.elaro.com", "imagen01",
				"Director1", "Actor 1, Actor 2", 120, "USA", 0, "Mayores 18", "S");
		peliculaDao.agregar(pelicula);

		assertEquals(12, peliculaDao.getTodasPeliculas().size());

	}

	@Test
	@Transactional
	public void modificarEstadoPelicula() {
		{
			Pelicula pelicula = peliculaDao.getPeliculaPorId("PEL0011");
			//cambia de estado creado(0) a estado pendiente d asignar a cartelera(1)
			pelicula.setEstado(new Integer(1));
			peliculaDao.modificar(pelicula);
			assertEquals(new Integer(1), peliculaDao.getPeliculaPorId("PEL0011").getEstado());
		}
		{
			Pelicula pelicula = peliculaDao.getPeliculaPorId("PEL0011");
			//cambia de estado creado(1) a estado asignado a cartelera(2)
			pelicula.setEstado(new Integer(2));
			peliculaDao.modificar(pelicula);
			assertEquals(new Integer(2), peliculaDao.getPeliculaPorId("PEL0011").getEstado());
		}
		{
			Pelicula pelicula = peliculaDao.getPeliculaPorId("PEL0011");
			//cambia de estado en cartelera (2) a estado fuera d cartelera(3)
			pelicula.setEstado(new Integer(3));
			peliculaDao.modificar(pelicula);
			assertEquals(new Integer(3), peliculaDao.getPeliculaPorId("PEL0011").getEstado());
		}
	}

}

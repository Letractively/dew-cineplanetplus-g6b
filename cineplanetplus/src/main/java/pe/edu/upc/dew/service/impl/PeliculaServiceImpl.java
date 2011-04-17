package pe.edu.upc.dew.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.dew.dao.PeliculaDao;
import pe.edu.upc.dew.model.Pelicula;
import pe.edu.upc.dew.service.PeliculaService;

@Service
public class PeliculaServiceImpl implements PeliculaService {
	@Autowired
	private PeliculaDao peliculaDao;

	public void setPeliculaDao(PeliculaDao peliculaDao) {
		this.peliculaDao = peliculaDao;
	}

	public void agregar(Pelicula pelicula) {
		peliculaDao.agregar(pelicula);
	}

	public void modificar(Pelicula pelicula) {
		peliculaDao.modificar(pelicula);
	}

	public Pelicula getPeliculaPorId(String id) {
		return peliculaDao.getPeliculaPorId(id);
	}

	public List<Pelicula> getPeliculasParaCartelera() {
		return peliculaDao.getPeliculasParaCartelera();
	}

	public List<Pelicula> getTodasPeliculas() {
		return peliculaDao.getTodasPeliculas();
	}

	@Override
	public void eliminar(String id) {
		peliculaDao.eliminar(id);
		
	}

}

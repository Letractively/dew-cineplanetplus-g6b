package pe.edu.upc.dew.dao.jdbc;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pe.edu.upc.dew.dao.PeliculaDao;
import pe.edu.upc.dew.model.Pelicula;
import pe.edu.upc.dew.util.Util;

@Repository
public class PeliculaDaoJdbc extends SimpleJdbcDaoSupport implements PeliculaDao {

	public void agregar(Pelicula pelicula) {
		String sql = "insert into pelicula(idPelicula,titulo,genero,synopsis,site,imagen,director,reparto,duracion,pais,estado,publico,subtitulos) values(?,?,?,?,?,?,?,?,?,?,?,?,?);";
		getSimpleJdbcTemplate().update(sql, obtenerCorrelativoId(), pelicula.getTitulo(), pelicula.getGenero(),
				pelicula.getSynopsis(), pelicula.getSite(), pelicula.getImagen(), pelicula.getDirector(),
				pelicula.getReparto(), pelicula.getDuracion(), pelicula.getPais(), pelicula.getEstado(),
				pelicula.getPublico(), pelicula.getSubtitulos());

	}

	public void modificar(Pelicula pelicula) {
		String sql = "UPDATE pelicula SET titulo = ?,genero= ?,synopsis= ?,site= ?,imagen= ?,director= ?,reparto= ?,duracion= ?,pais= ?,estado= ?,publico= ?,subtitulos= ? WHERE  idPelicula =?;";
		getSimpleJdbcTemplate().update(sql, pelicula.getTitulo(), pelicula.getGenero(), pelicula.getSynopsis(),
				pelicula.getSite(), pelicula.getImagen(), pelicula.getDirector(), pelicula.getReparto(),
				pelicula.getDuracion(), pelicula.getPais(), pelicula.getEstado(), pelicula.getPublico(),
				pelicula.getSubtitulos(), pelicula.getIdPelicula());
	}

	private Object obtenerCorrelativoId() {
		String correlativoId = "";
		String sql = "SELECT max(idPelicula) FROM pelicula";
		String codigoMax = getSimpleJdbcTemplate().queryForObject(sql, String.class);
		if (codigoMax == null || codigoMax.equals("")) {
			correlativoId = "PEL0001";
		} else {
			String codigo = codigoMax.substring(3);
			Integer cod = Integer.parseInt(codigo) + 1;
			correlativoId = Util.caracterIzquierda(cod.toString(), 4, "0");
			correlativoId = "PEL" + correlativoId;
		}
		return correlativoId;
	}

	public Pelicula getPeliculaPorId(String id) {
		String sql = "SELECT idPelicula,titulo,genero,synopsis,site,imagen,director,reparto,duracion,pais,estado,publico,subtitulos FROM pelicula WHERE idPelicula = ?";
		Pelicula pelicula = getSimpleJdbcTemplate().queryForObject(sql,
				new BeanPropertyRowMapper<Pelicula>(Pelicula.class), id);
		return pelicula;
	}

	public List<Pelicula> getPeliculasParaCartelera() {
		String sql = "SELECT idPelicula,titulo,genero,synopsis,site,imagen,director,reparto,duracion,pais,estado,publico,subtitulos FROM pelicula WHERE estado = 1";
		return getSimpleJdbcTemplate().query(sql, new BeanPropertyRowMapper<Pelicula>(Pelicula.class));

	}

	public List<Pelicula> getTodasPeliculas() {
		String sql = "SELECT idPelicula,titulo,genero,synopsis,site,imagen,director,reparto,duracion,pais,estado,publico,subtitulos FROM pelicula";
		return getSimpleJdbcTemplate().query(sql, new BeanPropertyRowMapper<Pelicula>(Pelicula.class));
	}

	@Override
	public void eliminar(String idPelicula) {
		getSimpleJdbcTemplate().update("delete from pelicula where idPelicula=?",
				idPelicula);
		
	}

}

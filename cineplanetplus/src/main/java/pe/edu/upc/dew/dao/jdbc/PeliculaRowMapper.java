package pe.edu.upc.dew.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import pe.edu.upc.dew.model.ConsultaPelicula;

public class PeliculaRowMapper implements ParameterizedRowMapper <ConsultaPelicula> {

	@Override
	public ConsultaPelicula mapRow(ResultSet rs, int rowNum) throws SQLException {
		ConsultaPelicula consultaPelicula = new ConsultaPelicula();
		consultaPelicula.setId(rs.getString("id"));
		consultaPelicula.setIdCine(rs.getString("idCine"));
		consultaPelicula.setNombreCine(rs.getString("nombre"));
		consultaPelicula.setIdSala(rs.getString("idSala"));
		consultaPelicula.setDescripcionSala(rs.getString("descripcion"));
		consultaPelicula.setIdHorario(rs.getString("idHorario"));
		
		consultaPelicula.setFechaInicio(rs.getString("fechaInicio"));
		consultaPelicula.setFechaFin(rs.getString("fechaFin"));
		consultaPelicula.setHoraInicio(rs.getString("horaInicio"));
		consultaPelicula.setHoraFin(rs.getString("horaFin"));
		consultaPelicula.setIdPelicula(rs.getString("idPelicula"));		
		consultaPelicula.setTitulo(rs.getString("titulo"));
		consultaPelicula.setGenero(rs.getString("genero"));
		consultaPelicula.setSynopsis(rs.getString("synopsis"));
		consultaPelicula.setSite(rs.getString("site"));
		consultaPelicula.setImagen(rs.getString("imagen"));
		consultaPelicula.setDirector(rs.getString("director"));
		consultaPelicula.setReparto(rs.getString("reparto"));
		consultaPelicula.setDuracion(Integer.parseInt(rs.getString("duracion")));
		consultaPelicula.setPais(rs.getString("pais"));
		consultaPelicula.setEstado(Integer.parseInt(rs.getString("estado")));
		consultaPelicula.setPublico(rs.getString("publico"));
		consultaPelicula.setSubtitulos(rs.getString("subtitulos"));		
		
		return consultaPelicula;
	}

}

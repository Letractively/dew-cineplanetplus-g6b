package pe.edu.upc.dew.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import pe.edu.upc.dew.model.Cine;
import pe.edu.upc.dew.model.FilaAsiento;
import pe.edu.upc.dew.model.Sala;

public class FilaAsientoRowMapper implements ParameterizedRowMapper<FilaAsiento> {

	public FilaAsiento mapRow(ResultSet rs, int rowNum) throws SQLException {
		FilaAsiento filaAsiento = new FilaAsiento();
		Sala sala = new Sala();
		Cine cine = new Cine();
		sala.setIdSala(rs.getString("idSala"));
		sala.setDescripcion(rs.getString("descripcion"));
		cine.setIdCine(rs.getString("idCine"));
		sala.setCine(cine);
		filaAsiento.setIdFilaAsiento(Integer.parseInt(rs.getString("idFilaAsiento")));
		filaAsiento.setCantAsientos(Integer.parseInt(rs.getString("cantAsientos")));
		filaAsiento.setSala(sala);
		return filaAsiento;
	}

}

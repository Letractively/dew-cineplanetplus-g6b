package pe.edu.upc.dew.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import pe.edu.upc.dew.model.FilaAsientoReservado;

public class FilaAsientoReservadoRowMapper implements ParameterizedRowMapper<FilaAsientoReservado> {

	public FilaAsientoReservado mapRow(ResultSet rs, int rowNum) throws SQLException {
		FilaAsientoReservado filaAsientoReservado = new FilaAsientoReservado();
	
		filaAsientoReservado.setIdFilaAsiento(Integer.parseInt(rs.getString("idFilaAsiento")));
		filaAsientoReservado.setNumeroAsiento(Integer.parseInt(rs.getString("numeroAsiento")));
	
		return filaAsientoReservado;
	}

}

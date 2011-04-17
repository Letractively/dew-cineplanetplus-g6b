package pe.edu.upc.dew.dao.jdbc;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import pe.edu.upc.dew.dao.HorarioDao;
import pe.edu.upc.dew.model.Horario;

public class HorarioDaoJdbc extends SimpleJdbcDaoSupport implements HorarioDao {

	public Horario getHorarioPorId(String id) {
		String sql = "SELECT id, horaInicio,horaFin FROM horario WHERE id = ?";
		Horario horario = getSimpleJdbcTemplate().queryForObject(sql,
				new BeanPropertyRowMapper<Horario>(Horario.class), id);
		return horario;
	}

	public void modificar(Horario horario) {
		String sql = "UPDATE horario SET horaInicio = ?, horaFin = ? WHERE id = ?;";
		getSimpleJdbcTemplate().update(sql, horario.getHoraInicio(), horario.getHoraFin(), horario.getId());
	}

	public List<Horario> getHorarios() {
		String sql = "SELECT * FROM horario";
		return getSimpleJdbcTemplate().query(sql, new BeanPropertyRowMapper<Horario>(Horario.class));

	}

}

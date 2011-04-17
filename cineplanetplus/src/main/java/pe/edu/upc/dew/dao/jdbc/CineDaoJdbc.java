package pe.edu.upc.dew.dao.jdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pe.edu.upc.dew.dao.CineDao;
import pe.edu.upc.dew.model.Cine;

@Repository
public class CineDaoJdbc extends SimpleJdbcDaoSupport implements CineDao {

	public Cine getCinePorId(String id) {
		String sql = "SELECT * FROM cine WHERE idCine = ?";
		Cine cine = getSimpleJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<Cine>(Cine.class), id);
		return cine;
	}

	public void agregar(Cine cine) {
		// TODO Auto-generated method stub

	}

}

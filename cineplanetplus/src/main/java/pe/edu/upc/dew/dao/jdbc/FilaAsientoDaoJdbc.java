package pe.edu.upc.dew.dao.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import pe.edu.upc.dew.dao.FilaAsientoDao;
import pe.edu.upc.dew.model.FilaAsiento;

public class FilaAsientoDaoJdbc extends SimpleJdbcDaoSupport implements FilaAsientoDao {

	@SuppressWarnings("deprecation")
	public List<FilaAsiento> getFilasPorSala(String idSala) {
		List<FilaAsiento>  filas = new ArrayList<FilaAsiento>();
		 String sql = "select f.idSala, s.idCine, s.descripcion,  f.idFilaAsiento ,f.cantAsientos "
             + "from filaasiento f , sala s where s.idSala = f.idSala and f.idSala =?";
		filas = getSimpleJdbcTemplate().query(sql, new FilaAsientoRowMapper(), idSala); 
		return filas;
	}

}

package pe.edu.upc.dew.dao.jdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pe.edu.upc.dew.dao.SalaDao;
import pe.edu.upc.dew.model.Sala;
@Repository
public class SalaDaoJdbc extends SimpleJdbcDaoSupport implements SalaDao
{
    @Override
    public Sala getSalaPorId(String id)
    {
        String sql = "SELECT * FROM sala WHERE idSala = ?";
        Sala sala = getSimpleJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<Sala>(Sala.class), id);
        return sala;
    }

    @Override
    public void agregar(Sala sala)
    {
        // TODO Auto-generated method stub

    }

}

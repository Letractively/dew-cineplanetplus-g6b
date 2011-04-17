package pe.edu.upc.dew.dao.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pe.edu.upc.dew.dao.PerfilDao;
import pe.edu.upc.dew.model.Opcion;
import pe.edu.upc.dew.model.Perfil;
import pe.edu.upc.dew.util.Util;

@Repository
public class PerfilDaoJdbc extends SimpleJdbcDaoSupport implements PerfilDao {

	public Perfil getPerfilPorId(String idPerfil) {
		String sql = "SELECT id, nombre,estado ,vigencia FROM perfil WHERE id = ?";
		Perfil vehicle = getSimpleJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<Perfil>(Perfil.class),
				idPerfil);
		return vehicle;
	}

	public List<Perfil> getPerfiles() {
		return null;
	}

	public List<Opcion> getOpciones(Perfil perfil) {
		return getSimpleJdbcTemplate()
				.query("select o.id,o.descripcion,o.estado from opcion o, opcionperfil op where o.id=op.idOpcion  and op.idPerfil=?",
						new BeanPropertyRowMapper<Opcion>(Opcion.class), perfil.getId());
	}

	public void eliminar(String idPerfil) {
		// TODO Auto-generated method stub

	}

	public void agregar(Perfil perfil) {
		String sql = "insert into perfil(id,nombre,estado,vigencia) values(?,?,?,?);";
		getSimpleJdbcTemplate().update(sql, obtenerCorrelativoId(), perfil.getNombre(), perfil.getEstado(),
				perfil.getVigencia());

	}

	public void actualizar(Perfil perfil) {
		// TODO Auto-generated method stub

	}

	public void asignarOpcionPerfil(Perfil perfil, List<Opcion> opciones) {
		String sql = "insert into opcionperfil(idPerfil,idOpcion) values(?,?);";

		List<Object[]> parameters = new ArrayList<Object[]>();

		for (Opcion opcion : opciones) {
			parameters.add(new Object[] { perfil.getId(), opcion.getId() });
		}
		getSimpleJdbcTemplate().batchUpdate(sql, parameters);

	}

	public String obtenerCorrelativoId() {
		String correlativoId = "";
		String sql = "SELECT max(id) FROM perfil";
		String codigoMax = getSimpleJdbcTemplate().queryForObject(sql, String.class);
		if (codigoMax == null || codigoMax.equals("")) {
			correlativoId = "P01";
		} else {
			String codigo = codigoMax.substring(1);
			Integer cod = Integer.parseInt(codigo) + 1;
			correlativoId = Util.caracterIzquierda(cod.toString(), 2, "0");
			correlativoId = "P" + correlativoId;
		}
		return correlativoId;
	}

}

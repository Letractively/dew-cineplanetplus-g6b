package pe.edu.upc.dew.dao.jdbc;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pe.edu.upc.dew.dao.UsuarioDao;
import pe.edu.upc.dew.model.Opcion;
import pe.edu.upc.dew.model.Perfil;
import pe.edu.upc.dew.model.Usuario;
import pe.edu.upc.dew.util.Util;

@Repository
public class UsuarioDaoJdbc extends SimpleJdbcDaoSupport implements UsuarioDao {

	@SuppressWarnings("deprecation")
	@Override
	public Usuario getUsuarioPorId(String idUsuario) {

		String sql = "select u.idUsuario ,u.username , u.passw , u.apePaterno,u.apeMaterno,u.nombre nombres,u.direccion,u.estado estadoUsu, p.id,p.nombre descripcion,p.estado,p.vigencia "
				+ "from Usuario u left join Perfil p on u.idPerfil= p.id where u.idUsuario =?";
		Usuario usuario = getSimpleJdbcTemplate().queryForObject(sql,
				new UsuarioRowMapper(), idUsuario);
		return usuario;
	}

	@Override
	public Usuario getUsuarioPorUsername(String username) {
		return getSimpleJdbcTemplate()
				.queryForObject(
						"select username, passw, apePaterno,apeMaterno,nombre from Usuario where username=?",
						new BeanPropertyRowMapper<Usuario>(Usuario.class),
						username);
	}

	@Override
	public List<Usuario> getUsuarios() {
		return getSimpleJdbcTemplate()
				.query("select username, passw, apePaterno,apeMaterno,nombre from Usuario",
						new BeanPropertyRowMapper<Usuario>(Usuario.class));
	}

	@Override
	public List<Usuario> getUsuariosPorNombre(String nombre) {
		return getSimpleJdbcTemplate().query(
				"select username, passw, nombre from Usuario where nombre=?",
				new BeanPropertyRowMapper<Usuario>(Usuario.class), nombre);
	}

	@Override
	public void agregar(Usuario usuario) {
		String sql = "insert into usuario(idUsuario,nombre,apePaterno,apeMaterno,username, passw, direccion,idPerfil) values(?,?,?,?,?,?,?,?);";
		getSimpleJdbcTemplate().update(sql, obtenerCorrelativoId(),
				usuario.getNombre(), usuario.getApePaterno(),
				usuario.getApeMaterno(), usuario.getUsername(),
				usuario.getPassw(), usuario.getDireccion(),
				usuario.getPerfil().getId());
	}

	@Override
	public void eliminar(String idUsuario) {
		getSimpleJdbcTemplate().update("delete from usuario where idUsuario=?",
				idUsuario);
	}

	@Override
	public void actualizarPassword(Usuario usuario) {
		String sql = "update usuario set passw = ? where idUsuario = ?;";
		getSimpleJdbcTemplate().update(sql, usuario.getPassw(),
				usuario.getIdUsuario());

	}

	@Override
	public Perfil obtenerPerfil(String idUsuario) {
		return getSimpleJdbcTemplate()
				.queryForObject(
						"select p.id,p.nombre,p.estado,p.vigencia from Usuario u,Perfil p where u.idPerfil= p.id and u.idUsuario=?",
						new BeanPropertyRowMapper<Perfil>(Perfil.class),
						idUsuario);
	}

	@Override
	public List<Opcion> obtenerOpcionesPerfil(Usuario usuario) {
		return getSimpleJdbcTemplate()
				.query("select o.id,o.descripcion,o.estado from opcion o, opcionperfil op where o.id=op.idOpcion  and op.idPerfil=?",
						new BeanPropertyRowMapper<Opcion>(Opcion.class),
						usuario.getPerfil().getId());
	}

	public String obtenerCorrelativoId() {
		String correlativoId = "";
		String sql = "SELECT max(idUsuario) FROM usuario";
		String codigoMax = getSimpleJdbcTemplate().queryForObject(sql,
				String.class);
		if (codigoMax == null || codigoMax.equals("")) {
			correlativoId = "USU00000001";
		} else {
			String codigo = codigoMax.substring(3);
			Integer cod = Integer.parseInt(codigo) + 1;
			correlativoId = Util.caracterIzquierda(cod.toString(), 8, "0");
			correlativoId = "USU" + correlativoId;
		}
		return correlativoId;
	}

	@Override
	public Usuario getUsuario(String username, String clave) {
		Usuario usuario = null;
		try {		                 
			String sql = "select u.idUsuario ,u.username , u.passw , u.apePaterno,u.apeMaterno,u.nombre nombres,u.direccion,u.estado estadoUsu, p.id,p.nombre descripcion,p.estado,p.vigencia "
					+ "from Usuario u left join Perfil p on u.idPerfil= p.id where u.username =? and u.passw = ?";
			return usuario = getSimpleJdbcTemplate().queryForObject(sql,
					new UsuarioRowMapper(), username, clave);
		} catch (DataAccessException e) {
			return usuario;
		}

	}

	@Override
	public void actualizar(Usuario usuario) {

		String sql = "update usuario set nombre = ? , apePaterno = ?, apeMaterno = ?, username =?, passw=?, idPerfil=?, direccion = ? where idUsuario = ?;";

		getSimpleJdbcTemplate().update(sql, usuario.getNombre(),
				usuario.getApePaterno(), usuario.getApeMaterno(),
				usuario.getUsername(), usuario.getPassw(),
				usuario.getPerfil().getId(), usuario.getDireccion(),
				usuario.getIdUsuario());

	}

}

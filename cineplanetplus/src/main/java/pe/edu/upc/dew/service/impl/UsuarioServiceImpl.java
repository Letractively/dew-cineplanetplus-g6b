package pe.edu.upc.dew.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.dew.dao.UsuarioDao;
import pe.edu.upc.dew.model.Opcion;
import pe.edu.upc.dew.model.Perfil;
import pe.edu.upc.dew.model.Usuario;
import pe.edu.upc.dew.service.UsuarioService;
@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	UsuarioDao usuarioDao;
	
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@Override
	public Usuario getUsuarioPorId(String idUsuario) {
		return usuarioDao.getUsuarioPorId(idUsuario);
	}

	@Override
	public Usuario getUsuarioPorUsername(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario getUsuario(String username, String clave) {
		Usuario usuario = usuarioDao.getUsuario(username, clave);
		return usuario;
	}

	@Override
	public List<Usuario> getUsuarios() {
		return usuarioDao.getUsuarios();
	}

	@Override
	public List<Usuario> getUsuariosPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(String idUsuario) {
		usuarioDao.eliminar(idUsuario);
	}

	@Override
	public void agregar(Usuario usuario) {
		usuarioDao.agregar(usuario);

	}

	@Override
	public void actualizar(Usuario usuario) {
		usuarioDao.actualizar(usuario);

	}

	@Override
	public Perfil obtenerPerfil(String idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Opcion> obtenerOpcionesPerfil(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}

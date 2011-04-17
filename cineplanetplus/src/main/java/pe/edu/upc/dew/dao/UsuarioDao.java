package pe.edu.upc.dew.dao;

import java.util.List;

import pe.edu.upc.dew.model.Opcion;
import pe.edu.upc.dew.model.Perfil;
import pe.edu.upc.dew.model.Usuario;



public interface UsuarioDao {

	Usuario getUsuarioPorId(String idUsuario);
	
	Usuario getUsuarioPorUsername(String string);
	
	Usuario getUsuario(String username, String clave);

	List<Usuario> getUsuarios();

	List<Usuario> getUsuariosPorNombre(String nombre);

	void eliminar(String idUsuario);
	
	void agregar(Usuario usuario);
	
	void actualizar(Usuario usuario);

	void actualizarPassword(Usuario usuario);	

	Perfil obtenerPerfil(String idUsuario);
	
	List<Opcion> obtenerOpcionesPerfil(Usuario usuario);

}

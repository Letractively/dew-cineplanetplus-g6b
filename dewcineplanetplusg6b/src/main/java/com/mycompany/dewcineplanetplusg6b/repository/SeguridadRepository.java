package com.mycompany.dewcineplanetplusg6b.repository;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.dewcineplanetplusg6b.model.Opcion;
import com.mycompany.dewcineplanetplusg6b.model.Perfil;
import com.mycompany.dewcineplanetplusg6b.model.Usuario;

public class SeguridadRepository {
	List<Opcion> opcionesAdm = new ArrayList<Opcion>();
	List<Opcion> opcionesUser = new ArrayList<Opcion>();
	List<Perfil> perfiles = new ArrayList<Perfil>();
	
	// List<Usuario> usuarios = new ArrayList<Perfil>();

	public SeguridadRepository() {
		super();
		initData();
	}

	private void initData() {

		Opcion opcion1 = new Opcion("001", "Mantenimiento", "A");
		Opcion opcion2 = new Opcion("002", "Consultas", "A");
		Opcion opcion3 = new Opcion("003", "Reportes", "A");
		Opcion opcion4 = new Opcion("004", "Seguridad", "A");

		opcionesAdm.add(opcion1);
		opcionesAdm.add(opcion2);
		opcionesAdm.add(opcion3);
		opcionesAdm.add(opcion4);

		opcionesUser.add(opcion1);
		opcionesUser.add(opcion2);

		Perfil perfil1 = new Perfil("001", "Admin", "Administrador",
				opcionesAdm);
		Perfil perfil2 = new Perfil("002", "User", "Usuario", opcionesUser);
		// Perfil perfil3 = new Perfil("003", "Inv", "Invitado",opcionesAdm);

		perfiles.add(perfil1);
		perfiles.add(perfil2);

	}

	public Perfil obtenerPerfil(String codigo) {
		for (Perfil element : perfiles) {
			if(element.getCodigo().equals(codigo)){
				return element;
			}
		}
		return null;
	}

	public int asignarPerfilUsuario(Usuario usuario, Perfil perfil) {
		
		List<Perfil> perfiles = usuario.getPerfiles();
		
		if(perfiles.contains(perfil)){			
			return 0;
		}
		else{
			perfiles.add(perfil);				
			usuario.setPerfiles(perfiles);
			return 1;
		}
	}
	
	

}

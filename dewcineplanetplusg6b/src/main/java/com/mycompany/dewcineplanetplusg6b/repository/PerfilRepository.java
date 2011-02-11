package com.mycompany.dewcineplanetplusg6b.repository;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.dewcineplanetplusg6b.model.Perfil;

public class PerfilRepository {
	
	List<Perfil> perfiles = new ArrayList<Perfil>();
	
	public PerfilRepository() {
		super();
		initData();

	}
	
	public void initData(){		
		Perfil perfil1 = new Perfil("001", "Admin", "Administrador");
		Perfil perfil2 = new Perfil("002", "User", "Usuario");
		Perfil perfil3 = new Perfil("003", "Inv", "Invitado");

		perfiles.add(perfil1);
		perfiles.add(perfil2);
		perfiles.add(perfil3);
	}	



	public List<Perfil> obtenerPerfiles() {
		return perfiles;
	}

	public Perfil obtenerPerfil(String codigo) {
		
		for (Perfil element : perfiles) {
			if(element.getCodigo().equals(codigo)){
				return element;
			}
		}
		return null;
	}

	public int agregarPerfil(Perfil perfil1) {
		if(perfiles.contains(perfil1)){			
			return 0;
		}
		else{
			perfiles.add(perfil1);
			return 1;
		}
	}
	
	

}

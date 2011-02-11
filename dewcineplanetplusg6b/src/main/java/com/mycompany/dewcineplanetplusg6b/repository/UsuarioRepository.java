package com.mycompany.dewcineplanetplusg6b.repository;

import com.mycompany.dewcineplanetplusg6b.model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository
{
    private List<Usuario> usuarios = new ArrayList<Usuario>();;

	public void initData(){
           usuarios.add(new Usuario("001","Carla","Ayala","Tejada","CarAyala","Car001","Rep panama 6380","Visitante"));
           usuarios.add(new Usuario("002","Carlos","Cruz","Muñoz","CarCruz","Car002","Rep panama 6340","Visitante"));
           usuarios.add(new Usuario("003","Karla","Villena","Tejada","KarVillena","Kar003","Mexico 80","Visitante"));
	}

	public UsuarioRepository()
        {
		super();
		initData();
	}

    List<Usuario> obtenerTodosUsuarios()
    {
            return usuarios;
    }

	public Usuario obtenerPerfil(String codigo) {

		for (Usuario element : usuarios)
                {
			if(element.getIdUsuario().equals(codigo))
                        {
				return element;
			}
		}
		return null;
	}

	public int registrar(String  usuario,String password)
        {
			usuarios.add(new Usuario(usuario,password));
			return 1;
	}
}
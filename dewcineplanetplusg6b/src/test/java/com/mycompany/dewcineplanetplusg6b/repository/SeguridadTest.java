package com.mycompany.dewcineplanetplusg6b.repository;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;
import com.mycompany.dewcineplanetplusg6b.model.Opcion;
import com.mycompany.dewcineplanetplusg6b.model.Perfil;
import com.mycompany.dewcineplanetplusg6b.model.Usuario;

public class SeguridadTest {
	SeguridadRepository seguridadRepository = new SeguridadRepository();
	UsuarioRepository usuarioRepository = new UsuarioRepository();

	@Test
	public void asignarPerfilUsuario() {
		Usuario usuario = new Usuario("001", "Jose", "Villanes", "Corrales",
				"jose", "123", "Direccion 1", "Admin");
		{
			// Perfil a asignar sera de un adm
			//Perfiles y opciones estan preconfigurados en SeguridadRepository
			Perfil perfilAdm = seguridadRepository.obtenerPerfil("001");
			// se comprueba si se efectuo la asignacion(0: No, 1 : SI)
			assertEquals(1, seguridadRepository.asignarPerfilUsuario(usuario,
					perfilAdm));
			// se comprueba que el usuario tenga en efecto el perfil y las
			// opciones asignadas
			List<Perfil> perfiles = usuario.getPerfiles();

			Perfil perfil = perfiles.get(0);
			assertEquals("Admin", perfil.getNombre());

			List<Opcion> opciones = perfil.getOpciones();
			Opcion opcion = opciones.get(0);
			assertEquals(4, opciones.size());
			assertEquals("Mantenimiento", opcion.getNombre());
		}
		{
			// Si se quiere asignar otra vez mismo perfil no se podra
			Perfil perfilAdm = seguridadRepository.obtenerPerfil("001");
			assertEquals(0, seguridadRepository.asignarPerfilUsuario(usuario,
					perfilAdm));
		}

	}

}

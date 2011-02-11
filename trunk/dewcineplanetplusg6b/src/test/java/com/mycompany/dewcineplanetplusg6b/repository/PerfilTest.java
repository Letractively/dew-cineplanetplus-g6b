package com.mycompany.dewcineplanetplusg6b.repository;

import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;
import com.mycompany.dewcineplanetplusg6b.model.Perfil;

public class PerfilTest {
	PerfilRepository perfilRepository = new PerfilRepository();

	@Test
	public void obtenerPerfiles() {
		List<Perfil> perfiles = perfilRepository.obtenerPerfiles();
		assertTrue(perfiles.size() > 0);
	}

	@Test
	public void obtenerPerfil() {
		{
			Perfil perfil = perfilRepository.obtenerPerfil("001");
			assertEquals("Admin", perfil.getNombre());
			assertEquals("Administrador", perfil.getDescripcion());
		}
		{
			Perfil perfil = perfilRepository.obtenerPerfil("xxx");
			assertNull(perfil);
		}
	}

	@Test
	public void agregarPerfil() {

		List<Perfil> perfiles = perfilRepository.obtenerPerfiles();
		int cant = perfiles.size();
		{
			Perfil perfil1 = new Perfil("004", "Otro", "OtroPerfil");
			assertEquals(1, perfilRepository.agregarPerfil(perfil1));
			assertEquals(cant + 1, perfiles.size());
		}
		{
			Perfil perfil1 = new Perfil("001", "Admin", "Administrador");
			assertEquals(0, perfilRepository.agregarPerfil(perfil1));
		}

	}

}

package pe.edu.upc.dew.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import pe.edu.upc.dew.model.Perfil;
import pe.edu.upc.dew.model.Usuario;
import pe.edu.upc.dew.service.UsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:pe/edu/upc/dew/test-infrastructure-config.xml" })
public class UsuarioServiceImplTest {
	@Autowired
	private UsuarioService usuarioService;

	@Test
	public void testAutentificacion() {
		{// login exitoso
			Usuario usuario = usuarioService.getUsuario("jvillanes", "1234");
			assertEquals("Jose", usuario.getNombre());
		}
		{// si no esta registrado
			Usuario usuario = usuarioService.getUsuario("usuario", "clave");
			Assert.isNull(usuario);

		}
	}

	@Test
	public void getUsuarios() {
		assertEquals(19, usuarioService.getUsuarios().size());
	}

	@Test
	@Transactional
	public void agregarUsuario() {
		{// con perfil
			Perfil perfil = new Perfil();
			perfil.setId("P03");
			Usuario usuario = new Usuario("Raul", "Romero", "Ponce", "rromero",
					"123", "Direccion 1", perfil);
			usuarioService.agregar(usuario);
			assertEquals(20, usuarioService.getUsuarios().size());
		}
		// sin perfil
		/*
		 * {
		 * 
		 * Usuario usuario = new Usuario("Raul", "Romero", "Ponce", "rromero",
		 * "123", "Direccion 1",null); usuarioService.agregar(usuario);
		 * assertEquals(20, usuarioService.getUsuarios().size()); }
		 */
	}

	@Test
	@Transactional
	public void eliminarUsuario() {
		usuarioService.eliminar("USU00000019");
		try {
			assertEquals(18, usuarioService.getUsuarios().size());
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}

	@Test
	@Transactional
	public void modificarUsuario() {
		Usuario usuario = usuarioService.getUsuarioPorId("USU00000019");
		assertEquals("Rafael", usuario.getNombre());
		usuario.setDireccion("Direccion XXXXX");
		usuario.setNombre("Carlos");
		usuarioService.actualizar(usuario);

		Usuario usuarioAct = usuarioService.getUsuarioPorId("USU00000019");
		assertEquals("Carlos", usuarioAct.getNombre());
		assertEquals("Direccion XXXXX", usuarioAct.getDireccion());

	}

}

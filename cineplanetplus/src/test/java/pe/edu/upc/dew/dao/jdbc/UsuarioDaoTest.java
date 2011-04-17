package pe.edu.upc.dew.dao.jdbc;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.dew.dao.PerfilDao;
import pe.edu.upc.dew.dao.UsuarioDao;
import pe.edu.upc.dew.model.Opcion;
import pe.edu.upc.dew.model.Perfil;
import pe.edu.upc.dew.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:pe/edu/upc/dew/test-infrastructure-config.xml" })
public class UsuarioDaoTest
{
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private PerfilDao perfilDao;

    @Test
    public void testGetUsuarioPorUsername()
    {
        Usuario usuario = usuarioDao.getUsuarioPorUsername("asanz");
        assertEquals("Alex", usuario.getNombre());
        assertEquals("Sanz Arq", usuario.getApePaterno()+" "+usuario.getApeMaterno());
        
    }

    @Test
    public void testGetUsuarioPorId()
    {
        Usuario usuario = usuarioDao.getUsuarioPorId("USU00000002");
        assertEquals("Jose", usuario.getNombre());
    }
    
    @Test
    public void testGetUsuarioPorUsernameClave()
    {
        Usuario usuario = usuarioDao.getUsuario("jvillanes", "1234");
        assertEquals("Jose", usuario.getNombre());
    }

    @Test
    public void testGetUsuarios()
    {
        List<Usuario> usuarios = usuarioDao.getUsuarios();
        assertEquals(19, usuarios.size());
    }

    @Test @Transactional
    public void testAgregar()
    {       
        Perfil perfil = perfilDao.getPerfilPorId("P03");        
        Usuario usuario = new Usuario("Raul", "Romero", "Corrales", "rromero", "123", "Direccion 1", perfil);        
        usuarioDao.agregar(usuario);
        
        List<Usuario> usuarios = usuarioDao.getUsuarios();
        assertEquals(20, usuarios.size());
        assertEquals("Romero", usuarioDao.getUsuarioPorUsername("rromero").getApePaterno());
    }
  

    @Test @Transactional
    public void testEliminar()
    {
        usuarioDao.eliminar("USU00000019");
        try
        {
            List<Usuario> usuarios = usuarioDao.getUsuarios();
            assertEquals(18, usuarios.size());
            
        	Usuario user = usuarioDao.getUsuarioPorId("USU00000019");
            Assert.assertNull(user);
            Assert.fail();
        }
        catch (EmptyResultDataAccessException e)
        {
            // OK!
        }
    }
    /*
    @Test @Transactional
    public void testActualizarPassword()
    {        
        Usuario usuario = usuarioDao.getUsuarioPorId("USU00000001"); 
        //assertEquals("1234",usuario.getPassw());  
        usuario.setPassw("123456xxx");
        usuarioDao.actualizarPassword(usuario);
        assertEquals("123456xxx", usuarioDao.getUsuarioPorId("USU00000001").getPassw());

    }
    */
    
    @Test
    public void getPerfilUsuario()
    {
        Perfil perfil = usuarioDao.obtenerPerfil("USU00000001");
        Assert.assertEquals("Administrador", perfil.getNombre());
    }
    
    
    @Test
    public void getOpcionesUsuario()
    {        
        Usuario usuario = usuarioDao.getUsuarioPorId("USU00000001");        
        List<Opcion> opciones = usuarioDao.obtenerOpcionesPerfil(usuario);    
         
        assertEquals("Mantenimiento", opciones.get(0).getDescripcion());
        assertEquals("A", opciones.get(0).getEstado());
        
        assertEquals("Consulta", opciones.get(1).getDescripcion());
        assertEquals("A", opciones.get(1).getEstado());
    }

}

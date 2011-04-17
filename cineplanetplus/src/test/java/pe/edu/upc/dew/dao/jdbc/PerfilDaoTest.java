package pe.edu.upc.dew.dao.jdbc;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.dew.dao.PerfilDao;
import pe.edu.upc.dew.model.Opcion;
import pe.edu.upc.dew.model.Perfil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:pe/edu/upc/dew/test-infrastructure-config.xml" })
public class PerfilDaoTest
{
    @Autowired
    private PerfilDao perfilDao;

    private String perfilCodigo;

    @Before
    public void setUp() throws Exception
    {
        perfilCodigo = perfilDao.obtenerCorrelativoId();
    }


    @Test
    public void obtenerCorrelativo()
    {
        assertEquals(perfilCodigo, perfilDao.obtenerCorrelativoId());

    }
    
    @Test @Transactional
    public void agregarPerfil()
    {
        Perfil perfil = new Perfil();
        perfil.setNombre("Administrador");
        perfil.setEstado("A");
        perfilDao.agregar(perfil);
        assertEquals("Administrador", perfilDao.getPerfilPorId(perfilCodigo).getNombre());

    }


    @Test @Transactional
	public void asignarOpcionesAPerfil()
    {
        Perfil perfil = new Perfil();
        perfil.setNombre("Administrador");
        perfil.setEstado("A");
        perfilDao.agregar(perfil);
    	
        Perfil perfilTest = perfilDao.getPerfilPorId( "P04");
        List<Opcion> opciones = new ArrayList<Opcion>();
        {
            Opcion opcion = new Opcion();
            opcion.setId("01");
            opciones.add(opcion);
        }
        {
            Opcion opcion = new Opcion();
            opcion.setId("02");
            opciones.add(opcion);
        }
        
        perfilDao.asignarOpcionPerfil(perfilTest, opciones);
        
        assertEquals(2, perfilDao.getOpciones(perfilTest).size());

    }

}

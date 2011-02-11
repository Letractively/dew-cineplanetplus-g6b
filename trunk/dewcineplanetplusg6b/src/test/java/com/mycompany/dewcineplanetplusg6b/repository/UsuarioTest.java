//El usuario no registrado puede registrarse en la web para poder hacer
//acreedor a muchos beneficios, comentar, recibir promociones, entre otras cosas.

package com.mycompany.dewcineplanetplusg6b.repository;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

import com.mycompany.dewcineplanetplusg6b.model.AutenticadorSMTP;
import com.mycompany.dewcineplanetplusg6b.model.Usuario;
  

public class UsuarioTest {
	UsuarioRepository  usuarioRepository = new UsuarioRepository();
	List<Usuario> usuarios = usuarioRepository.obtenerTodosUsuarios();
	   
	
	@Test
	public void obtenerUsuarios(){
		
			assertTrue (usuarios.size()>0);
			/*for(int i=0; i<usuarios.size();i++){
				assertEquals("I", usuarios.get(i).getTipoUsuario());
				break;
			}*/
			//assertEquals("I", usuarios.get(0).getTipoUsuario());
	}
	
	@Test
	public void registrarUsuario(){
		String usuario;
		String password;
		usuario = "u4";
		password = "123";
		assertEquals(1,usuarioRepository.registrar(usuario,password));
	}
	
	@Test
	public void validarDatos(){
	
		String user;
		String password;
		int intentos;
	    user = "u2";
		password = "321";
		intentos = 0;
       for(int i=0; i<=3;i++){
			for (Usuario usuario : usuarios) {
				if(user == usuario.getNombre()||password == usuario.getPassw())
                                {
				    	 intentos += 1;
				    }
				    	if(intentos == 3){
				    	break;
				    	}
					  }
	                }
       assertEquals(0,intentos);
	}

}
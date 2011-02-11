package com.mycompany.dewcineplanetplusg6b.model;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class AutenticadorSMTP extends Authenticator
{
	String usuario,clave;
	 
	 public AutenticadorSMTP(String u, String c)
         {
	  usuario=u;
	  clave=c;
	 }
	 
	 public PasswordAuthentication getPasswordAuthentication()
            {
	        return new PasswordAuthentication(usuario, clave);
            }
}
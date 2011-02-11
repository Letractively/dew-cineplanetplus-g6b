package com.mycompany.dewcineplanetplusg6b.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String idUsuario;

	private String nombre;

	private String apePaterno;

	private String apeMaterno;

	private String username;

	private String passw;

	private String direccion;

	private String tipo;	
	
	private List<Perfil> perfiles = new ArrayList<Perfil>();
	
	
	

	public Usuario(String idUsuario, String nombre, String apePaterno,
			String apeMaterno, String username, String passw, String direccion,
			String tipo, List<Perfil> perfiles) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apePaterno = apePaterno;
		this.apeMaterno = apeMaterno;
		this.username = username;
		this.passw = passw;
		this.direccion = direccion;
		this.tipo = tipo;
		this.perfiles = perfiles;
	}

	public Usuario(String idUsuario, String nombre, String apePaterno,
			String apeMaterno, String username, String passw, String direccion,
			String tipo) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apePaterno = apePaterno;
		this.apeMaterno = apeMaterno;
		this.username = username;
		this.passw = passw;
		this.direccion = direccion;
		this.tipo = tipo;
	}

        public Usuario(String username, String passw) 
        {
		super();
		this.username = username;
		this.passw = passw;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApePaterno() {
		return apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	public String getApeMaterno() {
		return apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassw() {
		return passw;
	}

	public void setPassw(String passw) {
		this.passw = passw;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Perfil> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(List<Perfil> perfiles) {
		this.perfiles = perfiles;
	}
	
	
}

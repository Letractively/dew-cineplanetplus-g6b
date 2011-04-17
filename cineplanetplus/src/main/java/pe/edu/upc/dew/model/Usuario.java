package pe.edu.upc.dew.model;

import java.io.Serializable;
public class Usuario implements Serializable {

	private static final long serialVersionUID = -128581427662706728L;

	private String idUsuario;

	private String nombre;

	private String apePaterno;

	private String apeMaterno;

	private String username;

	private String passw;

	private String direccion;
	
	private String estado;

	private Perfil perfil;

	public Usuario() {
	}

	public Usuario(String idUsuario, String nombre, String apePaterno, String apeMaterno, String username,
			String passw, String direccion, Perfil perfil) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apePaterno = apePaterno;
		this.apeMaterno = apeMaterno;
		this.username = username;
		this.passw = passw;
		this.direccion = direccion;
		this.perfil = perfil;
	}

	public Usuario(String nombre, String apePaterno, String apeMaterno, String username, String passw,
			String direccion, Perfil perfil) {
		super();
		this.nombre = nombre;
		this.apePaterno = apePaterno;
		this.apeMaterno = apeMaterno;
		this.username = username;
		this.passw = passw;
		this.direccion = direccion;
		this.perfil = perfil;
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

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
}

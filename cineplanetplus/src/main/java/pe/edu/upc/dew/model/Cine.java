package pe.edu.upc.dew.model;

import java.util.List;

public class Cine implements java.io.Serializable {

	private static final long serialVersionUID = -587891474889402364L;
	private String idCine;
	private String nombre;
	private String direccion;
	private String telefono;

	private List<Sala> salas;

	public Cine() {
	}

	public Cine(String idCine, String nombre, String direccion, String telefono) {
		super();
		this.idCine = idCine;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public Cine(String idCine, String nombre, String direccion, String telefono, List<Sala> salas) {
		super();
		this.idCine = idCine;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.salas = salas;
	}

	public String getIdCine() {
		return idCine;
	}

	public void setIdCine(String idCine) {
		this.idCine = idCine;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Sala> getSalas() {
		return salas;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}

}

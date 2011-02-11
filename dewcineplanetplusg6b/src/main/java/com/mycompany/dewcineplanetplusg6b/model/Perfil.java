package com.mycompany.dewcineplanetplusg6b.model;

import java.util.List;

public class Perfil {
	private String codigo;
	private String nombre;
	private String descripcion;
	
	private List<Opcion> opciones;

	public Perfil(String codigo, String nombre, String descripcion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Perfil(String codigo, String nombre, String descripcion,
			List<Opcion> opcionesAdm) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.opciones = opcionesAdm;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
    public List<Opcion> getOpciones() {
		return opciones;
	}

	public void setOpciones(List<Opcion> opciones) {
		this.opciones = opciones;
	}

	public boolean equals(Object object) {
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

}

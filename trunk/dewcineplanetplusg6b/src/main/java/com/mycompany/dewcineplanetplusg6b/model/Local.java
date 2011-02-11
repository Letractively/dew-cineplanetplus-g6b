package com.mycompany.dewcineplanetplusg6b.model;

public class Local {
	private String codigo;
	private String nombre;
	private String lugar;
	
	public Local(String codigo, String nombre, String lugar) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.lugar = lugar;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo (String val) {
        this.codigo = val;
    }
	
	public String getNombre() {
		
		return nombre;
	}
	public void setNombre (String val) {
        this.nombre = val;
    }

}

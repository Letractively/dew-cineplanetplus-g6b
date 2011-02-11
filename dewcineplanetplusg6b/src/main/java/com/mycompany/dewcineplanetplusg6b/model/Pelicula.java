package com.mycompany.dewcineplanetplusg6b.model;

public class Pelicula {
	
	private String nombre;
	private String sala;
	private String merchandising;
	private String estado;
	
	public Pelicula(String nombre, String sala,String merchandising, String estado) {
		this.nombre = nombre;
		this.sala = sala;
		this.merchandising = merchandising;
		this.estado = estado;
	}
    public String getNombre() {
		
		return nombre;
	}
	public void setNombre (String val) {
        this.nombre = val;
    }
    public String getSala() {
		
		return sala;
	}
	public void setSala (String val) {
        this.sala = val;
    }
	
	public String getMerchandising() {
		
		return merchandising;
	}
	public void setMerchandising (String val) {
        this.merchandising = val;
    }
	
   public String getEstado() {
		
		return estado;
	}
	public void setEstado (String val) {
        this.estado = val;
    }


}

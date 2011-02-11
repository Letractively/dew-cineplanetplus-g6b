package com.mycompany.dewcineplanetplusg6b.model;

public class Sala {

	private String sala;
	private String fila;
	private String codbutaca;
	private String estado;
	
	public Sala(String sala, String fila, String codbutaca, String estado) {
		this.sala = sala;
		this.fila = fila;
		this.codbutaca = codbutaca;
		this.estado = estado;
	}
	
	public String getSala() {
		return sala;
	}
	public void setSala (String val) {
        this.sala = val;
    }
	
	public String getFila() {
		return fila;
	}
	public void setFila (String val) {
        this.fila = val;
    }
	
	public String getCodButaca() {
		return codbutaca;
	}
	public void setCodButaca (String val) {
        this.codbutaca = val;
    }
	
	public String getEstado() {
		return estado;
	}
	public void setEstado (String val) {
        this.estado = val;
    }
	
	

}

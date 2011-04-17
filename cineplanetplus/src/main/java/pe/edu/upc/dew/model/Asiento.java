package pe.edu.upc.dew.model;

import java.io.Serializable;

public class Asiento implements Serializable {

	private static final long serialVersionUID = 6618651177966400682L;
	private Integer numero;
	private Sala sala;
	private String estado;

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}

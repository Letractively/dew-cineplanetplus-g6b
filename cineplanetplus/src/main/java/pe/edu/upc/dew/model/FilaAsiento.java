package pe.edu.upc.dew.model;

import java.util.List;

public class FilaAsiento implements java.io.Serializable {

	private static final long serialVersionUID = -8773957393179230477L;
	private Integer idFilaAsiento;
	private Sala sala;
	private Integer cantAsientos;
	private List<Asiento> asientos;

	public FilaAsiento() {

	}

	public FilaAsiento(Sala sala, Integer cantAsientos) {
		super();
		this.sala = sala;
		this.cantAsientos = cantAsientos;
	}

	public Integer getIdFilaAsiento() {
		return idFilaAsiento;
	}

	public void setIdFilaAsiento(Integer idFilaAsiento) {
		this.idFilaAsiento = idFilaAsiento;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Integer getCantAsientos() {
		return cantAsientos;
	}

	public void setCantAsientos(Integer cantAsientos) {
		this.cantAsientos = cantAsientos;
	}

	public List<Asiento> getAsientos() {
		return asientos;
	}

	public void setAsientos(List<Asiento> asientos) {
		this.asientos = asientos;
	}

}

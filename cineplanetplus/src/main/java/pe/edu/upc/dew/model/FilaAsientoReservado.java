package pe.edu.upc.dew.model;


public class FilaAsientoReservado implements java.io.Serializable {

	private static final long serialVersionUID = -492255864782680265L;
	private Integer idFilaAsiento;
	private Integer numeroAsiento;

	public FilaAsientoReservado() {

	}

	public Integer getIdFilaAsiento() {
		return idFilaAsiento;
	}

	public void setIdFilaAsiento(Integer idFilaAsiento) {
		this.idFilaAsiento = idFilaAsiento;
	}

	public Integer getNumeroAsiento() {
		return numeroAsiento;
	}

	public void setNumeroAsiento(Integer numeroAsiento) {
		this.numeroAsiento = numeroAsiento;
	}

}

package pe.edu.upc.dew.model;

import java.util.Date;

public class ReservacionFilaAsiento implements java.io.Serializable {

	private static final long serialVersionUID = -4389799385660199857L;
	private Integer idFilaAsiento;
	private Integer numeroAsiento;
	private Reservacion reservacion;
	private Date fechaReservada;
	
	public Date getFechaReservada()
    {
        return fechaReservada;
    }

    public void setFechaReservada(Date fechaReservada)
    {
        this.fechaReservada = fechaReservada;
    }

    public ReservacionFilaAsiento(){
		
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

	public Reservacion getReservacion() {
		return reservacion;
	}

	public void setReservacion(Reservacion reservacion) {
		this.reservacion = reservacion;
	}
	
	
}

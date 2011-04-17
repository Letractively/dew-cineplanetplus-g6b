package pe.edu.upc.dew.model;

import java.util.Date;
import java.util.List;

public class Reservacion implements java.io.Serializable {

	private static final long serialVersionUID = 3149272849901019695L;
	private String idReservacion;
	private Usuario usuario;
	private ProgramacionPelicula programacionPelicula;
	private Date fechaReservada;
	private Date fechaReservacion;
	private Integer cantAsientosReservados;
	private double montoTotal;
	
	public double getMontoTotal()
    {
        return cantAsientosReservados * 10 ;
    }

    public void setMontoTotal(double montoTotal)
    {
        this.montoTotal = montoTotal;
    }

    List<ReservacionFilaAsiento> asientosReservados;

	public Reservacion() {

	}

	public String getIdReservacion() {
		return idReservacion;
	}

	public List<ReservacionFilaAsiento> getAsientosReservados() {
		return asientosReservados;
	}

	public void setAsientosReservados(
			List<ReservacionFilaAsiento> asientosReservados) {
		this.asientosReservados = asientosReservados;
	}

	public void setIdReservacion(String idReservacion) {
		this.idReservacion = idReservacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ProgramacionPelicula getProgramacionPelicula() {
		return programacionPelicula;
	}

	public void setProgramacionPelicula(
			ProgramacionPelicula programacionPelicula) {
		this.programacionPelicula = programacionPelicula;
	}

	public Date getFechaReservacion() {
		return fechaReservacion;
	}

	public void setFechaReservacion(Date fechaReservacion) {
		this.fechaReservacion = fechaReservacion;
	}

	public Integer getCantAsientosReservados() {
		return asientosReservados.size();
	}

	public void setCantAsientosReservados(Integer cantAsientosReservados) {
		this.cantAsientosReservados = cantAsientosReservados;
	}

	public Date getFechaReservada() {
		return fechaReservada;
	}

	public void setFechaReservada(Date fechaReservada) {
		this.fechaReservada = fechaReservada;
	}

}

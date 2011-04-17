package pe.edu.upc.dew.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ProgramacionPelicula implements Serializable {

	private static final long serialVersionUID = -5933860801521365377L;

	private String id;

	private Sala sala;

	private Pelicula pelicula;

	private Date desde;

	private Date hasta;

	private Horario horario;

	private List<Horario> horarioList;

	public ProgramacionPelicula() {

	}

	public ProgramacionPelicula(String id, Sala sala, Pelicula pelicula, Date desde, Date hasta, Horario horario) {
		super();
		this.id = id;
		this.sala = sala;
		this.pelicula = pelicula;
		this.desde = desde;
		this.hasta = hasta;
		this.horario = horario;
	}

	public ProgramacionPelicula(String id, Sala sala, Pelicula pelicula, Date desde, Date hasta,
			List<Horario> horarioList) {
		super();
		this.id = id;
		this.sala = sala;
		this.pelicula = pelicula;
		this.desde = desde;
		this.hasta = hasta;
		this.horarioList = horarioList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Date getDesde() {
		return desde;
	}

	public void setDesde(Date desde) {
		this.desde = desde;
	}

	public Date getHasta() {
		return hasta;
	}

	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public List<Horario> getHorarioList() {
		return horarioList;
	}

	public void setHorarioList(List<Horario> horarioList) {
		this.horarioList = horarioList;
	}

}

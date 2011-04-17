package pe.edu.upc.dew.model;

import java.io.Serializable;
import java.util.List;

public class Horario implements Serializable {

	private static final long serialVersionUID = -5830107556758701074L;

	private String id;

	private String horaInicio;

	private String horaFin;

	private List<ProgramacionPelicula> programacionpeliculaList;

	public Horario() {

	}

	public Horario(String horaInicio, String horaFin) {
		super();
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public List<ProgramacionPelicula> getProgramacionpeliculaList() {
		return programacionpeliculaList;
	}

	public void setProgramacionpeliculaList(List<ProgramacionPelicula> programacionpeliculaList) {
		this.programacionpeliculaList = programacionpeliculaList;
	}

}

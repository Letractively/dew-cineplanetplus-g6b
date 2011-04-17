package pe.edu.upc.dew.model;

import java.io.Serializable;
import java.util.List;

public class Sala implements Serializable {

	private static final long serialVersionUID = -3188569458989265061L;
	private String idSala;
	private String descripcion;
	private Integer aforo;
	private Cine cine;
	private List<FilaAsiento> filas; 	
	
	private List<ProgramacionPelicula> programacionpeliculaList;

	public Sala() {
	}

	public Sala(Cine cine, String descripcion, Integer aforo) {
		this.cine = cine;
		this.descripcion = descripcion;
		this.aforo = aforo;
	}


	public String getIdSala()
    {
        return idSala;
    }

    public void setIdSala(String idSala)
    {
        this.idSala = idSala;
    }

    public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getAforo() {
		return aforo;
	}

	public void setAforo(Integer aforo) {
		this.aforo = aforo;
	}

	public Cine getCine() {
		return cine;
	}

	public void setCine(Cine cine) {
		this.cine = cine;
	}

    public List<ProgramacionPelicula> getProgramacionpeliculaList()
    {
        return programacionpeliculaList;
    }

    public void setProgramacionpeliculaList(List<ProgramacionPelicula> programacionpeliculaList)
    {
        this.programacionpeliculaList = programacionpeliculaList;
    }

	public List<FilaAsiento> getFilas() {
		return filas;
	}

	public void setFilas(List<FilaAsiento> filas) {
		this.filas = filas;
	}

	
}

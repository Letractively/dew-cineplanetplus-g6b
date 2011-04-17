package pe.edu.upc.dew.model;

import java.util.List;

public class TipoEmision implements java.io.Serializable {

	private static final long serialVersionUID = -8923421395680997569L;

	private String idTipoEmision;

	private String descripcion;

	private List<Pelicula> peliculaList;

	public TipoEmision() {

	}

	public TipoEmision(String idTipoEmision, String descripcion) {
		super();
		this.idTipoEmision = idTipoEmision;
		this.descripcion = descripcion;
	}

	public TipoEmision(String idTipoEmision, String descripcion, List<Pelicula> peliculaList) {
		super();
		this.idTipoEmision = idTipoEmision;
		this.descripcion = descripcion;
		this.peliculaList = peliculaList;
	}

	public String getIdTipoEmision() {
		return idTipoEmision;
	}

	public void setIdTipoEmision(String idTipoEmision) {
		this.idTipoEmision = idTipoEmision;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Pelicula> getPeliculaList() {
		return peliculaList;
	}

	public void setPeliculaList(List<Pelicula> peliculaList) {
		this.peliculaList = peliculaList;
	}

}

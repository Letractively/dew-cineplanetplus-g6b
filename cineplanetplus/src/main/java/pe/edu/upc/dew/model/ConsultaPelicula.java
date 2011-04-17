package pe.edu.upc.dew.model;

import java.io.Serializable;

public class ConsultaPelicula implements Serializable {

	private static final long serialVersionUID = 1291912938812805695L;
	private String id;
	private String idPelicula;
	private String titulo;
	private String genero;
	private String synopsis;
	private String site;
	private String imagen;
	private String director;
	private String reparto;
	private Integer duracion;
	private String pais;
	private Integer estado;
	private String publico;
	private String subtitulos;

	private String idCine;
	private String nombreCine;
	private String idSala;
	private String descripcionSala;
	private String idHorario;
	private String fechaInicio;
	private String fechaFin;
	private String horaInicio;
	private String horaFin;

	public ConsultaPelicula() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(String idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getReparto() {
		return reparto;
	}

	public void setReparto(String reparto) {
		this.reparto = reparto;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getPublico() {
		return publico;
	}

	public void setPublico(String publico) {
		this.publico = publico;
	}

	public String getSubtitulos() {
		return subtitulos;
	}

	public void setSubtitulos(String subtitulos) {
		this.subtitulos = subtitulos;
	}

	public String getIdCine() {
		return idCine;
	}

	public void setIdCine(String idCine) {
		this.idCine = idCine;
	}

	public String getNombreCine() {
		return nombreCine;
	}

	public void setNombreCine(String nombreCine) {
		this.nombreCine = nombreCine;
	}

	public String getIdSala() {
		return idSala;
	}

	public void setIdSala(String idSala) {
		this.idSala = idSala;
	}

	public String getDescripcionSala() {
		return descripcionSala;
	}

	public void setDescripcionSala(String descripcionSala) {
		this.descripcionSala = descripcionSala;
	}

	public String getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(String idHorario) {
		this.idHorario = idHorario;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
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

	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof ConsultaPelicula)) {
			return false;
		}
		ConsultaPelicula other = (ConsultaPelicula) object;
		if ((this.idPelicula == null && other.idPelicula != null)
				|| (this.idPelicula != null && !this.idPelicula.equals(other.idPelicula))) {
			return false;
		}
		return true;
	}

}

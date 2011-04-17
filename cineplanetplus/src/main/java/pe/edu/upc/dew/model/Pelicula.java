package pe.edu.upc.dew.model;

import java.io.Serializable;
import java.util.List;

public class Pelicula implements Serializable {

	private static final long serialVersionUID = 6375353070617631761L;
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
	private List<Comentario> comentarioList;
	
    public Pelicula() {
    }
    
    

    public Pelicula(String titulo, String genero, String synopsis, String site,
            String imagen, String director, String reparto, Integer duracion, String pais, Integer estado,
            String publico, String subtitulos)
    {
        super();
        this.titulo = titulo;
        this.genero = genero;
        this.synopsis = synopsis;
        this.site = site;
        this.imagen = imagen;
        this.director = director;
        this.reparto = reparto;
        this.duracion = duracion;
        this.pais = pais;
        this.estado = estado;
        this.publico = publico;
        this.subtitulos = subtitulos;
    }





    public String getIdPelicula()
    {
        return idPelicula;
    }



    public void setIdPelicula(String idPelicula)
    {
        this.idPelicula = idPelicula;
    }



    public String getTitulo()
    {
        return titulo;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }


    public String getGenero()
    {
        return genero;
    }

    public void setGenero(String genero)
    {
        this.genero = genero;
    }

    public String getSynopsis()
    {
        return synopsis;
    }

    public void setSynopsis(String synopsis)
    {
        this.synopsis = synopsis;
    }

    public String getSite()
    {
        return site;
    }

    public void setSite(String site)
    {
        this.site = site;
    }

    public String getImagen()
    {
        return imagen;
    }

    public void setImagen(String imagen)
    {
        this.imagen = imagen;
    }

    public String getDirector()
    {
        return director;
    }

    public void setDirector(String director)
    {
        this.director = director;
    }

    public String getReparto()
    {
        return reparto;
    }

    public void setReparto(String reparto)
    {
        this.reparto = reparto;
    }

    public Integer getDuracion()
    {
        return duracion;
    }

    public void setDuracion(Integer duracion)
    {
        this.duracion = duracion;
    }

    public String getPais()
    {
        return pais;
    }

    public void setPais(String pais)
    {
        this.pais = pais;
    }

    public Integer getEstado()
    {
        return estado;
    }

    public void setEstado(Integer estado)
    {
        this.estado = estado;
    }

    public String getPublico()
    {
        return publico;
    }

    public void setPublico(String publico)
    {
        this.publico = publico;
    }

    public String getSubtitulos()
    {
        return subtitulos;
    }

    public void setSubtitulos(String subtitulos)
    {
        this.subtitulos = subtitulos;
    }

    public List<Comentario> getComentarioList()
    {
        return comentarioList;
    }

    public void setComentarioList(List<Comentario> comentarioList)
    {
        this.comentarioList = comentarioList;
    }

    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pelicula)) {
            return false;
        }
        Pelicula other = (Pelicula) object;
        if ((this.idPelicula == null && other.idPelicula != null) || (this.idPelicula != null && !this.idPelicula.equals(other.idPelicula))) {
            return false;
        }
        return true;
    }

}

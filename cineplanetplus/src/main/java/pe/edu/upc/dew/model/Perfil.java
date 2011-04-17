package pe.edu.upc.dew.model;

import java.io.Serializable;
import java.util.List;

public class Perfil implements Serializable
{
	private static final long serialVersionUID = 5688849347000476463L;

	private String id;

    private String nombre;

    private String estado;

    private String vigencia;

    private List<Opcion> opciones;
    
    public Perfil()  {
        
    }

    public Perfil(String codigo, String nombre, String descripcion, String vigencia)
    {
        super();
        this.id = codigo;
        this.nombre = nombre;
        this.estado = descripcion;
        this.vigencia = vigencia;
    }

    public Perfil(String codigo, String nombre, String descripcion, List<Opcion> opcionesAdm)
    {
        this.id = codigo;
        this.nombre = nombre;
        this.estado = descripcion;
        this.opciones = opcionesAdm;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getEstado()
    {
        return estado;
    }

    public void setEstado(String estado)
    {
        this.estado = estado;
    }

    public String getVigencia()
    {
        return vigencia;
    }

    public void setVigencia(String vigencia)
    {
        this.vigencia = vigencia;
    }

    public List<Opcion> getOpciones()
    {
        return opciones;
    }

    public void setOpciones(List<Opcion> opciones)
    {
        this.opciones = opciones;
    }
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}

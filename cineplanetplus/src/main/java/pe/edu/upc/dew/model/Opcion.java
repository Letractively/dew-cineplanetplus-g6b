package pe.edu.upc.dew.model;

import java.io.Serializable;
import java.util.List;

public class Opcion implements Serializable
{
	private static final long serialVersionUID = 2379960605536402867L;

	private String id;

    private String descripcion;

    private String estado;

    private List<Perfil> perfilList;

    public Opcion()
    {

    }

    public Opcion(String id, String descripcion, String estado)
    {
        super();
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getEstado()
    {
        return estado;
    }

    public void setEstado(String estado)
    {
        this.estado = estado;
    }

    public List<Perfil> getPerfilList()
    {
        return perfilList;
    }

    public void setPerfilList(List<Perfil> perfilList)
    {
        this.perfilList = perfilList;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if (!(object instanceof Opcion))
        {
            return false;
        }
        Opcion other = (Opcion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

}

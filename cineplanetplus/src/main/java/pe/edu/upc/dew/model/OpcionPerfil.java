package pe.edu.upc.dew.model;

import java.io.Serializable;

public class OpcionPerfil implements Serializable {

	private static final long serialVersionUID = -7491921076778877076L;

	private Opcion opcion;

	private Perfil perfil;

	public Opcion getOpcion() {
		return opcion;
	}

	public void setOpcion(Opcion opcion) {
		this.opcion = opcion;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}

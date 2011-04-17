package pe.edu.upc.dew.dao;

import pe.edu.upc.dew.model.Cine;

public interface CineDao {
	Cine getCinePorId(String id);

	void agregar(Cine cine);
}

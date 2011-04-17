package pe.edu.upc.dew.dao;

import java.util.List;

import pe.edu.upc.dew.model.FilaAsiento;

public interface FilaAsientoDao {
	
	List<FilaAsiento> getFilasPorSala(String idSala);

}

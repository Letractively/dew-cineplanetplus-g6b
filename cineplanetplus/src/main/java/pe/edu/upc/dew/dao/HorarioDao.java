package pe.edu.upc.dew.dao;

import java.util.List;

import pe.edu.upc.dew.model.Horario;

public interface HorarioDao {

	Horario getHorarioPorId(String id);
	
	 public List<Horario> getHorarios();
		 
	 void modificar(Horario cine);

}

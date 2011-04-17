package pe.edu.upc.dew.dao;

import pe.edu.upc.dew.model.Sala;

public interface SalaDao
{
    Sala getSalaPorId(String id);
    
    void agregar(Sala sala);
}

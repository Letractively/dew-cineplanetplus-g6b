package pe.edu.upc.dew.dao;

import java.util.List;

import pe.edu.upc.dew.model.Opcion;

public interface OpcionDao
{
    Opcion getOpcionPorId(String idOpcion);

    List<Opcion> getOpciones();

    void eliminar(String idOpcion);
    
    void agregar(Opcion opcion);

    void actualizar(Opcion opcion);
}

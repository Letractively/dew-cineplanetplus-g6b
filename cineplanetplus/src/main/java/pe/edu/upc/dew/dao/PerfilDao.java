package pe.edu.upc.dew.dao;

import java.util.List;

import pe.edu.upc.dew.model.Opcion;
import pe.edu.upc.dew.model.Perfil;

public interface PerfilDao
{
    Perfil getPerfilPorId(String idPerfil);

    List<Perfil> getPerfiles();
    
    List<Opcion> getOpciones(Perfil perfil);

    void eliminar(String idPerfil);
    
    void agregar(Perfil perfil);

    void actualizar(Perfil perfil);
    
    void asignarOpcionPerfil(Perfil perfil,List<Opcion> opciones);
    
    String obtenerCorrelativoId();
}

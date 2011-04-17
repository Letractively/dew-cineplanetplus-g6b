package pe.edu.upc.dew.dao;

import java.util.List;

import pe.edu.upc.dew.model.Pelicula;

public interface PeliculaDao
{

    void agregar(Pelicula Pelicula);
    
    void modificar(Pelicula Pelicula);
    
    void eliminar(String id);
 
    Pelicula getPeliculaPorId(String id);
    
    List<Pelicula> getPeliculasParaCartelera();

    List<Pelicula> getTodasPeliculas();
}

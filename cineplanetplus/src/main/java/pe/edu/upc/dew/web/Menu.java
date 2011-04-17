package pe.edu.upc.dew.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.dew.model.Pelicula;
import pe.edu.upc.dew.service.PeliculaService;

@Controller
public class Menu
{
    @Autowired
    private PeliculaService peliculaService;

    @RequestMapping("/mapaSitio.htm")
    public void mapaSitio()
    {

    }

    @RequestMapping("/contacto.htm")
    public void contacto()
    {

    }

    @RequestMapping("/cartelera.htm")
    public @ModelAttribute("peliculas")
    List<Pelicula> cartelera()
    {
        List<Pelicula> peliculas = peliculaService.getPeliculasParaCartelera();
        System.out.println("Cantidad peliculas: " + peliculas.size());
        return peliculas;

    }

}

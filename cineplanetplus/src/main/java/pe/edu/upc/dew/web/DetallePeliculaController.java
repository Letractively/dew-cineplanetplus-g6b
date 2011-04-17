package pe.edu.upc.dew.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.dew.model.Pelicula;
import pe.edu.upc.dew.service.PeliculaService;

@Controller
@RequestMapping("/detallePelicula.htm")
public class DetallePeliculaController
{
    @Autowired
    private PeliculaService peliculaService;

    @RequestMapping(method = RequestMethod.GET)
    public @ModelAttribute("pelicula")
    Pelicula setupForm(@RequestParam("id") String id)
    {
        Pelicula pelicula = peliculaService.getPeliculaPorId(id);
        return pelicula;
    }

}

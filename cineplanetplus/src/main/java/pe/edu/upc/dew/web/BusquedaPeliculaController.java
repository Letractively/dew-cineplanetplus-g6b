package pe.edu.upc.dew.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.dew.model.ConsultaPelicula;
import pe.edu.upc.dew.service.CarteleraService;

@Controller
public class BusquedaPeliculaController
{
    @Autowired
    private CarteleraService carteleraService;

    @RequestMapping("/busquedaPorGenero.htm")
    public @ModelAttribute("peliculas")
        List<ConsultaPelicula> buscarPeliculasGenero(HttpServletRequest request, @RequestParam("s") String s) {
        System.out.println("/busquedaPorGenero.htm");
        request.getSession().setAttribute("palabraClave", s);
        return null;
       /* return carteleraService.consultarCartelera(idCine, IdSala, titulo, idHorario);*/
    }
}

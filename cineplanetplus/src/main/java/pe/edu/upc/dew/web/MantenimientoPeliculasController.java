package pe.edu.upc.dew.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.dew.constantes.ConstantesSesion;
import pe.edu.upc.dew.model.Pelicula;
import pe.edu.upc.dew.model.Usuario;
import pe.edu.upc.dew.service.PeliculaService;

@Controller
public class MantenimientoPeliculasController
{
    @Autowired
    private PeliculaService peliculaService;

    @RequestMapping("/mantPeliculas.htm")
    public String listPeliculas(Map<String, Object> map, HttpServletRequest request)
    {
        map.put("peliculasList", peliculaService.getTodasPeliculas());
       // Usuario usuario = (Usuario) request.getSession(false).getAttribute("usuarioLog");        
        Usuario usuario = (Usuario) UtilWeb.obtenerObjetoDeSesion(request, ConstantesSesion.USUARIO_LOGUEADO);
        System.out.println("usuario.getNombre()" + usuario.getNombre());
        return "mantPeliculas";
    }

    /*
     * @RequestMapping(value = "/add.htm", method = RequestMethod.POST) public
     * String addPelicula(@ModelAttribute("pelicula") Pelicula pelicula,
     * @RequestParam("titulo") String titulo,
     * 
     * @RequestParam("genero") String genero, @RequestParam("synopsis") String
     * synopsis,
     * 
     * @RequestParam("site") String site, @RequestParam("imagen") String imagen,
     * 
     * @RequestParam("director") String director, @RequestParam("reparto")
     * String reparto,
     * 
     * @RequestParam("duracion") Integer duracion, @RequestParam("pais") String
     * pais,
     * 
     * @RequestParam("estado") Integer estado,@RequestParam("publico") String
     * publico,@RequestParam("subtitulos") String subtitulos, Model model) {
     * System.out.println("addPelicula"); System.out.println(genero);
     * System.out.println(synopsis); System.out.println(site);
     * System.out.println(duracion); System.out.println(estado);
     * System.out.println(subtitulos);
     * 
     * peliculaService.agregar(pelicula);
     * 
     * return "redirect:/mantPeliculas.htm"; }
     */

    @RequestMapping(value = "/agregarPeliculas.htm", method = RequestMethod.GET)
    public @ModelAttribute("pelicula")
    Pelicula setupForm(@RequestParam("id") String id, @RequestParam("metodo") String metodo)
    {
        if (metodo.equalsIgnoreCase("nuevaPelicula"))
        {
            return new Pelicula();
        }
        Pelicula pelicula = peliculaService.getPeliculaPorId(id);
        return pelicula;
    }

    @RequestMapping(value = "/add.htm", method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("pelicula") Pelicula pelicula, BindingResult result)
    {
        System.out.println("onSubmit");
        System.out.println("pelicula.getIdPelicula() " + pelicula.getIdPelicula());

        if (pelicula.getIdPelicula().equalsIgnoreCase(""))
        {
            peliculaService.agregar(pelicula);
        }
        else
        {
            peliculaService.modificar(pelicula);
        }

        return "redirect:/mantPeliculas.htm";
    }

    /*
     * @RequestMapping("/delete.htm/{idPelicula}") public String
     * deletePelicula(@PathVariable("idPelicula") String idPelicula) {
     * System.out.println("deletePelicula"); System.out.println(idPelicula);
     * peliculaService.eliminar(idPelicula); return "redirect:/index"; }
     */
    @RequestMapping(value = "/delete.htm", method = RequestMethod.GET)
    public String deletePelicula(@RequestParam("id") String id)
    {
        System.out.println("deletePelicula");
        System.out.println(id);
        peliculaService.eliminar(id);
        return "redirect:/mantPeliculas.htm";
    }

}

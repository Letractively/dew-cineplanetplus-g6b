package pe.edu.upc.dew.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.dew.constantes.ConstantesSesion;
import pe.edu.upc.dew.model.Usuario;
import pe.edu.upc.dew.service.UsuarioService;

@Controller
public class InicioController
{

    @Autowired
    private UsuarioService usuarioService;

    private Logger logger = Logger.getLogger(InicioController.class);

    @RequestMapping("/inicio.htm")
    public void inicio(HttpServletRequest request)
    {

        UtilWeb.eliminarObjetoEnSesion(request, ConstantesSesion.USUARIO_LOGUEADO);
        if (UtilWeb.validaSesionUsuario(request))
        {
            System.out.println("existe USUARIO_LOGUEADO");
        }
        else
        {
            System.out.println("no existe USUARIO_LOGUEADO");
        }

    }

    @RequestMapping("/login.htm")
    public void login()
    {

    }

    @RequestMapping(value = "/login.htm", method = RequestMethod.POST)
    public String display(@ModelAttribute("usuarioLog") Usuario usuarioLog, @RequestParam("user") String user,
            @RequestParam("clave") String clave, Model model, HttpServletRequest request)
    {
        Usuario usuario = usuarioService.getUsuario(user, clave);
        if (usuario != null)
        {
            model.addAttribute("usuarioLog", usuario);
            // request.getSession(false).setAttribute("usuarioLog", usuario);
            UtilWeb.colocarObjetoEnSesion(request, ConstantesSesion.USUARIO_LOGUEADO, usuario);
            System.out.println("usuario nombre : " + usuario.getNombre());
            return "intranetHome";
        }
        else
        {
            System.out.println("No existe usuario ");
            return "login";
        }

    }

}

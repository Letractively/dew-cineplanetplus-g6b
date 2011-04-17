package pe.edu.upc.dew.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import pe.edu.upc.dew.constantes.ConstantesSesion;
import pe.edu.upc.dew.model.Usuario;

public class UtilWeb
{

    public static boolean validaSesionUsuario(HttpServletRequest request) {
        HttpSession session = ((HttpServletRequest)request).getSession();
        Usuario usuarioSesion = (Usuario)session.getAttribute(ConstantesSesion.USUARIO_LOGUEADO);
        if (usuarioSesion == null) {
            return false;
        }
        return true;
    }
    
    public static void colocarObjetoEnSesion(HttpServletRequest request, String pReferencia, Object pObject){
        request.getSession(false).setAttribute( pReferencia, pObject );
    }
    
    public static void eliminarObjetoEnSesion(HttpServletRequest request, String pReferencia){
        request.getSession(false).removeAttribute( pReferencia );
    }
    
    public static Object obtenerObjetoDeSesion(HttpServletRequest request, String pReferencia){
        return request.getSession(false).getAttribute( pReferencia );
    }
}

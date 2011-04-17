package pe.edu.upc.dew.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.dew.constantes.ConstantesSesion;
import pe.edu.upc.dew.model.Cine;
import pe.edu.upc.dew.model.ConsultaPelicula;
import pe.edu.upc.dew.model.FilaAsiento;
import pe.edu.upc.dew.model.Horario;
import pe.edu.upc.dew.model.Pelicula;
import pe.edu.upc.dew.model.ProgramacionPelicula;
import pe.edu.upc.dew.model.Reservacion;
import pe.edu.upc.dew.model.ReservacionFilaAsiento;
import pe.edu.upc.dew.model.Sala;
import pe.edu.upc.dew.model.Usuario;
import pe.edu.upc.dew.service.CarteleraService;
import pe.edu.upc.dew.service.ReservacionService;
import pe.edu.upc.dew.service.UsuarioService;

@Controller
public class CompraEntradasController
{
    @Autowired
    private ReservacionService reservacionService;

    @Autowired
    private CarteleraService carteleraService;

    @Autowired
    private UsuarioService usuarioService;

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    @RequestMapping("/compraEntradasInicio.htm")
    public String listProgramacion()
    {
        return "compraEntradasPasoUno";
    }

    @RequestMapping(value = "/busquedaReservacion.htm", method = RequestMethod.POST)
    public String listBusqueda(Map<String, Object> map, @RequestParam("cine") String cine,
            @RequestParam("pelicula") String pelicula, @RequestParam("genero") String genero, HttpServletRequest request)
    {
        System.out.println(cine);
        System.out.println(pelicula);
        System.out.println(genero);
        List<ConsultaPelicula> peliculas = carteleraService.consultarCartelera("--Seleccione--", "--Seleccione--",
                "--Seleccione--", "--Seleccione--", genero);
        UtilWeb.colocarObjetoEnSesion(request, ConstantesSesion.CONSULTA_RESERVACION_EN_CURSO, peliculas);
        System.out.println(peliculas.size());
        map.put("peliculasList", peliculas);
        return "compraEntradasPasoUno";
    }

    @RequestMapping("/compraEntradasPasoDos.htm")
    public String mostrarDisponibildadAsientos(Map<String, Object> map, @RequestParam("id") String id,
            @RequestParam("idSala") String idSala, HttpServletRequest request)
    {
        System.out.println("id prog pel = " + id);

        ProgramacionPelicula programacionPelicula = new ProgramacionPelicula();
        programacionPelicula.setId(id);

        Sala sala = new Sala();
        sala.setIdSala(idSala);

        programacionPelicula.setSala(sala);

        Reservacion reservacion = new Reservacion();
        reservacion.setProgramacionPelicula(programacionPelicula);

        UtilWeb.colocarObjetoEnSesion(request, ConstantesSesion.RESERVACION_EN_CURSO, reservacion);

        List<FilaAsiento> filasSala = reservacionService.obtenerFilasAsientoPorSalaPorFuncion(programacionPelicula,
                "2011-02-02");
        System.out.println("filasSala.size() = " + filasSala.size());
        map.put("filasSala", filasSala);
        return "compraEntradasPasoDos";
    }

    @RequestMapping("/compraEntradasPasoTres.htm")
    public String mostrarFormularioReservacion(Map<String, Object> map,
            @RequestParam("filaasientos") String filaasientos, @RequestParam("fechareserva") String fechareserva,
            HttpServletRequest request)
    {
        System.out.println("filaasientos = " + filaasientos);
        Reservacion reservacion = (Reservacion) UtilWeb.obtenerObjetoDeSesion(request,
                ConstantesSesion.RESERVACION_EN_CURSO);
        System.out.println("reservacion pp id = " + reservacion.getProgramacionPelicula().getId());

        String[] valoresRecibidos = filaasientos.split(",");

        List<ReservacionFilaAsiento> asientosReservados = new ArrayList<ReservacionFilaAsiento>();

        try
        {

            for (int i = 0; i < valoresRecibidos.length; i++)
            {
                System.out.println(valoresRecibidos[i]);
                String[] valores = valoresRecibidos[i].split("-");
                System.out.println(valores[0]);
                System.out.println(valores[1]);

                ReservacionFilaAsiento reservacionFilaAsiento = new ReservacionFilaAsiento();
                reservacionFilaAsiento.setIdFilaAsiento(Integer.parseInt(valores[0]));
                reservacionFilaAsiento.setNumeroAsiento(Integer.parseInt(valores[1]));
                reservacionFilaAsiento.setReservacion(reservacion);
                reservacionFilaAsiento.setFechaReservada(formato.parse(fechareserva));
                asientosReservados.add(reservacionFilaAsiento);
            }
            reservacion.setAsientosReservados(asientosReservados);
            UtilWeb.colocarObjetoEnSesion(request, ConstantesSesion.RESERVACION_EN_CURSO, reservacion);

        }
        catch (NumberFormatException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (ParseException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "compraEntradasPasoTres";
    }

    @RequestMapping(value = "/compraEntradasPasoCuatro.htm", method = RequestMethod.POST)
    public String datosReservacion(Map<String, Object> map, @RequestParam("username") String username,
            HttpServletRequest request)
    {
        Reservacion reservacion = (Reservacion) UtilWeb.obtenerObjetoDeSesion(request,
                ConstantesSesion.RESERVACION_EN_CURSO);
        System.out.println("entro a datosReservacion");
        System.out.println("reservacion pp id = " + reservacion.getProgramacionPelicula().getId());
        System.out.println("reservacion asientos reservados = " + reservacion.getAsientosReservados().size());
        // Datos del usuario
        Usuario usuario = usuarioService.getUsuarioPorId("USU00000011");// capturar                                                                  // d
                                                                        // pantalla
        reservacion.setUsuario(usuario);
        reservacion.setFechaReservada(new Date());// formato????????
        reservacion.setCantAsientosReservados(reservacion.getAsientosReservados().size());
        UtilWeb.colocarObjetoEnSesion(request, ConstantesSesion.RESERVACION_EN_CURSO, reservacion);
        // para mostrar datos
        ConsultaPelicula consultaPelicula = carteleraService.obtenerCarteleraId(reservacion.getProgramacionPelicula().getId());
        Pelicula pelicula = new Pelicula();
        pelicula.setTitulo(consultaPelicula.getTitulo());
        reservacion.getProgramacionPelicula().setPelicula(pelicula);

        Cine cine = new Cine();
        cine.setNombre(consultaPelicula.getNombreCine());
        reservacion.getProgramacionPelicula().getSala().setDescripcion(consultaPelicula.getDescripcionSala());
        
        Horario horario = new Horario();
        horario.setHoraInicio(consultaPelicula.getHoraInicio());
        horario.setHoraFin(consultaPelicula.getHoraFin());
        reservacion.getProgramacionPelicula().setHorario(horario);
        
        map.put("reservacion", reservacion);

        return "compraEntradasPasoCuatro";
    }

    @RequestMapping(value = "/compraEntradasConfirmar.htm")
    public String reservar(Map<String, Object> map, HttpServletRequest request)
    {
        Reservacion reservacion = (Reservacion) UtilWeb.obtenerObjetoDeSesion(request,
                ConstantesSesion.RESERVACION_EN_CURSO);
        System.out.println("Entro a confirmar reservacion");
        System.out.println("reservacion pp id = " + reservacion.getProgramacionPelicula().getId());
        System.out.println("reservacion asientos reservados = " + reservacion.getAsientosReservados().size());

        reservacionService.reservar(reservacion, reservacion.getAsientosReservados());
      
        UtilWeb.eliminarObjetoEnSesion(request, ConstantesSesion.RESERVACION_EN_CURSO);
        return "operacionExitosa";
    }

}

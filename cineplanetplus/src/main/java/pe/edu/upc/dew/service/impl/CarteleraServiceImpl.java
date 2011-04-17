package pe.edu.upc.dew.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pe.edu.upc.dew.dao.CarteleraDao;
import pe.edu.upc.dew.dao.HorarioDao;
import pe.edu.upc.dew.dao.PeliculaDao;
import pe.edu.upc.dew.dao.SalaDao;
import pe.edu.upc.dew.model.ConsultaPelicula;
import pe.edu.upc.dew.model.Pelicula;
import pe.edu.upc.dew.model.ProgramacionPelicula;
import pe.edu.upc.dew.model.Sala;
import pe.edu.upc.dew.service.CarteleraService;
@Service
public class CarteleraServiceImpl implements CarteleraService {
	@Autowired
	private CarteleraDao carteleraDao;

	@Autowired
	private SalaDao salaDao;

	@Autowired
	private PeliculaDao peliculaDao;

	@Autowired
	private HorarioDao horarioDao;

	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public void setCarteleraDao(CarteleraDao carteleraDao) {
		this.carteleraDao = carteleraDao;
	}

	/* (non-Javadoc)
	 * @see pe.edu.upc.dew.service.CarteleraService#crearCarteleraMasivamente(java.lang.String, java.util.List, java.lang.String, java.lang.String)
	 */
	public void crearCarteleraMasivamente(String idSala, List<Pelicula> peliculas, String fechaInicio, String fechaFin) {
		try {
			String codHorario = "";
			Integer contador = 0;
			Sala sala = salaDao.getSalaPorId(idSala);
			//Se obtiene las peliculas con estado = 1(pendiente asignar a cartelera)
			// se asignara masivamente en grupos de 5 peliculas (xq son 5 horarios diferentes)
			for (Pelicula pelicula : peliculas) {
				ProgramacionPelicula programacionPelicula = new ProgramacionPelicula();
				programacionPelicula.setSala(sala);
				programacionPelicula.setPelicula(pelicula);

				programacionPelicula.setDesde(formato.parse(fechaInicio));
				programacionPelicula.setHasta(formato.parse(fechaFin));

				contador++;
				codHorario = contador.toString();
				programacionPelicula.setHorario(horarioDao.getHorarioPorId(codHorario));

				carteleraDao.agregarProgramacionPelicula(programacionPelicula);
				//cambiar de estado pelicula a 2(asignado a cartelera)
				pelicula.setEstado(new Integer(2));
				peliculaDao.modificar(pelicula);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<ConsultaPelicula> consultarCartelera(String idCine, String IdSala, String titulo, String idHorario, String genero) {
		List<ConsultaPelicula> peliculas = carteleraDao.consultarCartelera(idCine, IdSala, titulo, idHorario, genero);
		return peliculas;
	}

	@Override
	public void crearCarteleraPorPelicula(ProgramacionPelicula programacionPelicula) {
		carteleraDao.agregarProgramacionPelicula(programacionPelicula);		
	}

    @Override
    public ConsultaPelicula obtenerCarteleraId(String idProgPel)
    {
        // TODO Auto-generated method stub
        return carteleraDao.obtenerCarteleraId(idProgPel);
    }

}

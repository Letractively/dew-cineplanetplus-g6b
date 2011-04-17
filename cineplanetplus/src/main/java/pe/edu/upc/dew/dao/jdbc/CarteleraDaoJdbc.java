package pe.edu.upc.dew.dao.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pe.edu.upc.dew.dao.CarteleraDao;
import pe.edu.upc.dew.model.ConsultaPelicula;
import pe.edu.upc.dew.model.Horario;
import pe.edu.upc.dew.model.ProgramacionPelicula;
import pe.edu.upc.dew.util.Util;

@Repository
public class CarteleraDaoJdbc extends SimpleJdbcDaoSupport implements CarteleraDao {

	public void agregarProgramacionPelicula(ProgramacionPelicula programacionPelicula) {
		// TODO Auto-generated method stub
		String sql = "insert into programacionpelicula(id,idSala,idPelicula,fechaInicio,fechaFin,idHorario) values(?,?,?,?,?,?);";
		getSimpleJdbcTemplate().update(sql, obtenerCorrelativoId(), programacionPelicula.getSala().getIdSala(),
				programacionPelicula.getPelicula().getIdPelicula(), programacionPelicula.getDesde(),
				programacionPelicula.getHasta(), programacionPelicula.getHorario().getId());

	}

	@SuppressWarnings("deprecation")
	public List<ConsultaPelicula> consultarCartelera(String idCine, String idSala, String idPelicula, String idHorario,String genero) {
		List<ConsultaPelicula> peliculas = new ArrayList<ConsultaPelicula>();
		if (!idCine.equals("--Seleccione--") && idSala.equals("--Seleccione--") && idPelicula.equals("--Seleccione--")
				&& idHorario.equals("--Seleccione--") && genero.equals("--Seleccione--")) {//Por cine
			String sql = "SELECT pp.id,c.idCine,c.nombre, s.idSala, s.descripcion,"
					+ "pp.idHorario,pp.fechaInicio,pp.fechaFin, h.horaInicio,h.horaFin,"
					+ "p.idPelicula,p.titulo,p.genero,p.synopsis,p.site,p.imagen,p.director,"
					+ "p.reparto,p.duracion,p.pais,p.estado,p.publico,p.subtitulos "
					+ "FROM pelicula p,programacionpelicula pp,sala s,cine c,horario h "
					+ "WHERE c.idCine = s.idCine and s.idSala = pp.idSala and pp.idPelicula=p.idPelicula and pp.idHorario= h.id "
					+ "and c.idCine =?";
			peliculas = getSimpleJdbcTemplate().query(sql, new PeliculaRowMapper(), idCine);
		} else if (!idCine.equals("--Seleccione--") && !idSala.equals("--Seleccione--")
				&& idPelicula.equals("--Seleccione--") && idHorario.equals("--Seleccione--") && genero.equals("--Seleccione--")) {// x cine y sala
			String sql = "SELECT pp.id,c.idCine,c.nombre, s.idSala, s.descripcion,"
					+ "pp.idHorario,pp.fechaInicio,pp.fechaFin, h.horaInicio,h.horaFin,"
					+ "p.idPelicula,p.titulo,p.genero,p.synopsis,p.site,p.imagen,p.director,"
					+ "p.reparto,p.duracion,p.pais,p.estado,p.publico,p.subtitulos "
					+ "FROM pelicula p,programacionpelicula pp,sala s,cine c,horario h "
					+ "WHERE c.idCine = s.idCine and s.idSala = pp.idSala and pp.idPelicula=p.idPelicula and pp.idHorario= h.id "
					+ "and c.idCine =? and s.idSala =?";
			peliculas = getSimpleJdbcTemplate().query(sql, new PeliculaRowMapper(), idCine, idSala);
		} else if (!idCine.equals("--Seleccione--") && !idSala.equals("--Seleccione--")
				&& !idPelicula.equals("--Seleccione--") && idHorario.equals("--Seleccione--") && genero.equals("--Seleccione--")) {//X cine  x sala x pelicula
			String sql = "SELECT pp.id,c.idCine,c.nombre, s.idSala, s.descripcion,"
					+ "pp.idHorario,pp.fechaInicio,pp.fechaFin, h.horaInicio,h.horaFin,"
					+ "p.idPelicula,p.titulo,p.genero,p.synopsis,p.site,p.imagen,p.director,"
					+ "p.reparto,p.duracion,p.pais,p.estado,p.publico,p.subtitulos "
					+ "FROM pelicula p,programacionpelicula pp,sala s,cine c,horario h "
					+ "WHERE c.idCine = s.idCine and s.idSala = pp.idSala and pp.idPelicula=p.idPelicula and pp.idHorario= h.id "
					+ "and c.idCine =? and s.idSala =? and pp.idPelicula =?";
			peliculas = getSimpleJdbcTemplate().query(sql, new PeliculaRowMapper(), idCine, idSala, idPelicula);
		}// por pelicula
		else if (idCine.equals("--Seleccione--") && idSala.equals("--Seleccione--")
				&& !idPelicula.equals("--Seleccione--") && idHorario.equals("--Seleccione--") && genero.equals("--Seleccione--")) {
			String sql = "SELECT pp.id,c.idCine,c.nombre, s.idSala, s.descripcion,"
					+ "pp.idHorario,pp.fechaInicio,pp.fechaFin, h.horaInicio,h.horaFin,"
					+ "p.idPelicula,p.titulo,p.genero,p.synopsis,p.site,p.imagen,p.director,"
					+ "p.reparto,p.duracion,p.pais,p.estado,p.publico,p.subtitulos "
					+ "FROM pelicula p,programacionpelicula pp,sala s,cine c,horario h "
					+ "WHERE c.idCine = s.idCine and s.idSala = pp.idSala and pp.idPelicula=p.idPelicula and pp.idHorario= h.id "
					+ "and pp.idPelicula =?";
			peliculas = getSimpleJdbcTemplate().query(sql, new PeliculaRowMapper(), idPelicula);
		}//Por todos los criterios
		else if (!idCine.equals("--Seleccione--") && !idSala.equals("--Seleccione--")
				&& !idPelicula.equals("--Seleccione--") && !idHorario.equals("--Seleccione--") && !genero.equals("--Seleccione--")) {
			String sql = "SELECT pp.id,c.idCine,c.nombre, s.idSala, s.descripcion,"
					+ "pp.idHorario,pp.fechaInicio,pp.fechaFin, h.horaInicio,h.horaFin,"
					+ "p.idPelicula,p.titulo,p.genero,p.synopsis,p.site,p.imagen,p.director,"
					+ "p.reparto,p.duracion,p.pais,p.estado,p.publico,p.subtitulos "
					+ "FROM pelicula p,programacionpelicula pp,sala s,cine c,horario h "
					+ "WHERE c.idCine = s.idCine and s.idSala = pp.idSala and pp.idPelicula=p.idPelicula and pp.idHorario= h.id "
					+ "and c.idCine =? and s.idSala =? and pp.idPelicula =? and pp.idHorario = ? and p.genero =?";
			peliculas = getSimpleJdbcTemplate().query(sql, new PeliculaRowMapper(), idCine, idSala, idPelicula,
					idHorario,genero);

		}//Por genero
        else if (idCine.equals("--Seleccione--") && idSala.equals("--Seleccione--")
                && idPelicula.equals("--Seleccione--") && idHorario.equals("--Seleccione--") && !genero.equals("--Seleccione--")) {
            String sql = "SELECT pp.id,c.idCine,c.nombre, s.idSala, s.descripcion,"
                    + "pp.idHorario,pp.fechaInicio,pp.fechaFin, h.horaInicio,h.horaFin,"
                    + "p.idPelicula,p.titulo,p.genero,p.synopsis,p.site,p.imagen,p.director,"
                    + "p.reparto,p.duracion,p.pais,p.estado,p.publico,p.subtitulos "
                    + "FROM pelicula p,programacionpelicula pp,sala s,cine c,horario h "
                    + "WHERE c.idCine = s.idCine and s.idSala = pp.idSala and pp.idPelicula=p.idPelicula and pp.idHorario= h.id "
                    + "and p.genero =?";
            peliculas = getSimpleJdbcTemplate().query(sql, new PeliculaRowMapper(), genero);
        }		
		return peliculas;

	}

	public void establecerProgramacionPeliculaHorario(ProgramacionPelicula programacionPelicula, Horario horario) {
		String sql = "insert into programacionpeliculahorario(idProgramacionPelicula,idHorario) values(?,?);";
		getSimpleJdbcTemplate().update(sql, programacionPelicula.getId(), horario.getId());

	}

	public void eliminar(ProgramacionPelicula programacionPelicula) {
		// TODO Auto-generated method stub

	}

	public void actualizar(ProgramacionPelicula programacionPelicula) {
		// TODO Auto-generated method stub

	}

	public String obtenerCorrelativoId() {
		String correlativoId = "";
		String sql = "SELECT max(id) FROM programacionpelicula";
		String codigoMax = getSimpleJdbcTemplate().queryForObject(sql, String.class);
		if (codigoMax == null || codigoMax.equals("")) {
			correlativoId = "PP00000001";
		} else {
			String codigo = codigoMax.substring(2);
			Integer cod = Integer.parseInt(codigo) + 1;
			correlativoId = Util.caracterIzquierda(cod.toString(), 8, "0");
			correlativoId = "PP" + correlativoId;
		}
		return correlativoId;
	}

    @Override
    public ConsultaPelicula obtenerCarteleraId(String idProgPel)
    {
        List<ConsultaPelicula> peliculas = new ArrayList<ConsultaPelicula>();
        String sql = "SELECT pp.id,c.idCine,c.nombre, s.idSala, s.descripcion,"
            + "pp.idHorario,pp.fechaInicio,pp.fechaFin, h.horaInicio,h.horaFin,"
            + "p.idPelicula,p.titulo,p.genero,p.synopsis,p.site,p.imagen,p.director,"
            + "p.reparto,p.duracion,p.pais,p.estado,p.publico,p.subtitulos "
            + "FROM pelicula p,programacionpelicula pp,sala s,cine c,horario h "
            + "WHERE c.idCine = s.idCine and s.idSala = pp.idSala and pp.idPelicula=p.idPelicula and pp.idHorario= h.id "
            + "and pp.id =?";
        peliculas = getSimpleJdbcTemplate().query(sql, new PeliculaRowMapper(), idProgPel);
        return  peliculas.get(0);
        
    }

}

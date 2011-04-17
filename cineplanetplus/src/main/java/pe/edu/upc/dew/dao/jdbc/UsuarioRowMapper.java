package pe.edu.upc.dew.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import pe.edu.upc.dew.model.Perfil;
import pe.edu.upc.dew.model.Usuario;

public class UsuarioRowMapper implements ParameterizedRowMapper <Usuario>
{

    @Override
    public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException
    {
       Usuario usuario = new  Usuario();
       usuario.setIdUsuario(rs.getString("idUsuario"));
       usuario.setUsername(rs.getString("username"));
       usuario.setPassw(rs.getString("passw"));
       usuario.setApePaterno(rs.getString("apePaterno"));
       usuario.setApeMaterno(rs.getString("apeMaterno"));
       usuario.setNombre(rs.getString("nombres"));
       usuario.setDireccion(rs.getString("direccion"));
       usuario.setEstado(rs.getString("estadoUsu"));
       
       Perfil perfil = new Perfil();       
       perfil.setId(rs.getString("id"));
       perfil.setNombre(rs.getString("descripcion"));
       perfil.setEstado(rs.getString("estado"));
       perfil.setVigencia(rs.getString("vigencia"));
       
       usuario.setPerfil(perfil);
       
       return usuario;
    }

}

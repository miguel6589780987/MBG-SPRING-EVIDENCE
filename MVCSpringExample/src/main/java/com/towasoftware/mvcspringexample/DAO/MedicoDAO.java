/**
 * 
 */
package com.towasoftware.mvcspringexample.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.towasoftware.mvcspringexample.model.Medico;


/**
 * 
 * 
 */
public class MedicoDAO {

	public List<Medico> mapMedicos(ResultSet resultSet) throws SQLException {

		List<Medico> lista = new ArrayList();
		while (resultSet.next()) {
			
			lista.add(maper(resultSet));
		}
		return lista;
	}
	
	public Medico mapMedico(ResultSet resultSet) throws SQLException {
			
			if (!resultSet.next())
			{return null;}
			return maper(resultSet);
			
	}
	
	public Medico maper(ResultSet resultSet) throws SQLException
	{
		Medico medico = new Medico();
		medico.setCedula(resultSet.getInt("cedula"));
		medico.setNombre(resultSet.getString("nombre"));
		medico.setTelefono(resultSet.getString("telefono"));
		medico.setCorreo(resultSet.getString("correo"));
		medico.setIdEspecialidad(resultSet.getInt("idEspecialidad"));
		System.out.println(medico);
	return medico;
	}
}

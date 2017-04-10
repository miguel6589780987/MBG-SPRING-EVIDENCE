/**
 * 
 */
package com.towasoftware.mvcspringexample.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.towasoftware.mvcspringexample.model.Paciente;


/**
 * 
 * 
 */
public class PacienteDAO {

	public List<Paciente> mapPacientes(ResultSet resultSet) throws SQLException {

		List<Paciente> lista = new ArrayList();
		while (resultSet.next()) {
			
			lista.add(maper(resultSet));
		}
		return lista;
	}
	
	public Paciente mapPaciente(ResultSet resultSet) throws SQLException {
			
			if (!resultSet.next())
			{return null;}
			return maper(resultSet);
			
	}
	
	public Paciente maper(ResultSet resultSet) throws SQLException
	{
		Paciente paciente = new Paciente();
		paciente.setIdPaciente(resultSet.getInt("id_paciente"));
		paciente.setNombre(resultSet.getString("nombre"));
		paciente.setAlergias(resultSet.getString("alergias"));
		paciente.setNum_seguro(resultSet.getString("num_seguro"));
		paciente.setDireccion(resultSet.getString("direccion"));
		paciente.setEmail(resultSet.getString("email"));
		paciente.setFechaNacimiento(resultSet.getString("fechaNacimiento"));
		paciente.setSexo(resultSet.getString("sexo"));
		paciente.setTelefono(resultSet.getString("telefono"));
		paciente.setTipoSangre(resultSet.getString("tipoSangre"));
		
	return paciente;
	}
}

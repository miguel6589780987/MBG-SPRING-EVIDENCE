package com.towasoftware.mvcspringexample.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.towasoftware.mvcspringexample.model.Especialidad;


public class EspecialidadDAO {
	
	public List<Especialidad> mapEspecialidad(ResultSet resultSet) throws SQLException {

		List<Especialidad> lista = new ArrayList();
		while (resultSet.next()) {
			Especialidad especialidad = new Especialidad();
			especialidad.setIdEspecialidad(resultSet.getInt("idEspecialidad"));
			especialidad.setNombre(resultSet.getString("Nombre"));
			lista.add(especialidad);
		}
		return lista;
	}

}

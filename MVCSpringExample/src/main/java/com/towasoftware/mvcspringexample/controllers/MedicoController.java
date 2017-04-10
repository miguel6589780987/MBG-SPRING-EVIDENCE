package com.towasoftware.mvcspringexample.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.towasoftware.mvcspringexample.DAO.Actualiar;
import com.towasoftware.mvcspringexample.DAO.Consulta;
import com.towasoftware.mvcspringexample.DAO.Delete;
import com.towasoftware.mvcspringexample.DAO.Insertar;
import com.towasoftware.mvcspringexample.model.Medico;



@Controller
@RequestMapping(value = "/mobile/medico", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicoController {

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Medico createUser(@RequestBody Medico medico) throws SQLException {

		Insertar ins = new Insertar();
		ins.InsertarMedico(medico);

		return medico;

	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Medico> getAllUsers() throws SQLException {

		Consulta c = new Consulta();
		List<Medico> lstMedico = c.consultaMedicos();

		return lstMedico;

	}




	@RequestMapping(value = "/{cedula}", method = RequestMethod.PUT)
	public @ResponseBody Medico updateUser(@RequestBody Medico medico, @PathVariable int cedula)
			throws SQLException {

		Actualiar upd = new Actualiar();
		upd.updateMedico(medico, cedula);

	
		
		return medico;

	}

	@RequestMapping(value = "/{cedula}", method = RequestMethod.DELETE)
	public @ResponseBody Boolean deleteUser(@PathVariable String cedula) throws SQLException {

		Delete del = new Delete();
		if(del.deleteMedico(cedula)){
			return true;
		
		}
		else{
			return false;
			}
	}
}
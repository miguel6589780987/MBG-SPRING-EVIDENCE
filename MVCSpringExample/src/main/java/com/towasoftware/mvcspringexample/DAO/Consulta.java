package com.towasoftware.mvcspringexample.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.towasoftware.mvcspringexample.model.Departamento;
import com.towasoftware.mvcspringexample.model.Especialidad;
import com.towasoftware.mvcspringexample.model.Medico;
import com.towasoftware.mvcspringexample.model.Paciente;

import java.sql.Statement;


public class Consulta {

	private Connection conexion;
	private Statement statement;
	private String query;
	private ResultSet resultSet;

	public Consulta() {
		this.conexion = new Conexion().getConnection();
	}

	public List<Paciente> consultaPacientes() throws SQLException {
		 this.query = "Select * FROM paciente;";
		try {
			this.statement = this.conexion.createStatement();
			this.resultSet = this.statement.executeQuery(this.query);
			PacienteDAO mapPaciente = new PacienteDAO();
			return mapPaciente.mapPacientes(resultSet);
		} catch (Exception e) {
			return null;
		} finally {
			this.conexion.close();
		}
	}

	
	public Paciente consultaUltimoPaciente() throws SQLException {
		 this.query = "SELECT * FROM paciente ";
		try {
			this.statement = this.conexion.createStatement();
			this.resultSet = this.statement.executeQuery(this.query);
			PacienteDAO mapPaciente = new PacienteDAO();
			return mapPaciente.mapPaciente(resultSet);
		} catch (Exception e) {
			return null;
		} finally {
			this.conexion.close();
		}
	}
	
	
	public Paciente consultaPacienteId(int id) throws SQLException
	{
		this.setQuery("SELECT * FROM paciente;");
		return consultaPaciente();
	}

	public Paciente consultaPaciente() throws SQLException {
		
		try {
			this.statement = this.conexion.createStatement();
			this.resultSet = this.statement.executeQuery(this.query);
			PacienteDAO mapPaciente = new PacienteDAO();
			return mapPaciente.mapPaciente(resultSet);
		} catch (Exception e) {
			return null;
		} finally {
			this.conexion.close();
		}
	}

	public List<Departamento> consultaDepartamentos() throws SQLException {
		
		try {
			this.statement = this.conexion.createStatement();
			this.resultSet = this.statement.executeQuery(this.query);
			DepartamentoDAO mapDepartamento = new DepartamentoDAO();
			return mapDepartamento.mapDepartamentos(resultSet);
		} catch (Exception e) {
			return null;
		} finally {
			this.conexion.close();
		}
	}

	public Departamento consultaDepartamento() throws SQLException {
		
		try {
			this.statement = this.conexion.createStatement();
			this.resultSet = this.statement.executeQuery(this.query);
			DepartamentoDAO mapDepartamento = new DepartamentoDAO();
			return mapDepartamento.mapDepartamento(resultSet);
		} catch (Exception e) {
			return null;
		} finally {
			this.conexion.close();
		}
	}
	
	public List<Especialidad> consultaEspecialidades() throws SQLException {
		
		try {
			this.statement = this.conexion.createStatement();
			this.resultSet = this.statement.executeQuery(this.query);
			EspecialidadDAO mapEspecialidad = new EspecialidadDAO();
			return mapEspecialidad.mapEspecialidad(resultSet);
		} catch (Exception e) {
			return null;
		} finally {
			this.conexion.close();
		}
	}
	
	

	public Medico consultaUltimoMedico() throws SQLException {
		 this.query = "SELECT * FROM medico2 ORDER BY cedula DESC LIMIT 1";
		try {
			this.statement = this.conexion.createStatement();
			this.resultSet = this.statement.executeQuery(this.query);
			MedicoDAO mapMedico = new MedicoDAO();
			return mapMedico.mapMedico(resultSet);
		} catch (Exception e) {
			return null;
		} finally {
			this.conexion.close();
		}
	}

	
	public List<Medico> consultaMedicos() throws SQLException {
		 this.query = "Select * FROM medico2;";
		try {
			this.statement = this.conexion.createStatement();
			this.resultSet = this.statement.executeQuery(this.query);
			MedicoDAO mapMedico = new MedicoDAO();
			return mapMedico.mapMedicos(resultSet);
		} catch (Exception e) {
			return null;
		} finally {
			this.conexion.close();
		}
	}

	/**
	 * @return the conexion
	 */
	public Connection getConexion() {
		return conexion;
	}

	/**
	 * @param conexion
	 *            the conexion to set
	 */
	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	/**
	 * @return the statement
	 */
	public Statement getStatement() {
		return statement;
	}

	/**
	 * @param statement
	 *            the statement to set
	 */
	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	/**
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * @param query
	 *            the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}

}

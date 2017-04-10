package com.towasoftware.mvcspringexample.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.towasoftware.mvcspringexample.model.Cita;
import com.towasoftware.mvcspringexample.model.Consultorio;
import com.towasoftware.mvcspringexample.model.Departamento;
import com.towasoftware.mvcspringexample.model.Especialidad;
import com.towasoftware.mvcspringexample.model.Medico;
import com.towasoftware.mvcspringexample.model.Paciente;



public class Actualiar {

	private Connection conexion;
	private Statement statement;
	private String query;


	
	public void updatePaciente(Paciente paciente, int id) throws SQLException
	{
		String insertTableSQL = "UPDATE Paciente  SET" + 
				" `Nombre` = '"+paciente.getNombre()+"' ,"
				+ " `Apellido` = '"+paciente.getNum_seguro()+"' ,"
				+ " `Direccion` = '"+paciente.getDireccion()+"', "
				+ "`Telefono` = '"+paciente.getTelefono()+"',"
				+ " `Email`= '"+paciente.getEmail()+"', "
				+ "`TipoSangre` = '"+paciente.getTipoSangre()+"',"
				+ " `Alergias` = '"+paciente.getAlergias()+"', "
				+ " `Sexo` = '"+paciente.getSexo()+"',"
				+ " `FechaNacimiento` = '"+paciente.fechaNacimiento()+"' "
				+ "WHERE `idPaciente` = "+id
						+ " ;"; 
		
		this.query =insertTableSQL;
		this.actualizar();
		
	}
	
	public void actualizarDepartamento(Departamento depto) throws SQLException
	{
		String insertTableSQL = "INSERT INTO Departamento" + " ( `idDepartamento`,`Nombre`)"
				+ "VALUES ("+depto.getIdDepartamento()+",'"+depto.getNombre()
				+"')"; 
		
		this.query = insertTableSQL;
		this.actualizar();
	}
	
	public void actualizarConsultorio(Consultorio consultorio) throws SQLException
	{
		String insertTableSQL = "INSERT INTO Consultorio" + " ( `idConsultorio`,`Piso`)"
				+ "VALUES ("+consultorio.getIdConsultorio()+","+consultorio.getPiso()
				+")"; 
		
		this.query = insertTableSQL;
		this.actualizar();
	}
	
	public void actualizarEspecialidad(Especialidad especialidad) throws SQLException
	{
		String insertTableSQL = "INSERT INTO Especialidad" + " ( `Nombre`, `idDepartamento`)"
				+ "VALUES ('"+especialidad.getNombre()+"',"+especialidad.getIdDepartamento()
				+")"; 
		
		this.query = insertTableSQL;
		this.actualizar();
	}
	
	public void actualizarCita(Cita cita) throws SQLException
	{
		String insertTableSQL = "INSERT INTO `cita`( `Fecha`, `Hora`, `idPaciente`,"
				+ " `idMedico`, `idConsultorio`, `Presion`, `Peso`, `Talla`, `Temperatura`, "
				+ "`Diagnostico`, `Observacion`) "
				+ "VALUES ('"+cita.getFecha()+"','"+cita.getHora()+"',"+cita.getIdPaciente()+","
				+ ""+cita.getIdMedico()+","+cita.getIdConsultorio()+",'"+cita.getPresion()+"',"
				+ ""+cita.getPeso()+","+cita.getTalla()+","+cita.getTemperatura()+","
				+ "'"+cita.getDiagnostico()+"','"+cita.getObservacion()+"'"
				+")"; 
		
		this.query = insertTableSQL;
		this.actualizar();
	}
	
	public void updateMedico(Medico medico, int cedula) throws SQLException
	{
		String insertTableSQL = "UPDATE medico2  SET" + 
				" `nombre` = '"+medico.getNombre()+"' ,"
				+ " `telefono` = '"+medico.getTelefono()+"' ,"
				+ " `telefono` = '"+medico.getTelefono()+"' ,"
				+ " `correo` = '"+medico.getCorreo()+"', "
				+ "`idEspecialidad` = '"+medico.getIdEspecialidad()+"',"
				+ " ;"; 
		
		this.query =insertTableSQL;
		this.actualizar();
		
	}
	
	
	public Actualiar() {
		this.conexion = new Conexion().getConnection();
	}

	public void actualizar() throws SQLException {
		try {
			
			this.statement = this.conexion.createStatement();

			System.out.println(this.query);

			// execute insert SQL stetement
			statement.executeUpdate(this.query);

			System.out.println("Record is updated into DBUSER table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (statement != null) {
				statement.close();
			}

			if ( this.conexion!= null) {
				this.conexion.close();
			}
		}
	}
}

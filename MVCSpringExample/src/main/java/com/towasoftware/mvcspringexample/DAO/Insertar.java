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



public class Insertar {

	private Connection conexion;
	private Statement statement;
	private String query;
	private ResultSet resultSet;

	public void InsertarPaciente(Paciente paciente) throws SQLException {
		String insertTableSQL = "INSERT INTO paciente" + " (nombre, num_seguro,"
				+ " direccion, telefono, email, tipoSangre, alergias,sexo, fechaNacimiento) "
				+ "VALUES ('" + paciente.getNombre() + "','" + paciente.getNum_seguro() + "'," + "'"
				+ paciente.getDireccion() + "','" + paciente.getTelefono() + "'," + "'" + paciente.getEmail() + "','"
				+ paciente.getTipoSangre() + "'," + "','" + paciente.fechaNacimiento() + "')";

		this.query = insertTableSQL;
		this.insertar();

	}

	public void InsertarDepartamento(Departamento depto) throws SQLException {
		String insertTableSQL = "INSERT INTO Departamento" + " ( `idDepartamento`,`Nombre`)" + "VALUES ("
				+ depto.getIdDepartamento() + ",'" + depto.getNombre() + "')";

		this.query = insertTableSQL;
		this.insertar();
	}

	public void InsertarConsultorio(Consultorio consultorio) throws SQLException {
		String insertTableSQL = "INSERT INTO Consultorio" + " ( `idConsultorio`,`Piso`)" + "VALUES ("
				+ consultorio.getIdConsultorio() + "," + consultorio.getPiso() + ")";

		this.query = insertTableSQL;
		this.insertar();
	}

	public void InsertarEspecialidad(Especialidad especialidad) throws SQLException {
		String insertTableSQL = "INSERT INTO Especialidad" + " ( `Nombre`, `idDepartamento`)" + "VALUES ('"
				+ especialidad.getNombre() + "'," + especialidad.getIdDepartamento() + ")";

		this.query = insertTableSQL;
		this.insertar();
	}

	public void InsertarCita(Cita cita) throws SQLException {
		String insertTableSQL = "INSERT INTO `cita`( `Fecha`, `Hora`, `idPaciente`, `idMedico`, `idConsultorio`, `Presion`, `Peso`, `Talla`, `Temperatura`, `Diagnostico`, `Observacion`) VALUES ('"
				+ cita.getFecha() + "','" + cita.getHora() + "'," + cita.getIdPaciente() + "," + cita.getIdMedico()
				+ "," + cita.getIdConsultorio() + ",'" + cita.getPresion() + "'," + cita.getPeso() + ","
				+ cita.getTalla() + "," + cita.getTemperatura() + "," + cita.getDiagnostico() + "','"
				+ cita.getObservacion() + "'" + ")";

		this.query = insertTableSQL;
		this.insertar();
	}

	public void InsertarMedico(Medico medico) throws SQLException {
		String insertTableSQL = "INSERT INTO medico2"
				+ " ( nombre, telefono, correo, idEspecialidad) VALUES (\""+ medico.getNombre() + "\",\"" + medico.getTelefono() + "\",\"" + medico.getCorreo() + "\","
				+ medico.getIdEspecialidad() + ");";
		
		

		this.query = insertTableSQL;
		this.insertar();

	}

	public Insertar() {
		this.conexion = new Conexion().getConnection();
	}

	public void insertar() throws SQLException {
		try {

			this.statement = this.conexion.createStatement();

			System.out.println(this.query);

			// execute insert SQL stetement
			statement.executeUpdate(this.query);

			System.out.println("Insertado correctamente");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (this.conexion != null) {
				this.conexion.close();
			}
		}
	}
}

package com.towasoftware.mvcspringexample.model;

/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
public class Medico {
	public Medico() {
	}
	
	private int cedula;	
	private String nombre;		
	private int idEspecialidad;	
	private String telefono;	
	private String correo;	


	/**
	 * @return the idMedico
	 */
	public int getCedula() {
		return cedula;
	}

	/**
	 * @param idMedico the idMedico to set
	 */
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	/**
	 * @return the idEspecialidad
	 */
	public int getIdEspecialidad() {
		return idEspecialidad;
	}

	/**
	 * @param idEspecialidad the idEspecialidad to set
	 */
	public void setIdEspecialidad(int idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Medico [cedula=" + cedula + ", nombre=" + nombre + ", idEspecialidad="
				+ idEspecialidad + ", telefono=" + telefono + ", correo=" + correo + "]";
	}

	public Medico(int idMedico, String nombre, String apellido, String telefono,int idEspecialidad) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
	
		this.idEspecialidad = idEspecialidad;
		this.telefono = telefono;
		this.correo = correo;
		
	}
	
	
	
}

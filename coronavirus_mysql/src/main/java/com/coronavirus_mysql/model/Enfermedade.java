package com.coronavirus_mysql.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the enfermedades database table.
 * 
 */
@Entity
@Table(name = "enfermedades")

public class Enfermedade implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Enfermedade.FIND_ALL";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_enfermedad")
	private int idEnfermedad;
	@Column(name = "descripcion")
	private String descripcion;

	public Enfermedade() {
	}

	public int getIdEnfermedad() {
		return this.idEnfermedad;
	}

	public void setIdEnfermedad(int idEnfermedad) {
		this.idEnfermedad = idEnfermedad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
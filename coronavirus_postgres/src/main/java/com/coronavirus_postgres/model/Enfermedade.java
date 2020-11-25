package com.coronavirus_postgres.model;

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

	public static final String FIND_ALL = "Enfermedade.Find_All";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_enfermedad")
	private Integer idEnfermedad;

	@Column(name = "descricion")
	private String descripcion;

	public Enfermedade() {
	}

	public Integer getIdEnfermedad() {
		return this.idEnfermedad;
	}

	public void setIdEnfermedad(Integer idEnfermedad) {
		this.idEnfermedad = idEnfermedad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descricion) {
		this.descripcion = descricion;
	}

}
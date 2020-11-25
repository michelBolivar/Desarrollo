package com.coronavirus_mysql.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the registro database table.
 * 
 */
@Entity
@Table(name="registro")

public class Registro implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	public static final String FIND_ALL="Registro.FIND_All";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_persona_empresa")
	private int idRegistro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_salida")
	private Date fechaSalida;

	@Column(name="id_empresa")
	private int idEmpresa;

	@Column(name="id_enfermedad")
	private int idEnfermedad;

	@Column(name="id_persona")
	private int idPersona;

	@Column(name="ingreso")
	private byte ingreso;

	@Column(name="sintomas")
	private byte sintomas;
	
	
	@Column(name="temperatura")
	private int temperatura;

	public Registro() {
	}

	public int getidRegistro() {
		return this.idRegistro;
	}

	public void setidRegistro(int idPersonaEmpresa) {
		this.idRegistro = idPersonaEmpresa;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaSalida() {
		return this.fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public int getIdEnfermedad() {
		return this.idEnfermedad;
	}

	public void setIdEnfermedad(int idEnfermedad) {
		this.idEnfermedad = idEnfermedad;
	}

	public int getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public byte getIngreso() {
		return this.ingreso;
	}

	public void setIngreso(byte ingreso) {
		this.ingreso = ingreso;
	}

	public byte getSintomas() {
		return this.sintomas;
	}

	public void setSintomas(byte sintomas) {
		this.sintomas = sintomas;
	}

	public int getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

}
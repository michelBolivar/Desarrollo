package com.coronavirus_mysql.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the personas database table.
 * 
 */
@Entity
@Table(name="personas")

public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	
	public static final String FIND_ALL="Persona.FIND_ALL";
	
	public static final String FIND_BY_DOCUMENT ="Persona.FIND_BY_DOCUMENT";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_persona")
	private int idPersona;
	
	
	@Column(name="documento")
	private String documento;

	@Column(name="email")
	private String email;

	@Column(name="estatura")
	private float estatura;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	@Column(name="genero")
	private String genero;

	@Column(name="grupo_sanguineo")
	private String grupoSanguineo;

	@Column(name="id_ciudad")
	private int idCiudad;

	@Column(name="id_tipo_documento")
	private int idTipoDocumento;
	
	@Column(name="peso")
	private float peso;

	@Column(name="primer_apellido")
	private String primerApellido;

	@Column(name="primer_nombre")
	private String primerNombre;

	@Column(name="segundo_apellido")
	private String segundoApellido;

	@Column(name="segundo_nombre")
	private String segundoNombre;

	@Column(name="telefono")
	private BigDecimal telefono;

	public Persona() {
	}

	public final int getIdPersona() {
		return idPersona;
	}

	public final void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public final String getDocumento() {
		return documento;
	}

	public final void setDocumento(String documento) {
		this.documento = documento;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	public final float getEstatura() {
		return estatura;
	}

	public final void setEstatura(float estatura) {
		this.estatura = estatura;
	}

	public final Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public final void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public final String getGenero() {
		return genero;
	}

	public final void setGenero(String genero) {
		this.genero = genero;
	}

	public final String getGrupoSanguineo() {
		return grupoSanguineo;
	}

	public final void setGrupoSanguineo(String grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}

	public final int getIdCiudad() {
		return idCiudad;
	}

	public final void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}

	public final int getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public final void setIdTipoDocumento(int idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public final float getPeso() {
		return peso;
	}

	public final void setPeso(float peso) {
		this.peso = peso;
	}

	public final String getPrimerApellido() {
		return primerApellido;
	}

	public final void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public final String getPrimerNombre() {
		return primerNombre;
	}

	public final void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public final String getSegundoApellido() {
		return segundoApellido;
	}

	public final void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public final String getSegundoNombre() {
		return segundoNombre;
	}

	public final void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public final BigDecimal getTelefono() {
		return telefono;
	}

	public final void setTelefono(BigDecimal telefono) {
		this.telefono = telefono;
	}
	
	

	

}
package com.coronavirus_mysql.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the empresa_login database table.
 * 
 */
@Entity
@Table(name="empresa_login")

public class EmpresaLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	
	public static final String FIND_ALL="EmpresaLogin.FIND_ALL";
	
	@EmbeddedId
	private EmpresaLoginPK id;

	private int estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_cancelado")
	private Date fechaRetiro;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	public EmpresaLogin() {
	}

	public EmpresaLoginPK getId() {
		return this.id;
	}

	public void setId(EmpresaLoginPK id) {
		this.id = id;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Date getfechaRetiro() {
		return this.fechaRetiro;
	}

	public void setfechaRetiro(Date fechaCancelado) {
		this.fechaRetiro = fechaCancelado;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
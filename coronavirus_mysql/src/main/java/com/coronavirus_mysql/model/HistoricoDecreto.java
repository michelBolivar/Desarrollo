package com.coronavirus_mysql.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the historico_decretos database table.
 * 
 */
@Entity
@Table(name = "historico_decretos")

public class HistoricoDecreto implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "HistoricoDecreto.FIND_ALL";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_historico")
	private int idHistorico;

	@Column(name = "descripcion")
	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_decreto")
	private Date fechaDecreto;

	@Column(name = "id_ciudad")
	private int idCiudad;

	@Column(name = "id_decreto")
	private Integer idDecreto;

	@Column(name = "url")
	private String url;

	public Integer getIdDecreto() {
		return idDecreto;
	}

	public void setIdDecreto(Integer idDecreto) {
		this.idDecreto = idDecreto;
	}

	public HistoricoDecreto() {
	}

	public int getIdHistorico() {
		return this.idHistorico;
	}

	public void setIdHistorico(int idHistorico) {
		this.idHistorico = idHistorico;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaDecreto() {
		return this.fechaDecreto;
	}

	public void setFechaDecreto(Date fechaDecreto) {
		this.fechaDecreto = fechaDecreto;
	}

	public int getIdCiudad() {
		return this.idCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
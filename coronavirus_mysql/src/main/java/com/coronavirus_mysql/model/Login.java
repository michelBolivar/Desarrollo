package com.coronavirus_mysql.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the login database table.
 * 
 */
@Entity
@Table(name="login")

public class Login implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL="Login.FIND_All";
	
	public static final String FIND_USER_CREDENTIALS="Login.FIND_USER_CREDENTIALS";
	
	public static final String FIND_USER="Login.FIND_USER";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_login")
	private int idLogin;

	
	@Column(name="clave")
	private String clave;

	@Column(name="usuario")
	private String usuario;

	public Login() {
	}

	public int getIdLogin() {
		return this.idLogin;
	}

	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
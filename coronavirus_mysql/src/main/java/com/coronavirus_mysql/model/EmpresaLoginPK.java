package com.coronavirus_mysql.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the empresa_login database table.
 * 
 */
@Embeddable
public class EmpresaLoginPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_empresa", insertable=false, updatable=false)
	private int idEmpresa;

	@Column(name="id_login", insertable=false, updatable=false)
	private int idLogin;

	public EmpresaLoginPK() {
	}
	public int getIdEmpresa() {
		return this.idEmpresa;
	}
	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public int getIdLogin() {
		return this.idLogin;
	}
	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EmpresaLoginPK)) {
			return false;
		}
		EmpresaLoginPK castOther = (EmpresaLoginPK)other;
		return 
			(this.idEmpresa == castOther.idEmpresa)
			&& (this.idLogin == castOther.idLogin);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idEmpresa;
		hash = hash * prime + this.idLogin;
		
		return hash;
	}
}
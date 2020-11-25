package com.usta.cmapp.constants;

/**
 * Contiene los valores constantes que jamas van a cambair e la aplicacion
 * 
 * @author michel
 *
 */

public enum EnumDataBase {

	MYSQL(1,"Msql"),
	POSTGRESQL(2,"Postgresql");
	
	
	private int id;
	
	private String description;

	private EnumDataBase(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
	
}

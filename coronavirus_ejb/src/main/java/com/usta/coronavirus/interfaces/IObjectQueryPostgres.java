package com.usta.coronavirus.interfaces;

import java.util.List;

import javax.ejb.Remote;

@Remote

public interface IObjectQueryPostgres<T> {

	/**
	 * @param <T>
	 * @throws exception
	 */
	public void create(T t) throws Exception;

	/**
	 * metodo encargado de buscar y listar todos los objetos de la
	 * consulta @return @throws
	 */

	public List<T> findAll(Class<T> t) throws Exception;

	/**
	 * metodo de encontrar or el id del objeto buscado @param @return @throws
	 */

	public T findById(Integer id, Class<T> object) throws Exception;

	/**
	 * metodo para realizar cualquier cambio o modificacion sobre un dato de un
	 * objeto
	 * 
	 * @param t
	 * @throws Exception
	 * 
	 */
	public void uptade(T t) throws Exception;

	/**
	 * Elimina un objeto dependidendo el id ue se solicite borrar
	 * 
	 * @param id
	 * @throws Exeption
	 */

	public void delete(Integer id, Class<T> object) throws Exception;

	/**
	 * Busca al usuario credenciales
	 * 
	 * @param user
	 * @param password
	 * @return
	 * @throws Exeption
	 */

	public T searchUser(String user, String password) throws Exception;

	public T requiredPass(String user) throws Exception;
	
	/**
	 * Buscamos por documento 
	 * @param document
	 * @return
	 * @throws Exception
	 */

	public T searchPersonByDocument(String document) throws Exception;

}

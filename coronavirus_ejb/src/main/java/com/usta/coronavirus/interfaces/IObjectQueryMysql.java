package com.usta.coronavirus.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.coronavirus_mysql.model.Login;

/**
 * 
 * Interface de tipo Bean que se encarga de definir los metodos para realizar el
 * crud.
 * 
 * @author michel
 * @param <T> tipo de objeto que recibe.
 *
 */

@Remote
public interface IObjectQueryMysql<T> {
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

	/**
	 * Recuperamos contraseña del usuario
	 */

	public T requiredPass(String user) throws Exception;
	
	/**
	 * Buscamos por documento 
	 * @param document
	 * @return
	 * @throws Exception
	 */

	public T searchPersonByDocument(String document) throws Exception;

}

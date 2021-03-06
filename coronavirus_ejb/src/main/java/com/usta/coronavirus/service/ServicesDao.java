package com.usta.coronavirus.service;

import java.util.List;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.usta.coronavirus.interfaces.IObjectQueryMysql;
//import com.usta.coronavirus.interfaces.Exeption;
import com.usta.coronavirus.interfaces.IObjectQueryPostgres;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ServicesDao<T> {

	@EJB
	IObjectQueryMysql<T> mysqlDao;
	IObjectQueryPostgres<T> postgresDao;

	/**
	 * @param <T>
	 * @throws exception
	 */
	public void create(T t, int db) throws Exception {

		switch (db) {
		case 1:// persiste mysql

			mysqlDao.create(t);
			break;
		case 2:// persiste postgres

			postgresDao.create(t);

			break;
		default:
			break;
		}

	}

	/**
	 * metodo encargado de buscar y listar todos los objetos de la
	 * consulta @return @throws
	 */

	public List<T> findAll(T t, int db) throws Exception {

		List<T> object = new ArrayList<T>();
		switch (db) {
		case 1:// persiste mysql

			object = mysqlDao.findAll((Class<T>) t);
			break;
		case 2:// persiste postgres

			object = postgresDao.findAll((Class<T>) t);

			break;
		default:
			break;
		}

		return object;
	}

	/**
	 * metodo de encontrar or el id del objeto buscado @param @return @throws
	 */

	public T findById(Integer id, Class<T> object, int db) throws Exception {

		T o = null;

		switch (db) {
		case 1:// persiste mysql

			o = mysqlDao.findById(id, object);
			break;
		case 2:// persiste postgres

			o = postgresDao.findById(id, object);

			break;
		default:
			break;
		}

		return o;
	}

	/**
	 * metodo para realizar cualquier cambio o modificacion sobre un dato de un
	 * objeto
	 * 
	 * @param t
	 * @throws Exception
	 * 
	 */
	public void uptade(T t, int db) throws Exception {

		switch (db) {
		case 1:// persiste mysql

			mysqlDao.uptade(t);

			break;
		case 2:// persiste postgres

			postgresDao.uptade(t);
			break;
		default:
			break;
		}

	}

	/**
	 * Elimina un objeto dependidendo el id ue se solicite borrar
	 * 
	 * @param id
	 * @throws Exeption
	 */

	public void delete(Integer id, Class<T> object, int db) throws Exception {

		switch (db) {
		case 1:// persiste mysql

			mysqlDao.delete(id, object);

			break;
		case 2:// persiste postgres

			postgresDao.delete(id, object);

			break;
		default:
			break;
		}
	}

	/**
	 * Busca al usuario credenciales
	 * 
	 * @param user
	 * @param password
	 * @return
	 * @throws Exeption
	 */

	public T searchUser(String user, String password, int bd) throws Exception {
		T t = null;
		switch (bd) {
		case 1:
			t = (T) mysqlDao.searchUser(user, password);
			break;
		case 2:
			t = (T) postgresDao.searchUser(user, password);
			break;
		}
		return t;

	}

	/**
	 * Metodo encargado de buscar el usuario para traeer su contrase;a
	 * 
	 * @return
	 * @throws Exception
	 */

	public T searchUserFor(String user, int bd) throws Exception {

		T t = null;

		switch (bd) {
		case 1:
			t = (T) mysqlDao.requiredPass(user);
			break;
		case 2:
			t = (T) postgresDao.requiredPass(user);
			break;
		}

		return t;

	}

	public T searchPersonByDocument(String document, int bd) throws Exception {

		T t = null;

		switch (bd) {
		case 1:
			t = (T) mysqlDao.searchPersonByDocument(document);
			break;
		case 2:
			t = (T) postgresDao.searchPersonByDocument(document);
			break;
		}
		return t;

	}

}

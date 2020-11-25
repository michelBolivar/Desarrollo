package com.usta.coronavirus.bean;

import javax.persistence.Query;

import java.util.List;
import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import com.coronavirus_mysql.model.Login;
import com.coronavirus_mysql.model.Persona;
import com.usta.coronavirus.interfaces.IObjectQueryMysql;

/**
 * 
 * @author michel
 *
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)

public class DaoObjectMysql<T> implements IObjectQueryMysql<T> {

	@PersistenceContext(unitName = "coronavirus_mysql") // definimos que motor de base de datos utilizamos
	EntityManager mysqlentity; // define los metodos que permiten las transacciones

	@Override
	public void create(T t) throws Exception {
		mysqlentity.persist(t);

	}

	@Override
	public List<T> findAll(Class<T> t) throws Exception {
		java.util.List<T> object = new ArrayList<T>();

		Query querySql = mysqlentity.createNamedQuery(t.getSimpleName() + ".FIND_ALL");
		object = querySql.getResultList();
		return object;
	}

	@Override
	public T findById(Integer id, Class<T> object) throws Exception {
		T t = null;

		t = (T) mysqlentity.find(Object.class, id);
		return t;
	}

	@Override
	public void uptade(T t) throws Exception {
		mysqlentity.merge(t);

	}

	@Override
	public void delete(Integer id, Class<T> object) throws Exception {

		T t = findById(id, object);
		if (t != null) {
			mysqlentity.remove(id);
		}

	}

	@Override
	public T searchUser(String user, String password) throws Exception {
		T l = null;

		Query q = mysqlentity.createNamedQuery(Login.FIND_USER_CREDENTIALS);
		q.setParameter("us", user);
		q.setParameter("ps", password);

		try {
			l = (T) q.getSingleResult();
		} catch (NoResultException e) {

			l = null;
		}

		return l;
	}

	@Override
	public T requiredPass(String user) throws Exception {
		T t = null;

		Query q = mysqlentity.createNamedQuery(Login.FIND_USER);

		q.setParameter("user", user);

		try {

			t = (T) q.getSingleResult();
		} catch (NoResultException e) {

			t = null;
		}

		return t;
	}

	@Override
	public T searchPersonByDocument(String document) throws Exception {
		T t = null;

		Query q = mysqlentity.createNamedQuery(Persona.FIND_BY_DOCUMENT);
		q.setParameter("doc", document);

		try {

			t = (T) q.getSingleResult();
		} catch (NoResultException e) {

			t = null;
		}

		return t;
	}

}

package com.usta.coronavirus.bean;

import java.util.List;
import java.util.ArrayList;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;



import com.coronavirus_mysql.model.Login;

import com.usta.coronavirus.interfaces.IObjectQueryPostgres;

/**
 * 
 * @author michel
 *
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)

public class DaoObjectPostgresql<T> implements IObjectQueryPostgres<T> {

	@PersistenceContext(unitName = "coronavirus_postgres")
	EntityManager postgresEnetity;

	@Override
	public void create(T t) throws Exception {
		
		// TODO Auto-generated method stub

		postgresEnetity.persist(t);

	}

	@Override
	public List<T> findAll(Class<T> t) throws Exception {
		List<T> object = new ArrayList<T>();
		Query querySql = (Query) postgresEnetity.createNamedQuery(t.getSimpleName() + "FIND_ALL");
		object = ((javax.persistence.Query) querySql).getResultList();
		return object;
	}

	@Override
	public T findById(Integer id, Class<T> object) throws Exception {
		T t = null;
		// *Query q =
		// postgresEnetity.createNamedQuery(object.getSimpleName()+"FIND_BY_ID");
		// * q.setParameter("id", id);

		t = (T) postgresEnetity.find(object, id);
		return null;
	}

	@Override
	public void uptade(T t) throws Exception {
		postgresEnetity.merge(t);

	}

	@Override
	public void delete(Integer id, Class<T> object) throws Exception {
		T t = (T) findById(id, object);
		if (t != null) {

			postgresEnetity.remove(t);

		}


	}

	@Override
	public T searchUser(String user, String password) throws Exception {
		T l =  null;

		Query q = (Query) postgresEnetity.createNamedQuery(Login.FIND_USER_CREDENTIALS);
		((javax.persistence.Query) q).setParameter("us", user);
		((javax.persistence.Query) q).setParameter("ps", password);

		try {
			l = (T) ((javax.persistence.Query) q).getSingleResult();
		} catch (NoResultException e) {

			l = null;
		}

		return l;
	}

	@Override
	public T requiredPass(String user) throws Exception {
		T t = null;

		Query q = (Query) postgresEnetity.createNamedQuery(Login.FIND_USER);

		((javax.persistence.Query) q).setParameter("user", user);

		try {

			t = (T) ((javax.persistence.Query) q).getSingleResult();
		} catch (NoResultException e) {

			t = null;
		}

		return t;
	}

	@Override
	public T searchPersonByDocument(String document) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

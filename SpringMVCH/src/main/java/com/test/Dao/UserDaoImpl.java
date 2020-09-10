package com.test.Dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.Model.Users;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired(required = true)
	private SessionFactory sessionFactory;

	public List<Users> selectUser(int id, String pass) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select s from Users s where s.id =:id and s.password =:pass ");
		query.setParameter("id", id);
		query.setParameter("pass", pass);
		List<Users> names = query.list();
		return names;

	}

	public Boolean checkAccount(int acc) {
		Boolean result = false;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Users s where s.id =:id ");
		query.setParameter("id", acc);
		List names = query.list();
		Iterator iterator = names.iterator();
		while (iterator.hasNext()) {
			result = true;
		}
		return result;
	}

	public Boolean insertUser(Users user) {
		Boolean result = true;
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(user);
		} catch (Exception ex) {
			result = false;
		}
		return result;
	}

	public String selectEmailByAcc(int acc) {
		String email = "";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select s.email from Users s where s.id =:id ");
		query.setParameter("id", acc);
		List names = query.list();
		if (names != null) {
			email = String.valueOf(names.get(0));
		}
		return email;
	}

	public void updatePass(String pass, int acc) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("update Users s set s.password=:pass where s.id=:id");
		q.setParameter("pass", pass);
		q.setParameter("id", acc);
		q.executeUpdate();
	}

//	@Test
//	public void run() {
//		List<Users> selectUser = selectUser(1, "");
//		System.out.println(selectUser);
//		Boolean checkAccount = checkAccount(1);
//		System.out.println(checkAccount);
//
//	}

}

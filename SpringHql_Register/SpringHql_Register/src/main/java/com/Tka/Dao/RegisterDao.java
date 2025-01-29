package com.Tka.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Tka.Entity.Register;

@Repository
public class RegisterDao {
	@Autowired
	SessionFactory factory;
	
	public String insertData(Register r) {
		Session ss=factory.openSession();
		Transaction tr=ss.beginTransaction();
		
		String hqlQuery="insert into Register(fName,lName,email,password,city,gender,age)values(:fName,:lName,:email,:password,:city,:gender,:age)";
		MutationQuery query=ss.createMutationQuery(hqlQuery);
		query.setParameter("fName",r.getfName());
		query.setParameter("lName",r.getlNmae());
		query.setParameter("email",r.getEmail());
		query.setParameter("password",r.getPassword());
		query.setParameter("city",r.getCity());
		query.setParameter("gender",r.getGender());
		query.setParameter("age",r.getAge());
		query.executeUpdate();
		tr.commit();
		ss.close();
		return "Data inserted..";
		
	}
	public String updateData(Register r,int id) {
		Session ss=factory.openSession();
		Transaction tr=ss.beginTransaction();
		
		String hqlQuery="update Register set fName=:fName,lName=:lName,email=:email,password=:password,city=:city,gender=:gender,age=:age where id=:id";
		MutationQuery query=ss.createMutationQuery(hqlQuery);
		query.setParameter("id", id);
		query.setParameter("fName",r.getfName());
		query.setParameter("lName",r.getlNmae());
		query.setParameter("email",r.getEmail());
		query.setParameter("password",r.getPassword());
		query.setParameter("city",r.getCity());
		query.setParameter("gender",r.getGender());
		query.setParameter("age",r.getAge());
		query.executeUpdate();
		tr.commit();
		ss.close();
		return "Data Updated..";
	}
	
	public String deleteData(int id) {
		Session ss=factory.openSession();
		Transaction tr=ss.beginTransaction();
		
		String hqlQuery="delete from Register where id=:id";
		MutationQuery query=ss.createMutationQuery(hqlQuery);
		query.setParameter("id", id);
		query.executeUpdate();
		tr.commit();
		ss.close();
		return "Data deleted";
	}
	public Register getSingleRec(int id) {
		Session ss=factory.openSession();
		Transaction tr=ss.beginTransaction();
		
		String hqlQuery="from Register where id=:id";
		Query<Register> query=ss.createQuery(hqlQuery,Register.class);
		query.setParameter("id", id);
		Register r=query.getSingleResult();
		tr.commit();
		ss.close();
		return r;
	}
	
	public List<Register> getAll() {
		Session ss=factory.openSession();
		Transaction tr=ss.beginTransaction();
		
		String hqlQuery="from Register";
		Query<Register> query=ss.createQuery(hqlQuery,Register.class);
		List<Register>list=query.getResultList();
		tr.commit();
		ss.close();
		return list;
		}
	
	
}

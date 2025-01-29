package com.Tka.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Tka.Entity.Student;

@Repository
public class StudentDao {
	
	@Autowired
	SessionFactory factory;
	
	public String insertData(Student s) {
		Session ss=factory.openSession();
		Transaction tr=ss.beginTransaction();
		String hqlQuery="insert into Student(id,name)values(:Myid,:Myname)";
		MutationQuery query=ss.createMutationQuery(hqlQuery);
		query.setParameter("Myid",s.getId());
		query.setParameter("Myname",s.getName());
		query.executeUpdate();
		tr.commit();
		ss.close();
		return "Data inserted...";
	}
	
	public String deleteData(int id) {
		Session ss=factory.openSession();
		Transaction tr=ss.beginTransaction();
		String hqlQuery="delete from Student where id=:id";
		MutationQuery query=ss.createMutationQuery(hqlQuery);
		query.setParameter("id",id);
		query.executeUpdate();
		tr.commit();
		ss.close();
		return "Data Deleted...";
	}
	
	public Student getSingleData(int id) {
		Session ss=factory.openSession();
		Transaction tr=ss.beginTransaction();
		String hqlQuery="from Student where id=:id";
		Query<Student> query=ss.createQuery(hqlQuery,Student.class);
		query.setParameter("id", id);
		Student s=query.getSingleResult();
		tr.commit();
		ss.close();
		return s;
	}
	
	public String updateData(Student s1,int id) {
		Session ss=factory.openSession();
		Transaction tr=ss.beginTransaction();
		String hqlQuery="update   Student set name=:MyName where id=:id";
		MutationQuery query=ss.createMutationQuery(hqlQuery);
		query.setParameter("id", id);
		query.setParameter("MyName",s1.getName());
		query.executeUpdate();
		tr.commit();
		ss.close();  
		return "Data Updated...";
	}
	public List<Student> getAll() {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		String hqlQuery = "from Student";
		Query<Student> query = ss.createQuery(hqlQuery, Student.class);
		List<Student> list = query.list();
		tr.commit();
		ss.close();
		return list;
	}
	
}

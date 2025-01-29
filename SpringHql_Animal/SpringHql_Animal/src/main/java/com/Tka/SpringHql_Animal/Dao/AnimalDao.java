package com.Tka.SpringHql_Animal.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Tka.SpringHql_Animal.Entity.Animal;

@Repository
public class AnimalDao {
	
	@Autowired 
	SessionFactory factory;
	
	public String insertData(Animal a) {		
		Session ss=factory.openSession();
		Transaction tr=ss.beginTransaction();
		
		String hqlQuery="insert into Animal(name,color,age,weight)values(:Myname,:Mycolor,:Myage,:Myweight)";
		MutationQuery query=ss.createMutationQuery(hqlQuery);
		query.setParameter("Myname",a.getName());
		query.setParameter("Mycolor", a.getColor());
		query.setParameter("Myage", a.getAge());
		query.setParameter("Myweight", a.getWeight());
		query.executeUpdate();
		tr.commit();
		ss.close();
		return "Data inserted...";
	}
	
	public Animal getSingleData(int id) {
		Session ss=factory.openSession();
		Transaction tr=ss.beginTransaction();
		String hqlQuery="from Animal Where id=:id";
		Query<Animal>query=ss.createQuery(hqlQuery,Animal.class);
		query.setParameter("id", id);
		Animal a=query.getSingleResult();
		tr.commit();
		ss.close();
		return a;
	}
	
	public List<Animal> getAll(){
		Session ss=factory.openSession();
		Transaction tr=ss.beginTransaction();
		
		String hqlQuery="from Animal";
		Query<Animal>query=ss.createQuery(hqlQuery,Animal.class);
		List<Animal>list=query.getResultList();
		tr.commit();
		ss.close();
		return list;
		
	}
	
	public String UpdateData(Animal a,int id) {
		Session ss=factory.openSession();
		Transaction tr=ss.beginTransaction();
		String hqlQuery="update Animal set name=:Myname,color=:Mycolor,age=:Myage,weight=:Myweight where id=:id";
		MutationQuery query=ss.createMutationQuery(hqlQuery);
		query.setParameter("id", id);
		query.setParameter("Myname", a.getName());
		query.setParameter("Mycolor", a.getColor());
		query.setParameter("Myage", a.getAge());
		query.setParameter("Myweight", a.getWeight());
		query.executeUpdate();
		tr.commit();
		ss.close();
		return "Data updated";
	}
	
	public String deleteData(int id) {
		Session ss=factory.openSession();
		Transaction tr=ss.beginTransaction();
		 String hqlQuery="delete from Animal where id=:id";
		 
		 MutationQuery query=ss.createMutationQuery(hqlQuery);
		 query.setParameter("id",id);
		 query.executeUpdate();
		 tr.commit();
		 ss.close();
		 return"Data deleted...";
		 
		
	}
	
	

}

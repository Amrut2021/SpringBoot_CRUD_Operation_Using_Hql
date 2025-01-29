package com.Tka.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Tka.Entity.Book;

@Repository
public class BookDao {
	
	@Autowired
	SessionFactory factory;
	
	public String insertData(Book b) {
		Session	session=factory.openSession();
		Transaction	tr= session.beginTransaction();
		String hqlQuery="insert into Book(name,author,language,price)values(:name,:author,:language,:price)";
		MutationQuery query=session.createMutationQuery(hqlQuery);
			query.setParameter("name",b.getName());
			query.setParameter("author",b.getAuthor());
			query.setParameter("language",b.getLanguage());
			query.setParameter("price",b.getPrice());
			query.executeUpdate();
			tr.commit();
			session.close();
			return"Data inserted";
	}
	
	public Book singleData(int id) {
		Session ss=factory.openSession();
		Transaction tr=ss.beginTransaction();
		
		String hqlQuery="from Book where id=:id";
		Query<Book> query=ss.createQuery(hqlQuery,Book.class);
		query.setParameter("id", id);
		Book b=query.getSingleResult();
		tr.commit();
		ss.close(); 
		return b;	
	}
	public List<Book> getAll(){
		Session session=factory.openSession();
		Transaction tr=session.beginTransaction();
		
		String hqlQuery="from Book";
		Query<Book>query=session.createQuery(hqlQuery,Book.class);
		List<Book>list=query.getResultList();
		tr.commit();
		session.close();
		return list;		
	}
	public String deleteData(int id) {
		Session ss=factory.openSession();
		Transaction tr=ss.beginTransaction();
		
		String hqlQuery="delete from Book where id=:id";
		MutationQuery query=ss.createMutationQuery(hqlQuery);
		query.setParameter("id", id);
		query.executeUpdate();
		tr.commit();
		ss.close();
		return "Data is deleted...";		
	}
	public String updateData(Book b,int id) {
		Session ss=factory.openSession();
		Transaction tr=ss.beginTransaction();
		
		String hqlQuery="update Book set name=:name,author=:author,language=:language,price=:price where id=:id";
		MutationQuery query=ss.createMutationQuery(hqlQuery);
		query.setParameter("id", id);
		query.setParameter("name",b.getName());
		query.setParameter("author", b.getAuthor());
		query.setParameter("language", b.getLanguage());
		query.setParameter("price",b.getPrice());
		query.executeUpdate();
		tr.commit();
		ss.close(); 
		return"Data Updated..";
	}
	

}

package com.Tka.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tka.Dao.BookDao;
import com.Tka.Entity.Book;

@Service
public class BookService {
	@Autowired
	BookDao dao;
	
	public String insertData(Book b) {
		String msg=dao.insertData(b);
		return msg;
	}
	
	public Book singleData(int id) {
	    Book b=dao.singleData(id);
	    return b;		
	}
	public List<Book>getAll(){
		List<Book>list=dao.getAll();
		return list;
	}

	public String updateData(Book b ,int id) {
		String msg=dao.updateData(b, id);
		return msg;
	}
}

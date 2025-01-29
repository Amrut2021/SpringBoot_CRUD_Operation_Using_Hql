package com.Tka.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tka.Dao.StudentDao;
import com.Tka.Entity.Student;

@Service
public class StudentService {
	
	@Autowired
	StudentDao Dao;
	
	public String insertData(Student s) {
		String msg=Dao.insertData(s);
		return msg;
	}
	
	public String deleteData(int id) {
		String msg=Dao.deleteData(id);
		return msg;
	}
	public Student getSingleData(int id) {
		Student msg=Dao.getSingleData(id);
		return msg;
	}
	
	public String updateData(Student s,int id) {
		String msg=Dao.updateData(s, id);
		return msg;
		
	}
	
	public List<Student> getAll(){
		List<Student>list=Dao.getAll();
		return list;
	}

}

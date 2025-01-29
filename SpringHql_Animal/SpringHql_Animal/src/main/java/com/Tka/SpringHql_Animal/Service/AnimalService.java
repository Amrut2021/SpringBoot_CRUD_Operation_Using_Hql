package com.Tka.SpringHql_Animal.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tka.SpringHql_Animal.Dao.AnimalDao;
import com.Tka.SpringHql_Animal.Entity.Animal;

@Service

public class AnimalService {
	
	@Autowired
	AnimalDao dao;
	
	public String insertData(Animal a) {
		String msg=dao.insertData(a);
		return msg;	
	}
	public Animal getSingleData(int id) {
		Animal msg=dao.getSingleData(id);
		return msg;
	}
	public List<Animal> getAll(){
		List<Animal>list=dao.getAll();
		return list;
	}
	public String updateData(Animal a,int id) {
		String msg=dao.UpdateData(a, id);
		return msg;
	}
	
	public String deleteData(int id) {
		String msg=dao.deleteData(id);
		return msg;
	}

}

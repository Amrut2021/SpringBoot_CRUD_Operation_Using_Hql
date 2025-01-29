package com.Tka.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tka.Dao.RegisterDao;
import com.Tka.Entity.Register;

@Service
public class RegisterService {
	@Autowired
	RegisterDao dao;
	
	public String insertData (Register r) {
		String msg=dao.insertData(r);
		return msg;
	}
	public String updateData(Register r,int id) {
		String msg=dao.updateData(r,id);
		return msg;
	}
	
	public String deleteData(int id) {
		String msg=dao.deleteData(id);
		return msg;		
	}
	public Register getSingleRec(int id) {
		Register msg=dao.getSingleRec(id);
		return msg;
	}
	
	public List<Register>getAll(){
		List<Register>list=dao.getAll();
		return list;
	}
	

}

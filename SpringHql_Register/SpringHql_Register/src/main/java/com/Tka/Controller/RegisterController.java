package com.Tka.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Tka.Entity.Register;
import com.Tka.Service.RegisterService;
@RestController
public class RegisterController {
	
	@Autowired
	RegisterService service;
	
	@PostMapping("/RegisterSaveData")
	public String insertData (@RequestBody Register r) {
		String msg=service.insertData(r);
		return msg;
	}
	@PutMapping("/RegisterUpdateData/{id}")
	public String updateData(@RequestBody Register r,@PathVariable int id) {
		String msg=service.updateData(r,id);
		return msg;
	}
	@DeleteMapping("/RegisterDeleteData/{id}")
	public String deleteData(@PathVariable int id) {
		String msg=service.deleteData(id);
		return msg;		
	}
	@GetMapping("/RegisterGetSingle/{id}")
	public Register getSingleRec(@PathVariable int id) {
		Register msg=service.getSingleRec(id);
		return msg;
	}
	@GetMapping("/RegisterGetAll")
	public List<Register>getAll(){
		List<Register>list=service.getAll();
		return list;
	}

}

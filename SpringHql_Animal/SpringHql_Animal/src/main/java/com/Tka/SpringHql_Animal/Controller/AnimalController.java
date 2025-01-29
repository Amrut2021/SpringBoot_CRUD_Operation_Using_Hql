package com.Tka.SpringHql_Animal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Tka.SpringHql_Animal.Entity.Animal;
import com.Tka.SpringHql_Animal.Service.AnimalService;

@RestController
public class AnimalController {
	@Autowired
	AnimalService service;
	
	
	@PostMapping("/AnimalSaveData")
	public String insertData(@RequestBody Animal a) {
		String msg=service.insertData(a);
		return msg;
	}
	@GetMapping("/AnimalSingleData/{id}")
	public Animal getSingleData(@PathVariable int id) {
		Animal msg=service.getSingleData(id);
		return msg; 
	}
	
	@GetMapping("/AnimalGetAll")
	public List<Animal> getAll(){
		List<Animal>list=service.getAll();
		return list;
	}
	
	@PutMapping("/AnimalUpdateData/{id}")
	public String updateData(@RequestBody Animal a,@PathVariable int id) {
		String msg=service.updateData(a, id);
		return msg;
	}
	
	@DeleteMapping("/AnimalDeleteData")
	public String deleteData(@RequestParam int id) {
		String msg=service.deleteData(id);
		return msg;
	}

}

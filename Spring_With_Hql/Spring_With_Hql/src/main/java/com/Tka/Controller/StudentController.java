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

import com.Tka.Entity.Student;
import com.Tka.Service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService Service;
	
	@PostMapping("/StudentSave")
	public String insertData(@RequestBody Student s) {
		String msg=Service.insertData(s);
		return msg;
	}
	
	@DeleteMapping("/StudentDelete/{id}")
	public String deleteData(@PathVariable int id) {
		String msg=Service.deleteData(id);
		return msg;
	}
	
	@GetMapping("/StudentGetSingle/{id}")
	public Student getSingleData(@PathVariable int id) {
	Student msg=Service.getSingleData( id);
		return msg;
	}
	@PutMapping("/StudentUpdate/{id}")
	public String updateData(@RequestBody Student s, @PathVariable int id) {
		String msg=Service.updateData(s,id);
		return msg;
		
	}
	@GetMapping("/StudentGetAll")
	public List<Student> getAll(){
		List<Student>list=Service.getAll();
		return list;
	}


}

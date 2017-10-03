package com.restexample.restspringboot.student;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class StudentController {
	
	@Autowired
	private StudentServices studentServices;
	
	@RequestMapping("/students")
	public List<Student> getAllStudents(){
		return studentServices.getAllStudents();
		
	}
	
	@RequestMapping("/students/{id}")
	public Student getStudent(@PathVariable String id){
		return studentServices.getStudent(id);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/students")
	public void addStudent(@RequestBody Student id){
		studentServices.addStudent(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/students/{name}")
	public void updateStudent(@PathVariable String id,@RequestBody Student student){
		studentServices.updateStudent(id, student);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/students/{id}")
	public void removeStudent(@PathVariable String id){
		studentServices.removeStudent(id);
	}
}

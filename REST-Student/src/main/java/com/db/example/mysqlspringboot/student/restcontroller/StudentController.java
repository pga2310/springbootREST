package com.db.example.mysqlspringboot.student.restcontroller;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RestController;

import com.db.example.mysqlspringboot.student.model.Student;
import com.db.example.mysqlspringboot.student.service.StudentService;

@RestController
@CrossOrigin
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/students")
	public List<Student> getAll(){
		return studentService.getAll();
	}
	
	@RequestMapping(value = "/students/{id}", method=RequestMethod.GET)
	public Student getStudent(@PathVariable int id){
		return studentService.getStudent(id);
	}
	
	@RequestMapping(value = "/students", method = RequestMethod.POST)
	public void addStudent(@RequestBody Student student){
		studentService.addStudent(student);
	}
	
	@RequestMapping(value="/students/{id}", method = RequestMethod.PUT)
	public void updateStudent(@RequestBody Student student){
		studentService.updateStudent(student);
	}
	
	@RequestMapping(value="/students/{id}", method=RequestMethod.DELETE)
	public void removeStudent(@PathVariable int id){
		studentService.removeStudent(id);
	}
	
}


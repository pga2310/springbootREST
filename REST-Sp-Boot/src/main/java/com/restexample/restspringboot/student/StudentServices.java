package com.restexample.restspringboot.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServices {
	
	@Autowired
	private StudentInterface studentInterface;
	
	

	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		List<Student> list = new ArrayList<>();
		studentInterface.findAll().forEach(list :: add);
		return list;
	}

	public Student getStudent(String id) {
		// TODO Auto-generated method stub
		return studentInterface.findOne(id);
	}

	public void addStudent(Student id) {
		// TODO Auto-generated method stub
		studentInterface.save(id);
	}

	public void updateStudent(String id, Student student) {
		// TODO Auto-generated method stub
		studentInterface.save(student);		
	}

	public void removeStudent(String id) {
		// TODO Auto-generated method stub
		studentInterface.delete(id);
		}

}

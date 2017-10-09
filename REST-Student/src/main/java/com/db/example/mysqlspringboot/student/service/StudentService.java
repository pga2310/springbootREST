package com.db.example.mysqlspringboot.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.example.mysqlspringboot.student.model.Student;
import com.db.example.mysqlspringboot.student.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAll(){
		List<Student> list = new ArrayList<>();
		studentRepository.findAll().forEach(list :: add);
		return list;
	}

	public Student getStudent(int id){
		return studentRepository.findOne(id);
	}
	
	public void addStudent(Student student){
		studentRepository.save(student);
	}
	
	public void updateStudent(Student student){
		studentRepository.save(student);
	}
	
	public void removeStudent(int id){
		studentRepository.delete(id);
	}
	
}

package com.db.example.mysqlspringboot.student.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Course{

	 
	@Id
	private int id;
	private String name;
	private double credit;
	
	@ManyToOne
	@JsonIgnore
	private Student student;
	
	public Course(){}
	
	public Course(int id, String name, double credit, int studentId) {
		super();
		this.id = id;
		this.name = name;
		this.credit = credit;
		this.setStudent(new Student(studentId, "", "", 0.0));
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}


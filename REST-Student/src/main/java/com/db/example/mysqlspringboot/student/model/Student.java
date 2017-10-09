package com.db.example.mysqlspringboot.student.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	private int id;
	private String name;
	private String major;
	private double gpa;
	
		
	public Student() {
		super();
	}
	
	public Student(int id, String name, String major, double gpa) {
		super();
		this.id = id;
		this.name = name;
		this.major = major;
		this.gpa = gpa;
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
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	
	
}

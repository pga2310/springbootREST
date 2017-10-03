package com.restexample.restspringboot.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.restexample.restspringboot.student.Student;

@Entity
public class Course {
	
	@Id
	private String id;
	private String name;
	private String major;
	private double credit;
	
	@ManyToOne
	private Student student;
	
	public Course(){}
	
	public Course(String id, String name, String major, double credit, String studentId) {
		super();
		this.id = id;
		this.name = name;
		this.major = major;
		this.credit = credit;
		this.setStudent(new Student(studentId, "", "", 0.0));
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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

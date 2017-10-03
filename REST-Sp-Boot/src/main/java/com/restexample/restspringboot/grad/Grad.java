package com.restexample.restspringboot.grad;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.restexample.restspringboot.course.Course;

@Entity
public class Grad {
	
	@Id
	private String id;
	private double gpa;
	
	@ManyToOne
	private Course course;
	
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Grad(){}
	
	public Grad(String id, double gpa, String courseid, String studentid) {
		super();
		this.id = id;
		this.gpa = gpa;
		this.course = new Course(courseid, "", "", 0.0, studentid);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	

}

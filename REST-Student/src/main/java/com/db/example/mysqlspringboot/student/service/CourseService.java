package com.db.example.mysqlspringboot.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.example.mysqlspringboot.student.model.Course;
import com.db.example.mysqlspringboot.student.repository.CourseRepository;


@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(int studentid) {
		// TODO Auto-generated method stub
		List<Course> courses = new ArrayList<>();
		courseRepository.findByStudentId(studentid).forEach(courses :: add);
		return courses;
	}

	public Course getCourse(int studentid) {
		// TODO Auto-generated method stub
		return courseRepository.findOne(studentid);
	}

	public void addCourse(Course course) {
		// TODO Auto-generated method stub
	    courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		courseRepository.save(course);		
	}

	public void removeCourse(int id) {
		// TODO Auto-generated method stub
		courseRepository.delete(id);
		}

	
}

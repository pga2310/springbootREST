package com.restexample.restspringboot.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServices {
	
	@Autowired
	private CourseInterface courseInterface;
	
	

	public List<Course> getAllCourses(String studentid) {
		// TODO Auto-generated method stub
		List<Course> courses = new ArrayList<>();
		courseInterface.findByStudentId(studentid).forEach(courses :: add);;
		return courses;
	}

	public Course getCourse(String studentid) {
		// TODO Auto-generated method stub
		return courseInterface.findOne(studentid);
	}

	public void addCourse(Course id) {
		// TODO Auto-generated method stub
	    courseInterface.save(id);
	}

	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		courseInterface.save(course);		
	}

	public void removeCourse(String id) {
		// TODO Auto-generated method stub
		courseInterface.delete(id);
		}

}

package com.restexample.restspringboot.course;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restexample.restspringboot.student.Student;

@RestController
public class CourseController {
	
	@Autowired
	private CourseServices courseServices;
	
	@RequestMapping("/students/{studentid}/courses")
	public List<Course> getAllCourses(@PathVariable String studentid){
		return courseServices.getAllCourses(studentid);
		
	}
	
	@RequestMapping("/students/{studentid}/courses/{id}")
	public Course getCourse( @PathVariable String studentid, @PathVariable String id){
		return courseServices.getCourse(id);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/students/{studentid}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String studentid){
		course.setStudent(new Student(studentid,"","",0.00));
		courseServices.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/students/{studentid}/courses/{id}")
	public void updateCourse(@PathVariable String studetnid,@RequestBody Course course,@PathVariable String id){
		course.setStudent(new Student(studetnid,"","",0.00));		
		courseServices.updateCourse(course);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/students/{studentid}/courses/{id}")
	public void removeCourse(@PathVariable String id){
		courseServices.removeCourse(id);
	}
}

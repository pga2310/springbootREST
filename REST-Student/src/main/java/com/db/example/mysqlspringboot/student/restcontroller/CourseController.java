package com.db.example.mysqlspringboot.student.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.db.example.mysqlspringboot.student.model.Course;
import com.db.example.mysqlspringboot.student.model.Student;
import com.db.example.mysqlspringboot.student.service.CourseService;


@RestController
@CrossOrigin
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/students/{studentid}/courses")
	public List<Course> getAllCourses(@PathVariable int studentid){
		return courseService.getAllCourses(studentid);
		
	}
	
	@RequestMapping("/students/{studentid}/courses/{id}")
	public Course getCourse( @PathVariable int studentid, @PathVariable int id){
		return courseService.getCourse(id);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/students/{studentid}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable int studentid){
		course.setStudent(new Student(studentid,"","",0.00));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/students/{studentid}/courses/{id}")
	public void updateCourse(@PathVariable int studentid,@RequestBody Course course,@PathVariable int id){
		course.setStudent(new Student(studentid,"","",0.00));		
		courseService.updateCourse(course);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/students/{studentid}/courses/{id}")
	public void removeCourse(@PathVariable int id){
		courseService.removeCourse(id);
	}

}

package com.restexample.restspringboot.grad;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restexample.restspringboot.course.Course;

@RestController
public class GradController {
	
	@Autowired
	private GradServices gradServices;
	
	@RequestMapping("/students/{studentid}/courses/{courseid}/grads")
	public List<Grad> getAllGrads(@PathVariable String courseid){
		return gradServices.getAllGrads(courseid);
		
	}
	
	@RequestMapping("/students/{studentid}/courses/{courseid}/grads/{id}")
	public Grad getGrad(@PathVariable String id){
		return gradServices.getGrad(id);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/students/{studentid}/courses/{courseid}/grads")
	public void addGrad(@RequestBody Grad grad, @PathVariable String courseid, @PathVariable String studentid){
		grad.setCourse(new Course(courseid,"","",0.0,studentid));
		gradServices.addGrad(grad);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/students/{studentid}/courses/{courseid}/grads/{id}")
	public void updateGrad(@PathVariable String studentid, @PathVariable String courseid, @RequestBody Grad grad){
		grad.setCourse(new Course(courseid,"","",0.0,studentid));
		gradServices.updateGrad(courseid, grad);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/students/{studentid}/courses/{courseid}/grads/{id}")
	public void removeGrad(@PathVariable String id){
		gradServices.removeGrad(id);
	}
}

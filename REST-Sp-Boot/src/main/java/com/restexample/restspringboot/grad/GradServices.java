package com.restexample.restspringboot.grad;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradServices {
	
	@Autowired
	private GradInterface gradInterface;
	
	

	public List<Grad> getAllGrads(String courseid) {
		// TODO Auto-generated method stub
		List<Grad> list = new ArrayList<>();
		gradInterface.findByCourseId(courseid).forEach(list :: add);
		return list;
	}

	public Grad getGrad(String id) {
		// TODO Auto-generated method stub
		return gradInterface.findOne(id);
	}

	public void addGrad(Grad id) {
		// TODO Auto-generated method stub
		gradInterface.save(id);
	}

	public void updateGrad(String id, Grad student) {
		// TODO Auto-generated method stub
		gradInterface.save(student);		
	}

	public void removeGrad(String id) {
		// TODO Auto-generated method stub
		gradInterface.delete(id);
	}

}

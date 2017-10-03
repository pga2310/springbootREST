package com.restexample.restspringboot.grad;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
 

public interface GradInterface extends JpaRepository<Grad, String> {

	public List<Grad> findByCourseId(String courseid);
}

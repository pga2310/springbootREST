package com.restexample.restspringboot.course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseInterface extends JpaRepository<Course, String> {

	public List<Course> findByStudentId(String studentid);
}

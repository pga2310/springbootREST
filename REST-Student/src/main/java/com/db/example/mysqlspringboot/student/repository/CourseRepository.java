package com.db.example.mysqlspringboot.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.example.mysqlspringboot.student.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	public List<Course> findByStudentId(int studentId);
}

package com.db.example.mysqlspringboot.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.example.mysqlspringboot.student.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}

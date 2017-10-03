package com.restexample.restspringboot.student;

import org.springframework.data.jpa.repository.JpaRepository;
 

public interface StudentInterface extends JpaRepository<Student, String> {

}

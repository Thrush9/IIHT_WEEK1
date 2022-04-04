package com.marksapp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marksapp.main.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	public Student findByName(String name);

}

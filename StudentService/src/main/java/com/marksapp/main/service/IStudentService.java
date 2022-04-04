package com.marksapp.main.service;

import java.util.List;

import com.marksapp.main.exception.StudentAlreadyExistsException;
import com.marksapp.main.exception.StudentNotFoundException;
import com.marksapp.main.model.Student;

public interface IStudentService {

	public Student saveStudentDetails(Student student) throws StudentAlreadyExistsException;

	public List<Student> fetchAllStudentsDetails();

	public Student fetchSpecificStudentDetails(Long id) throws StudentNotFoundException;

}

package com.marksapp.main.service;

import java.rmi.StubNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marksapp.main.exception.StudentAlreadyExistsException;
import com.marksapp.main.exception.StudentNotFoundException;
import com.marksapp.main.model.Student;
import com.marksapp.main.repository.StudentRepository;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	StudentRepository studentRepo;

	@Override
	public Student saveStudentDetails(Student student) throws StudentAlreadyExistsException {
		Student search = studentRepo.findByName(student.getName());
		if(search != null) {
			throw new StudentAlreadyExistsException("Student Already Exist With Provided Name");
		}
		Student added = studentRepo.save(student);
		return added;
	}

	@Override
	public List<Student> fetchAllStudentsDetails() {
		List<Student> studentsList = studentRepo.findAll();
		return studentsList;
	}

	@Override
	public Student fetchSpecificStudentDetails(Long id) throws StudentNotFoundException {
		Optional<Student> search = studentRepo.findById(id);
		if(search.isEmpty()) {
			throw new StudentNotFoundException("Student Not Found with Provided Id");
		}
		return search.get();
	}
}

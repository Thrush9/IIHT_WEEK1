package com.marksapp.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.marksapp.main.model.MarksList;
import com.marksapp.main.model.Student;
import com.marksapp.main.service.IStudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	IStudentService studentService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@PostMapping("/saveStudent")
	public ResponseEntity<?> saveStudent(@RequestBody Student student) {
		try {
			Student addedStudent = studentService.saveStudentDetails(student);
			return new ResponseEntity<Student>(addedStudent, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/allStudents")
	public ResponseEntity<?> getAllStudents(){
		try {
			List<Student> studentList = studentService.fetchAllStudentsDetails();
			return new ResponseEntity<List<Student> >(studentList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/findStudent/{id}")
	public ResponseEntity<?> getSpecificStudent(@PathVariable Long id){
		try {
			Student student = studentService.fetchSpecificStudentDetails(id);
			List<MarksList> marks=  restTemplate.getForObject("http://MarksService/marks/getStudentMarks/" + id, List.class);
			student.setMarksList(marks);
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}

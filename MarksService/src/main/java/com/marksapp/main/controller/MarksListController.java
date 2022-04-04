package com.marksapp.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marksapp.main.model.MarksList;
import com.marksapp.main.service.IMarksListService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/marks")
public class MarksListController {

	@Autowired
	IMarksListService marksListService;
	
	@PostMapping("/saveMarks")
	public ResponseEntity<?> saveMarksdetails(@RequestBody MarksList marks){
		try {
			MarksList addedMarks = marksListService.saveStudentMarksdetails(marks);
			return new ResponseEntity<MarksList>(addedMarks, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getStudentMarks/{id}")
	public ResponseEntity<?> getStudentMarks(@PathVariable Long id){
		try {
			List<MarksList> studentMarks = marksListService.getStudentMarksDetails(id);
			return new ResponseEntity<List<MarksList>>(studentMarks, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getStudentMarksByTerm/{id}/{term}")
	public ResponseEntity<?> getStudentMarksByTerm(@PathVariable Long id,@PathVariable String term){
		try {
			MarksList studentMarks = marksListService.getStudentMarksDetailsByTerm(id,term);
			return new ResponseEntity<MarksList>(studentMarks, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}

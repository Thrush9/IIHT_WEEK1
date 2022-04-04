package com.marksapp.main.service;

import java.util.List;

import com.marksapp.main.exception.MarksListAlreadyExistsException;
import com.marksapp.main.exception.MarksListNotFoundException;
import com.marksapp.main.model.MarksList;

public interface IMarksListService {

	public MarksList saveStudentMarksdetails(MarksList marks) throws MarksListAlreadyExistsException;

	public List<MarksList> getStudentMarksDetails(Long id);

	public MarksList getStudentMarksDetailsByTerm(Long id, String term) throws MarksListNotFoundException;

}

package com.marksapp.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marksapp.main.exception.MarksListAlreadyExistsException;
import com.marksapp.main.exception.MarksListNotFoundException;
import com.marksapp.main.model.MarksList;
import com.marksapp.main.repository.MarksListRepository;

@Service
public class MarksListServiceImpl implements IMarksListService {
	
	@Autowired
	MarksListRepository marksListRepo;

	@Override
	public MarksList saveStudentMarksdetails(MarksList marks) throws MarksListAlreadyExistsException {
		MarksList search = marksListRepo.findByStudentIdAndTerm(marks.getStudentId(), marks.getTerm());
		if(search != null) {
			throw new MarksListAlreadyExistsException("Marks Already Exists with Provided StudentId and Term"); 
		}
		MarksList added = marksListRepo.save(marks);
		return added;
	}

	@Override
	public List<MarksList> getStudentMarksDetails(Long id) {
		List<MarksList> list = marksListRepo.findByStudentId(id);
		return list;
	}

	@Override
	public MarksList getStudentMarksDetailsByTerm(Long id, String term) throws MarksListNotFoundException {
		MarksList search = marksListRepo.findByStudentIdAndTerm(id, term);
		if(search == null) {
			throw new MarksListNotFoundException("Marks not found with Provided StudentId and Term"); 
		}
		return search;
	}

}

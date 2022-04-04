package com.marksapp.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marksapp.main.model.MarksList;

public interface MarksListRepository extends JpaRepository<MarksList, Long> {

	public MarksList findByStudentIdAndTerm(Long student_id, String term);

	public List<MarksList> findByStudentId(Long id);
}

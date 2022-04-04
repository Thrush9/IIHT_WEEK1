package com.marksapp.main.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "marks_list")
public class MarksList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Integer maths;
	
	private Integer science;
	
	private Integer english;
	
	private Integer others;
	
	private Integer total;
	
	private Boolean status;
	
	private String term;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId")
	private Student student;

	public MarksList() {
		super();
	}

	public MarksList(Long id, Integer maths, Integer science, Integer english, Integer others, Integer total,
			Boolean status,String term, Student student) {
		super();
		this.id = id;
		this.maths = maths;
		this.science = science;
		this.english = english;
		this.others = others;
		this.total = total;
		this.status = status;
		this.term = term;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMaths() {
		return maths;
	}

	public void setMaths(Integer maths) {
		this.maths = maths;
	}

	public Integer getScience() {
		return science;
	}

	public void setScience(Integer science) {
		this.science = science;
	}

	public Integer getEnglish() {
		return english;
	}

	public void setEnglish(Integer english) {
		this.english = english;
	}

	public Integer getOthers() {
		return others;
	}

	public void setOthers(Integer others) {
		this.others = others;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	@Override
	public String toString() {
		return "MarksList [id=" + id + ", maths=" + maths + ", science=" + science + ", english=" + english
				+ ", others=" + others + ", total=" + total + ", status=" + status + ", term=" + term + ", student="
				+ student + "]";
	}
	
}

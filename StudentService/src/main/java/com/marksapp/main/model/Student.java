package com.marksapp.main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long studentId;
	
	private String name;
	
	private Integer standard;
	
	private String section;
	
	private Integer rollNo;
	
	@OneToMany(mappedBy = "student")
	private List<MarksList>  marksList = new ArrayList<>();
	
	public Student() {
		
	}
	
	public Student(Long id, String name, Integer std, String section, Integer roll) {
		this.studentId = id;
		this.name = name;
		this.standard = std;
		this.section = section;
		this.rollNo = roll;
	}
	

	public Student(Long studentId, String name, Integer standard, String section, Integer rollNo,
			List<MarksList> marks) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.standard = standard;
		this.section = section;
		this.rollNo = rollNo;
		this.marksList = marks;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStandard() {
		return standard;
	}

	public void setStandard(Integer standard) {
		this.standard = standard;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	public List<MarksList> getMarksList() {
		return marksList;
	}

	public void setMarksList(List<MarksList> marks) {
		this.marksList = marks;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", standard=" + standard + ", section=" + section
				+ ", rollNo=" + rollNo + "]";
	}
	
}

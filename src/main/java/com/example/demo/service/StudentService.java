package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {
	
	public List<Student> findAll();
	
	public Student findById(int theId);
	
	public void save(Student student);
	
	public void deleteById(int theId);
	
}

package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Teacher;

public interface TeacherService {
	
	public List<Teacher> findAll();
	
	public Teacher findById(int theId);
	
	public void save(Teacher teacher);
	
	public void deleteById(int theId);

}

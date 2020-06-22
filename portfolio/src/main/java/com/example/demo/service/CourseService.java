package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Course;

public interface CourseService {
	
	public List<Course> findAll();
	
	public Course findById(int theId);
	
	public void save(Course theCourse);
	
	public void deleteById(int theId);

}

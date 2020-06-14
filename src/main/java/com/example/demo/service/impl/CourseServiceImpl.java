package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseRepository;
import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{
	
	private CourseRepository courseRepository;
	
	@Autowired
	public CourseServiceImpl(CourseRepository courseRepository) {
		this.courseRepository= courseRepository;
	}

	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	@Override
	public Course findById(int theId) {
		Optional<Course> result = courseRepository.findById(theId);
		
		Course course = result.get();
		
		return course;
	}

	@Override
	public void save(Course theCursoAluno) {
		
		courseRepository.save(theCursoAluno);
		
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		
	}

}

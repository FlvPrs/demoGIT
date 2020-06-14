package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Lesson;

public interface LessonService {
	
	public List<Lesson> findAll();
	
	public Lesson findById(int theId);
	
	public void save(Lesson lesson);
	
	public void deleteById(int theId);

}

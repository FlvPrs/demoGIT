package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LessonRepository;
import com.example.demo.entity.Lesson;
import com.example.demo.service.LessonService;

@Service
public class LessonServiceImpl implements LessonService {
	
	private LessonRepository lessonRepository;
	
	@Autowired
	public LessonServiceImpl(LessonRepository lessonRepository) {
		this.lessonRepository = lessonRepository;
	}

	@Override
	public List<Lesson> findAll() {
		return lessonRepository.findAll();
	}

	@Override
	public Lesson findById(int theId) {
		
		Optional<Lesson> result = lessonRepository.findById(theId);
		
		Lesson lesson = result.get();
		
		return lesson;
	}

	@Override
	public void save(Lesson lesson) {
		lessonRepository.save(lesson);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub

	}

}

package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseLessonRepository;
import com.example.demo.entity.CourseLesson;
import com.example.demo.service.CourseLessonService;

@Service
public class CourseLessonServiceImpl implements CourseLessonService{
	
	private CourseLessonRepository courseLessonRepository;
	
	@Autowired
	public CourseLessonServiceImpl(CourseLessonRepository courseLessonRepository) {
		this.courseLessonRepository = courseLessonRepository;
	}

	@Override
	public List<CourseLesson> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseLesson findById(int theId) {
		
		Optional<CourseLesson> result = courseLessonRepository.findById(theId);
		
		CourseLesson courseLesson = null;
		
		if(result.isPresent()) {
			courseLesson = result.get();
		}
		
		return courseLesson;
	}

	@Override
	public void save(CourseLesson theCourseLesson) {
		courseLessonRepository.save(theCourseLesson);
	}

	@Override
	public void deleteById(int theId) {
		courseLessonRepository.deleteById(theId);		
	}

	@Override
	public CourseLesson findByCourseIdAndLessonId(Integer courseId, Integer lessonId) {
		return courseLessonRepository.findByCourseIdAndLessonId(courseId, lessonId);
	}

	@Override
	public List<CourseLesson> findByCourseId(int id) {
		return courseLessonRepository.findByCourseId(id);
	}

	@Override
	public List<CourseLesson> findByTeacherId(int id) {
		return courseLessonRepository.findByTeacherId(id);
	}

}

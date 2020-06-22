package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CourseLesson;

public interface CourseLessonService {
	
	public List<CourseLesson> findAll();
	
	public CourseLesson findById(int theId);
	
	public void save(CourseLesson theCourseLesson);
	
	public void deleteById(int theId);
	
	public CourseLesson findByCourseIdAndLessonId(Integer courseId, Integer lessonId);

	public List<CourseLesson> findByCourseId(int id);

	public List<CourseLesson> findByTeacherId(int id);

}

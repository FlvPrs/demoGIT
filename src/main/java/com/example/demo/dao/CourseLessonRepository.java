package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.CourseLesson;

public interface CourseLessonRepository extends JpaRepository<CourseLesson, Integer>{
	
	@Query("SELECT a FROM #{#entityName} a WHERE course_id = ?1 AND lesson_id = ?2")
	public CourseLesson findByCourseIdAndLessonId(int courseId, int lessonId);

	@Query("SELECT a FROM #{#entityName} a WHERE course_id = ?1")
	public List<CourseLesson> findByCourseId(int course_id);
	
	@Query("SELECT a FROM #{#entityName} a WHERE teacher_id = ?1")
	public List<CourseLesson> findByTeacherId(int id);
	
}

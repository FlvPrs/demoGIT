package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CourseLesson;
import com.example.demo.entity.PeriodTeacher;
import com.example.demo.entity.Teacher;

public interface PeriodTeacherService {
	
	public List<PeriodTeacher> findAll();
	
	public PeriodTeacher findById(int theId);
	
	public void save(PeriodTeacher thePeriodTeacher);
	
	public void deleteById(int theId);

	public void save(Teacher teacher);
	
	public List<PeriodTeacher> findByPeriodId(int period_id);

	public PeriodTeacher findByTeacherIdAndPeriodId(int teacherId, int periodId);

	public void removeTeacher(PeriodTeacher tempPeriodTeacher, CourseLesson tempCourseLessonService);

}

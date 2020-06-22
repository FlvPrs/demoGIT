package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseLessonRepository;
import com.example.demo.dao.PeriodTeacherRepository;
import com.example.demo.entity.CourseLesson;
import com.example.demo.entity.Period;
import com.example.demo.entity.PeriodTeacher;
import com.example.demo.entity.Teacher;
import com.example.demo.service.PeriodTeacherService;

@Service
public class PeriodTeacherServiceImpl implements PeriodTeacherService {
	
	private PeriodTeacherRepository periodTeacherRepository;
	private CourseLessonRepository courseLessonRepository;
	
	@Autowired
	public PeriodTeacherServiceImpl(PeriodTeacherRepository periodTeacherRepository,CourseLessonRepository courseLessonRepository) {
		this.periodTeacherRepository = periodTeacherRepository;
		this.courseLessonRepository = courseLessonRepository;
	}

	@Override
	public List<PeriodTeacher> findAll() {
		return periodTeacherRepository.findAll();
	}

	@Override
	public PeriodTeacher findById(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(PeriodTeacher thePeriodTeacher) {
		periodTeacherRepository.save(thePeriodTeacher);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(Teacher teacher) {
		
		for(Period p : teacher.getPeriods()) {
			PeriodTeacher temp = new PeriodTeacher();
			temp.setTeacher(teacher);
			temp.setPeriod(p);
			temp.setAvailable(true);
			periodTeacherRepository.save(temp);
		}
		
	}

	@Override
	public List<PeriodTeacher> findByPeriodId(int period_id) {
		return periodTeacherRepository.findByPeriodId(period_id);
	}

	@Override
	public PeriodTeacher findByTeacherIdAndPeriodId(int teacherId, int periodId) {
		return periodTeacherRepository.findByTeacherIdAndPeriodId(teacherId, periodId);
	}

	@Override
	public void removeTeacher(PeriodTeacher tempPeriodTeacher, CourseLesson tempCourseLessonService) {
		tempPeriodTeacher.setAvailable(true);
		tempCourseLessonService.setTeacher(null);
		courseLessonRepository.save(tempCourseLessonService);
		periodTeacherRepository.save(tempPeriodTeacher);
		
	}

}

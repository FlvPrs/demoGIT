package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.CourseLesson;
import com.example.demo.entity.PeriodTeacher;
import com.example.demo.entity.Teacher;
import com.example.demo.service.CourseLessonService;
import com.example.demo.service.CourseService;
import com.example.demo.service.LessonService;
import com.example.demo.service.PeriodTeacherService;

@Controller
@RequestMapping("/coursesAndLessons")
public class CourseLessonController {
	
	private CourseLessonService courseLessonService;
	private LessonService lessonService;
	private CourseService courseService;
	private PeriodTeacherService periodTeacherService;
	
	@Autowired
	public CourseLessonController(CourseLessonService courseLessonService, LessonService lessonService, CourseService courseService,PeriodTeacherService periodTeacherService) {
		this.courseLessonService = courseLessonService;
		this.lessonService = lessonService;
		this.courseService = courseService;
		this.periodTeacherService = periodTeacherService;
	}
	
	@GetMapping("showFormForAddTeacher")
	public String showFormForAddTeacher(@RequestParam("courseId") int courseId,@RequestParam("lessonId") int lessonId,@RequestParam("periodId") int periodId, Model model) {
		
		CourseLesson courseLesson = courseLessonService.findByCourseIdAndLessonId(courseId, lessonId);
		courseLesson.setCourse(courseService.findById(courseId));
		courseLesson.setLesson(lessonService.findById(lessonId));
		List<PeriodTeacher> periodTeacher = periodTeacherService.findByPeriodId(periodId);
		List<Teacher> teachers = new ArrayList<Teacher>();
		
		for(PeriodTeacher temp : periodTeacher) {
			teachers.add(temp.getTeacher());
		}
		
		model.addAttribute("courseLesson",courseLesson);
		model.addAttribute("listTeacher",teachers);
		
		return "course/course-teacher-select";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("courseLesson") CourseLesson courseLesson) {
		PeriodTeacher tempTeacher = periodTeacherService.findByTeacherIdAndPeriodId(courseLesson.getTeacher().getId(), courseLesson.getCourse().getPeriod().getId());
		tempTeacher.setAvailable(false);
		periodTeacherService.save(tempTeacher);
		courseLessonService.save(courseLesson);
		
		return "redirect:/demo/home";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("courseLessonId") int theId) {
		
		courseLessonService.deleteById(theId);
		
		return "redirect:/demo/home";
		
	}
	
	@PostMapping("/courseAddLesson")
	public String addLesson(@ModelAttribute("courseLesson") CourseLesson courseLesson) {
		
		courseLessonService.save(courseLesson);
		
		return "redirect:/demo/home";
	}
	
	@GetMapping("/showFormForUpdateSemester")
	public String showFormForUpdateSemester(@RequestParam("courseLessonId") int theId,Model model) {
		
		CourseLesson courseLesson = courseLessonService.findById(theId);
		
		model.addAttribute("courseLesson",courseLesson);
		
		return "course/course-semester-list";
	}

}

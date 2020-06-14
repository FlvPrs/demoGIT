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
import com.example.demo.entity.Period;
import com.example.demo.entity.PeriodTeacher;
import com.example.demo.entity.Teacher;
import com.example.demo.service.CourseLessonService;
import com.example.demo.service.PeriodService;
import com.example.demo.service.PeriodTeacherService;
import com.example.demo.service.TeacherService;

@Controller
@RequestMapping("/teachers")
public class TeacherController {
	
	private TeacherService teacherService;
	private PeriodService periodService;
	private PeriodTeacherService periodTeacherService;
	private CourseLessonService courseLessonService;
	
	@Autowired
	public TeacherController(TeacherService teacherService, PeriodService periodService, PeriodTeacherService periodTeacherService, CourseLessonService courseLessonService) {
		this.teacherService = teacherService;
		this.periodService = periodService;
		this.periodTeacherService = periodTeacherService;
		this.courseLessonService = courseLessonService;
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Teacher teacher = new Teacher();
		List<Period> periods = periodService.findAll();
		
		model.addAttribute("teacher",teacher);
		model.addAttribute("periods",periods);
		
		return "teacher/teacher-form";
	}
	
	@GetMapping("/showList")
	public String showList(Model model) {
		Teacher teacher = new Teacher();
		List<CourseLesson> courseLessons = new ArrayList<CourseLesson>();
		
		model.addAttribute("teacher",teacher);
		model.addAttribute("courseLessons",courseLessons);
		
		return "teacher/teacher-list";
		
	}
	
	@GetMapping("findById")
	public String findById(@RequestParam("teacherId") int id, Model model) {
		
		Teacher teacher = teacherService.findById(id);
		List<CourseLesson> courseLessons = courseLessonService.findByTeacherId(id);
		
		model.addAttribute("teacher",teacher);
		model.addAttribute("courseLessons",courseLessons);
		
		return "teacher/teacher-list";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("teacher") Teacher teacher) {
		
		teacherService.save(teacher);
		
		periodTeacherService.save(teacher);
		
		return "redirect:/demo/home";
		
	}
	
	@GetMapping("removeLesson")
	public String removeLesson(@RequestParam("teacherId") int teacherId, @RequestParam("periodId") int periodId,@RequestParam("courseLessonId") int courseLessonId ) {
		
		PeriodTeacher tempPeriodTeacher = periodTeacherService.findByTeacherIdAndPeriodId(teacherId, periodId);
		CourseLesson tempCourseLessonService = courseLessonService.findById(courseLessonId);
		
		periodTeacherService.removeTeacher(tempPeriodTeacher,tempCourseLessonService);
		
		return "redirect:/teachers/showList";
	}

}

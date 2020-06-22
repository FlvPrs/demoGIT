package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Course;
import com.example.demo.entity.CourseLesson;
import com.example.demo.entity.Period;
import com.example.demo.entity.Teacher;
import com.example.demo.service.CourseLessonService;
import com.example.demo.service.CourseService;
import com.example.demo.service.PeriodService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	
	private CourseService courseService;
	
	private CourseLessonService courseLessonService;
	
	private PeriodService periodService;
	
	@Autowired
	public CourseController(CourseService courseService, CourseLessonService courseLessonService,PeriodService periodService) {
		this.courseService = courseService;
		this.courseLessonService = courseLessonService;
		this.periodService = periodService;
	}
	
	@GetMapping("/showList")
	public String showList(Model model) {
		
		Course course = new Course();
		Period p = new Period();
		p.setPeriod(null);
		course.setPeriod(p);
		
		model.addAttribute("course",course);
		
		return "course/course-list";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Course course= new Course();
		List<Period> listPeriod = periodService.findAll();
		
		model.addAttribute("course",course);
		model.addAttribute("listPeriod",listPeriod);
		
		return "course/course-form";
		
	}
	
	@GetMapping("/findById")
	public String findById(@RequestParam("courseId") int id, Model model) {
		
		Course course = courseService.findById(id);
		
		//Mapear lições pelo id do curso na tabela courseLessons
		List<CourseLesson> courseLesson = courseLessonService.findByCourseId(id);
		
		Teacher tempTeacher = new Teacher();
		
		for(CourseLesson t : courseLesson) {
			if(t.getTeacher() == null) {
				t.setTeacher(tempTeacher);
			}
		}
		
		model.addAttribute("course",course);
		model.addAttribute("courseLesson",courseLesson);
		
		return "course/course-list";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("course") Course course) {
		
		courseService.save(course);
		
		return  "redirect:/courses/findById?courseId=" + course.getId();
	}
	
	@PostMapping("/addLesson")
	public String addLesson(@ModelAttribute("course") Course course) {
		
		Course tempCourse = courseService.findById(course.getId());
		
		tempCourse.addLesson(course.getLessons().get(0));
		
		courseService.save(tempCourse);
		
		return "redirect:/courses/findById?courseId=" + course.getId();
	}

}

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
import com.example.demo.entity.Lesson;
import com.example.demo.service.CourseService;
import com.example.demo.service.LessonService;

@Controller
@RequestMapping("/lessons")
public class LessonController {
	
	private LessonService lessonService;
	private CourseService courseService;
	
	@Autowired
	public LessonController(LessonService lessonService, CourseService courseService) {
		this.lessonService = lessonService;
		this.courseService = courseService;
	}
	
	@GetMapping("/showList")
	public String showList(@RequestParam("courseId") int courseId, Model model) {
		
		Course course = courseService.findById(courseId);
		
		CourseLesson courseLesson = new CourseLesson();
		
		courseLesson.setCourse(course);
		
		List<Lesson> lessons = lessonService.findAll();
		
		for(Lesson tempLesson : lessonService.findAll()) {
			  for(Lesson tempCourseLesson : course.getLessons()) {
				  if(tempLesson.equals(tempCourseLesson)) {
					  lessons.remove(tempCourseLesson);
				  }
			  }
		}
		
		model.addAttribute("courseLesson",courseLesson);
		model.addAttribute("course",course);
		model.addAttribute("lessons",lessons);
		
		return "lesson/lesson-list";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Lesson lesson = new Lesson();
		
		model.addAttribute("lesson",lesson);
		
		return "lesson/lesson-form";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("lesson") Lesson lesson) {
		
		lessonService.save(lesson);
		
		return "redirect:/demo/home";
		
		
	}

}

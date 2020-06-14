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
import com.example.demo.entity.Period;
import com.example.demo.entity.Student;
import com.example.demo.service.CourseService;
import com.example.demo.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	private StudentService studentService;
	
	private CourseService courseService;
	
	@Autowired
	public StudentController(StudentService studentService, CourseService courseService) {
		
		this.studentService = studentService;
		
		this.courseService = courseService;
		
	}
	
	@GetMapping("/addCourse")
	public String showTest(@RequestParam("studentId") int id,Model model) {
		
		Student student = studentService.findById(id);
		
		List<Course> courses = courseService.findAll();
		
		student.setListCourse(courses);
		
		model.addAttribute("student", student);
		
		return "course/course-select";
	}
	
	@GetMapping("/showList")
	public String showList(Model model) {
		
		Student student = new Student();
		student.setCourse(new Course());
		student.getCourse().setPeriod(new Period());
		
		model.addAttribute("student", student);
		
		return "student/student-list";
	}
	
	@GetMapping("/findById")
	public String findById(@RequestParam("studentId") int id, Model model) {
		
		Student student = studentService.findById(id);
		if(student.getCourse()==null) {
			student.setCourse(new Course());
		}
		model.addAttribute("student",student);
		
		return "student/student-list";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Student student = new Student();
		
		model.addAttribute("student", student);
		
		return "student/student-form";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("student") Student student) {
		
		studentService.save(student);
		
		return "redirect:/students/findById?studentId=" + student.getId();
	}
	

}

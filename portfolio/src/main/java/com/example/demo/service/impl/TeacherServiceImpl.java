package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TeacherRepository;
import com.example.demo.entity.Teacher;
import com.example.demo.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	private TeacherRepository teacherRepository;
	
	@Autowired
	public TeacherServiceImpl(TeacherRepository teacherRepository) {
		this.teacherRepository = teacherRepository;
	}

	@Override
	public List<Teacher> findAll() {
		return teacherRepository.findAll();
	}

	@Override
	public Teacher findById(int theId) {
		Optional<Teacher> result = teacherRepository.findById(theId);
		
		Teacher teacher = result.get();
		
		return teacher;
	}

	@Override
	public void save(Teacher teacher) {
		
		teacherRepository.save(teacher);

	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub

	}

}

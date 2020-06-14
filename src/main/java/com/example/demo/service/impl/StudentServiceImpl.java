package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentRepository;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentRepository;
	
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> findAll() {
		
		return studentRepository.findAll();
		
	}

	@Override
	public Student findById(int id) {
		
		Optional<Student> result = studentRepository.findById(id);
				
		Student student = null;
		
		if(result.isPresent()) {
			student = result.get();
		}else {
			throw new RuntimeException("Não encontramos o Aluno de ID: " + id);
		}
		
		return student;
	}

	@Override
	public void save(Student student) {
		
		studentRepository.save(student);

	}

	@Override
	public void deleteById(int id) {
		
		studentRepository.deleteById(id);

	}

}

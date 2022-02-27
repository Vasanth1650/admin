package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.example.demo.dao.StudentRepository;

import com.example.demo.model.Student;


@Service
public class StudentService {
	
	@Autowired
	public StudentRepository studentRepository;
	public List<Student> getStudents(){
		return studentRepository.findAll();
	}
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	public Student getStudentById(int id) {
		Optional<Student> student = studentRepository.findById(id);
		return(student.get());
	}
	
	public void deleteById(int id) {
		studentRepository.deleteById(id);
	}
	public Student updateStudent(Student student) {
		if(getStudentById(student.getStudentid())==null) {
			return null;			
		}
		Student students = studentRepository.save(student);
		return (students);
	}	
	
}

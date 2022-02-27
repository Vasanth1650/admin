package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.StudentService;
import com.example.demo.model.Student;

@CrossOrigin("*")
@RestController
@RequestMapping("/student")


public class StudentController {
	
	@Autowired
	public StudentService studentService;
	
	@GetMapping("/viewstudents")
	public List<Student>findAllStuduents(){
		return studentService.getStudents();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id){
		return ResponseEntity.ok(studentService.getStudentById(id));
	}
	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	@DeleteMapping("delete/{id}")
	public void deleteStudentById(@PathVariable int id) {
		studentService.deleteById(id);
	}
	@PutMapping("/update")
	public ResponseEntity<Student> editStudent(@RequestBody Student student){
		return ResponseEntity.ok(studentService.updateStudent(student));
	}

}

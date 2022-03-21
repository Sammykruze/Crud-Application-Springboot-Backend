package com.student.details.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.student.details.model.StudentModel;

import com.student.details.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/add-student-info")
	public ResponseEntity<Object> addStudentInfo(@RequestBody StudentModel student) {
		studentService.saveStudent(student);
		return ResponseEntity.status(HttpStatus.OK).body("success");

	}

	@GetMapping("/get-all-students")
	public ResponseEntity<Object> getAllStudents(){
		List<StudentModel> response =  studentService.getAllStudent();
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
	
	
	@DeleteMapping("/delete-student/{student_id}")
	public ResponseEntity<Object> deleteStudent(@PathVariable int student_id){
		 studentService.deleteStudent(student_id);
		return ResponseEntity.status(HttpStatus.OK).body("success");
		}
	
	
	@PutMapping("/update-student")
	public ResponseEntity<Object> updateStudent(@RequestBody StudentModel student){
		studentService.updateStudent(student);
		return ResponseEntity.status(HttpStatus.OK).body("success");
	}
	
}

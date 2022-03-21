package com.student.details.service;

import java.util.List;

import com.student.details.model.StudentModel;

public interface StudentService {
	
	public void saveStudent (StudentModel student);
	public List<StudentModel> getAllStudent();
	public void deleteStudent(long student_id);
	public void updateStudent(StudentModel student);
}

package com.student.details.serviceImpl;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.details.model.StudentModel;
import com.student.details.repository.StudentRepository;
import com.student.details.service.StudentService;


@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public void saveStudent(StudentModel student) {
		studentRepo.save(student);
		
	}

	@Override
	public List<StudentModel> getAllStudent() {
		List<StudentModel> allStudents = studentRepo.findAll();
		return allStudents;
	}

	@Override
	public void deleteStudent(long student_id) {
		Optional<StudentModel> student = studentRepo.findById(student_id);
		if(student.isPresent()) {
			studentRepo.delete(student.get());
		}
		
	}

	@Override
	public void updateStudent(StudentModel student) {
		Optional<StudentModel> student_details = studentRepo.findById(student.getId());	
		if(student_details.isPresent()) {	
			studentRepo.save(student);
		}
	}

}

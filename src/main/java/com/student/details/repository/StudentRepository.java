package com.student.details.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.details.model.StudentModel;


@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long>{

}

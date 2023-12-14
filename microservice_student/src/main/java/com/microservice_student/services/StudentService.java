package com.microservice_student.services;

import com.microservice_student.entities.Student;

import java.util.List;

public interface StudentService {

  List<Student> findAll();
  Student findById(Long id);
  Student save(Student sudent);
  List<Student> findByIdCourse(Long courseId);

}

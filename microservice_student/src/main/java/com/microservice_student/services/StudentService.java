package com.microservice_student.services;

import com.microservice_student.entities.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

  List<Student> findAll();
  Optional<Student> findById(Long id);
  Student save(Student student);
  List<Student> findByIdCourse(Long courseId);

}

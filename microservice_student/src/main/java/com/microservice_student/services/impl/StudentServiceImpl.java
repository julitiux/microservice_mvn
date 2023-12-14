package com.microservice_student.services.impl;

import com.microservice_student.entities.Student;
import com.microservice_student.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

  @Override
  public List<Student> findAll() {
    return null;
  }

  @Override
  public Student findById(Long id) {
    return null;
  }

  @Override
  public Student save(Student sudent) {
    return null;
  }

  @Override
  public List<Student> findByIdCourse(Long courseId) {
    return null;
  }

}

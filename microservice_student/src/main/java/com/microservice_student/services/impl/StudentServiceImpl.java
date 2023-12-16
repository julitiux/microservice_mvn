package com.microservice_student.services.impl;

import com.microservice_student.entities.Student;
import com.microservice_student.repository.StudentRepository;
import com.microservice_student.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

  private StudentRepository studentRepository;

  @Override
  public List<Student> findAll() {
    return (List<Student>) studentRepository.findAll();
  }

  @Override
  public Optional<Student> findById(Long id) {
    return studentRepository.findById(id);
  }

  @Override
  public Student save(Student student) {
    return studentRepository.save(student);
  }

  @Override
  public List<Student> findByIdCourse(Long courseId) {
    return studentRepository.findAllByCourseId(courseId);
  }
}

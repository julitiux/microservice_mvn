package com.microservice_course.services.impl;

import com.microservice_course.entities.Course;
import com.microservice_course.repository.CourseRepository;
import com.microservice_course.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

  @Autowired
  private CourseRepository courseRepository;

  @Override
  public List<Course> findAll() {
    return (List<Course>) courseRepository.findAll();
  }

  @Override
  public Optional<Course> findById(Long id) {
    return courseRepository.findById(id);
  }

  @Override
  public Course save(Course course) {
    return courseRepository.save(course);
  }
}

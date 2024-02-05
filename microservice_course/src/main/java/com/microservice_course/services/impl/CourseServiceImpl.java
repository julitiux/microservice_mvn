package com.microservice_course.services.impl;

import com.microservice_course.entities.Course;
import com.microservice_course.services.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
  @Override
  public List<Course> findAll() {
    return null;
  }

  @Override
  public Optional<Course> findById(Long id) {
    return Optional.empty();
  }

  @Override
  public Course save(Course course) {
    return null;
  }
}

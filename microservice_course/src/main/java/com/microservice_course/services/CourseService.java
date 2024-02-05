package com.microservice_course.services;

import com.microservice_course.entities.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

  List<Course> findAll();
  Optional<Course> findById(Long id);
  Course save(Course course);

}

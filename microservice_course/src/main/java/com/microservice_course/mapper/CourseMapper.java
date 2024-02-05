package com.microservice_course.mapper;

import com.microservice_course.command.CourseCommand;
import com.microservice_course.dto.CourseDto;
import com.microservice_course.entities.Course;

import java.util.List;
import java.util.stream.Collectors;

public class CourseMapper {

  public static Course of(final CourseCommand courseCommand) {
    return new Course(null, courseCommand.name(), courseCommand.teacher());
  }

  public static CourseDto of(final Course course) {
    return new CourseDto(course.getName(), course.getTeacher());
  }

  public static List<CourseDto> listOf(final List<Course> courseList){
    return courseList.stream().map(CourseMapper::of).collect(Collectors.toList());
  }

}

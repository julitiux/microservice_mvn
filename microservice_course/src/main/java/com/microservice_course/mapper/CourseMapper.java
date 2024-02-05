package com.microservice_course.mapper;

import com.microservice_course.command.CourseCommand;
import com.microservice_course.entities.Course;

public class CourseMapper {

  public static Course of(final CourseCommand courseCommand){
    return new Course(null, courseCommand.name(), courseCommand.teacher());
  }

}

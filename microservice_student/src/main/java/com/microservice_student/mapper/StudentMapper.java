package com.microservice_student.mapper;

import com.microservice_student.command.StudentCommand;
import com.microservice_student.entities.Student;

public class StudentMapper {

  public static Student of(StudentCommand command) {
    return new Student(
      command.name(),
      command.lastName(),
      command.email(),
      Long.parseLong(command.courseId())
    );
  }

}

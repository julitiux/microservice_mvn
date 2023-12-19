package com.microservice_student.mapper;

import com.microservice_student.command.StudentCommand;
import com.microservice_student.entities.Student;

import java.util.Optional;

public class StudentMapper {

  public static Student of(StudentCommand command) {
    return new Student(
      command.name(),
      command.lastName(),
      command.email(),
      Long.parseLong(Optional.ofNullable(command.courseId()).orElse("0"))
    );
  }

}

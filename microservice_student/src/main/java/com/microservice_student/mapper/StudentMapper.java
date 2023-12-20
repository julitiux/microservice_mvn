package com.microservice_student.mapper;

import com.microservice_student.command.StudentCommand;
import com.microservice_student.dto.StudentDTO;
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

  public static StudentDTO of(Student student) {
    return new StudentDTO(
      student.getName(),
      student.getLastName(),
      student.getEmail()
    );
  }

}

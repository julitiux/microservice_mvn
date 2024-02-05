package com.microservice_student.mapper;

import com.microservice_student.command.StudentCommand;
import com.microservice_student.dto.StudentDTO;
import com.microservice_student.entities.Student;

import java.util.List;
import java.util.stream.Collectors;

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

  public static List<StudentDTO> listOf(final List<Student> studentList) {
    return studentList.stream().map(StudentMapper::of).collect(Collectors.toList());
  }

}

package com.microservice_student.controller;

import com.microservice_student.command.StudentCommand;
import com.microservice_student.entities.Student;
import com.microservice_student.mapper.StudentMapper;
import com.microservice_student.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/api/student")
public class StudentController {

  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @PostMapping("/create")
  public ResponseEntity<Object> saveStudent(@RequestBody StudentCommand command) {
    var studentSaves = studentService.save(StudentMapper.of(command));
    return Objects.nonNull(studentSaves.getId())
      ? new ResponseEntity<>(studentSaves, HttpStatus.CREATED)
      : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }

}

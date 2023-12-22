package com.microservice_student.controller;

import com.microservice_student.command.StudentCommand;
import com.microservice_student.dto.StudentDTO;
import com.microservice_student.mapper.StudentMapper;
import com.microservice_student.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    var studentSaved = studentService.save(StudentMapper.of(command));
    return Objects.nonNull(studentSaved.getId())
      ? new ResponseEntity<>(StudentMapper.of(studentSaved), HttpStatus.CREATED)
      : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }

  @GetMapping("/{id}")
  public ResponseEntity<StudentDTO> finById(@PathVariable String id) {
    return studentService.findById(Long.parseLong(id))
      .map(student -> new ResponseEntity<>(StudentMapper.of(student), HttpStatus.OK))
      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

}

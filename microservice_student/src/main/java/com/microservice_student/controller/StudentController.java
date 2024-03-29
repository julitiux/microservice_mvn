package com.microservice_student.controller;

import com.microservice_student.command.StudentCommand;
import com.microservice_student.dto.StudentDTO;
import com.microservice_student.entities.Student;
import com.microservice_student.mapper.StudentMapper;
import com.microservice_student.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

  @GetMapping("/findAll")
  public ResponseEntity<List<StudentDTO>> findAll() {
    List<Student> students = studentService.findAll();
    List<StudentDTO> studentDTOS = students.stream().map(StudentMapper::of).collect(Collectors.toList());
    return !Objects.isNull(studentDTOS) ?
      new ResponseEntity<>(studentDTOS, HttpStatus.OK) :
      new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @GetMapping("/search_by_course/{idCourse}")
  public ResponseEntity<List<StudentDTO>> findByIdCourse(@PathVariable Long idCourse) {
    var studentList = studentService.findByIdCourse(idCourse);
    return Objects.nonNull(studentList) ?
      new ResponseEntity<>(StudentMapper.listOf(studentList), HttpStatus.OK) :
      new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

}

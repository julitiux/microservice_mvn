package com.microservice_course.controller;

import com.microservice_course.command.CourseCommand;
import com.microservice_course.dto.CourseDto;
import com.microservice_course.entities.Course;
import com.microservice_course.mapper.CourseMapper;
import com.microservice_course.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/course")
public class CourseController {

  @Autowired
  private CourseService courseService;

  @PostMapping("/create")
  public ResponseEntity<?> saveCourse(@RequestBody CourseCommand courseCommand) {
    var courseSaved = courseService.save(CourseMapper.of(courseCommand));
    return Objects.nonNull(courseSaved.getId()) ?
      new ResponseEntity<>(CourseMapper.of(courseSaved), HttpStatus.OK) :
      new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }

  @GetMapping("/findAll")
  public ResponseEntity<List<CourseDto>> findAll() {
    List<Course> courseList = courseService.findAll();
    return !Objects.isNull(courseList) ?
      new ResponseEntity<>(CourseMapper.listOf(courseList), HttpStatus.OK) :
      new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CourseDto> findById(@PathVariable String id) {
    return courseService.findById(Long.parseLong(id))
      .map(course -> new ResponseEntity<>(CourseMapper.of(course), HttpStatus.OK))
      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

}

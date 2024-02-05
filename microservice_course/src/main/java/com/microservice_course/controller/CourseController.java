package com.microservice_course.controller;

import com.microservice_course.command.CourseCommand;
import com.microservice_course.mapper.CourseMapper;
import com.microservice_course.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

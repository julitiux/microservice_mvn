package com.microservice_course.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-student", url = "localhost:8090/api/student")
public interface StudentClient {

  @GetMapping("/search_by_course/{idCourse}")
  List<?> findAllStudentByCourse(@PathVariable Long idCourse);

}

package com.microservice_course.client;

import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(name = "msvc-student", url = "localhost:8090/api/student")
public interface StudentClient {

  List<?> findAllStudentByCourse();

}

package com.microservice_course.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "msvc-student", url = "localhost:8090/api/student")
public interface StudentClient {
}

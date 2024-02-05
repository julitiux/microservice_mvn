package com.microservice_course.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "msvc-student")
public interface StudentClient {
}

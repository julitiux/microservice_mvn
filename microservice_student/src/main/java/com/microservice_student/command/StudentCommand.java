package com.microservice_student.command;

public record StudentCommand(
  String name,
  String lastName,
  String email,
  String courseId
) {
}

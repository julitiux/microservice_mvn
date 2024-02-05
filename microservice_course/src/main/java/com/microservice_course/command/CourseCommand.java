package com.microservice_course.command;

public record CourseCommand(
  String name,
  String teacher
) {
}

package com.microservice_student.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
public class Student {

  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private String lastName;
  private String email;
  private Long courseId;

  public Student(String name, String lastName, String email, Long courseId) {
    this.name = name;
    this.lastName = lastName;
    this.email = email;
    this.courseId = courseId;
  }

}

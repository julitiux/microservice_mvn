package com.microservice_student.entities;

import jakarta.persistence.*;
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

}

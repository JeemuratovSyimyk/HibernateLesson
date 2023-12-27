package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name = "students")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Student {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_gen")
   @SequenceGenerator(
           name = "student_gen",
           sequenceName = "student_seq",
           allocationSize = 1)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private int age;
   @Column(unique = true)
    private String email;

    public Student(String firstName, String lastName, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }


    }






package miu.edu.AlumniTrackingSystem.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue
    private  int id;

    private String firstname;
    private String lastname;
    private  String email;
    private String username;
    private String password;
    private double gpa;
}

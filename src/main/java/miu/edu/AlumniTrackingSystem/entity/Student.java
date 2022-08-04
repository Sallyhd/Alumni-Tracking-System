package miu.edu.AlumniTrackingSystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@PrimaryKeyJoinColumn
public class Student extends User{
    @Id
    @GeneratedValue
    private  int id;

    private String firstname;
    private String lastname;

    private double gpa;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<JobAdvertisment> jobAdvertisments;

    @ManyToOne
    private Department major;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<JobApplication> jobApplications;

}

package miu.edu.AlumniTrackingSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumns({@PrimaryKeyJoinColumn(name="User_Id",referencedColumnName="id")})
public class Student extends User{

    private double gpa;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<JobAdvertisment> jobAdvertisments;

    @ManyToOne
    private Department major;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<JobApplication> jobApplications;

    @OneToMany(mappedBy="student",fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    private List<JobExperience> professionalExperiences;

}

package miu.edu.AlumniTrackingSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumns({@PrimaryKeyJoinColumn(name="User_Id",referencedColumnName="id")})
public class Student extends User{

    private double gpa;

//    @JsonManagedReference(value = "studentEntity")
    @OneToOne
    private Address address;

    @JsonManagedReference(value="jobingAdv")
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<JobAdvertisment> jobAdvertisments;

    @ManyToOne
    private Department major;

    @JsonManagedReference(value = "applicationsEntity")
    @OneToMany(mappedBy = "student")
    private List<JobApplication> jobApplications;

    @JsonManagedReference(value = "experience")
    @OneToMany(mappedBy="student",fetch = FetchType.EAGER )
    private List<JobExperience> professionalExperiences;

}

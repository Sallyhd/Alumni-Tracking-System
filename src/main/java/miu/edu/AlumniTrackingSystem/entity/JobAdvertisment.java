package miu.edu.AlumniTrackingSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisment extends BaseClass{
    private String companyName;
    @ManyToOne
    @JsonBackReference(value="jobingAdv")
    private Student student;

    @OneToMany(mappedBy = "jobAdvertisment")
    @JsonManagedReference("jobAttatchmentsEntity")
    private List<JobAttachment> jobAttatchments;

    @OneToMany(mappedBy = "jobAdvertisment")
    private List<JobApplication> jobApplications;

    @OneToOne(cascade = CascadeType.MERGE)
    private Address address;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags;

}

package miu.edu.AlumniTrackingSystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class JobAdvertisment extends BaseClass{
    private String companyName;
    @ManyToOne
    private Student student;

    @OneToMany(mappedBy = "jobAdvertisment")
    private List<JobAttachment> jobAttatchments;

    @OneToMany(mappedBy = "jobAdvertisment")
    private List<JobApplication> jobApplications;

    @OneToOne
    private Address address;

    @ManyToMany
    private List<Tag> tags;
}

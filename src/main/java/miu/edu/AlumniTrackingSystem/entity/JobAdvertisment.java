package miu.edu.AlumniTrackingSystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class JobAdvertisment extends BaseClass{

    @ManyToOne
    private Student student;

    @OneToMany(mappedBy = "jobAdvertisment")
    private List<JobAttatchment> jobAttatchments;

    @OneToMany(mappedBy = "jobAdvertisment")
    private List<JobApplication> jobApplications;

    @OneToOne(mappedBy = "jobAdvertisment")
    private Address address;

    @ManyToMany
    private List<Tag> tags;
}

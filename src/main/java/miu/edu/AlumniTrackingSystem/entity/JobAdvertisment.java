package miu.edu.AlumniTrackingSystem.entity;

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
    private Student student;

    @OneToMany(mappedBy = "jobAdvertisment")
    private List<JobAttachment> jobAttatchments;

    @OneToMany(mappedBy = "jobAdvertisment")
    private List<JobApplication> jobApplications;

    @OneToOne
    private Address address;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags;
}

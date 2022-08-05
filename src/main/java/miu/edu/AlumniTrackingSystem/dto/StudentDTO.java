package miu.edu.AlumniTrackingSystem.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.AlumniTrackingSystem.entity.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private int id;
    private double gpa;
    private Address address;

    @JsonManagedReference
    private List<JobAdvertisment> jobAdvertisments;

    @JsonManagedReference
    private Department major;

    @JsonManagedReference
    private List<JobApplication> jobApplications;

    @JsonManagedReference
    private List<JobExperience> professionalExperiences;
}

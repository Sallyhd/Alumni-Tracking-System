package miu.edu.AlumniTrackingSystem.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO extends UserDTO{
    private double gpa;
    private AddressDTO address;

    @JsonManagedReference
    private List<JobAdvertisementDTO> jobAdvertisments;

    @JsonManagedReference
    private DepartmentDTO major;

    @JsonManagedReference
    private List<JobApplicationDTO> jobApplications;

    @JsonManagedReference
    private List<JobExperienceDTO> professionalExperiences;
}

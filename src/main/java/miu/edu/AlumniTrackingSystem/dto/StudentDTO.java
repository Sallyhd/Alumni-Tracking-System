package miu.edu.AlumniTrackingSystem.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonManagedReference(value = "mailingAddress")
    private AddressDTO address;

    @JsonManagedReference(value="jobingAdv")
    private List<JobAdvertisementDTO> jobAdvertisments;


    private DepartmentDTO major;

    @JsonManagedReference(value = "applications")
    private List<JobApplicationDTO> jobApplications;

    @JsonManagedReference(value = "experience")
    private List<JobExperienceDTO> professionalExperiences;
}

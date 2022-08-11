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
    private AddressDTO address;

    private List<JobAdvertisementDTO> jobAdvertisments;


    private DepartmentDTO major;

    private List<JobApplicationDTO> jobApplications;

    private List<JobExperienceDTO> professionalExperiences;
}

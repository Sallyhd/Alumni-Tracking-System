package miu.edu.AlumniTrackingSystem.dto.response;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.AlumniTrackingSystem.dto.DepartmentDTO;
import miu.edu.AlumniTrackingSystem.dto.UserDTO;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse extends UserDTO {
    private double gpa;
    @JsonManagedReference(value = "studentAddressResponse")
    private AddressResponse address;

    @JsonManagedReference(value = "jobAdvertisementstudentResponse")
    private List<JobAdvertisementResponse> jobAdvertisments;


    private DepartmentDTO major;

    @JsonManagedReference(value = "jobApplicationsstudentResponse")
    private List<JobApplicationResponse> jobApplications;

    @JsonManagedReference(value = "jobExperiencestudentResponse")
    private List<JobExperienceResponse> professionalExperiences;
}

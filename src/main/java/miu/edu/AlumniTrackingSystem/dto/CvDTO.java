package miu.edu.AlumniTrackingSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.AlumniTrackingSystem.entity.Department;
import miu.edu.AlumniTrackingSystem.entity.JobExperience;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDTO {

        private String firstName;

        private String lastName;

        private String email;

        private float gpa;
        private List<JobExperienceDTO> professionalExperience;
        private AddressDTO address;

        private DepartmentDTO major;
    }



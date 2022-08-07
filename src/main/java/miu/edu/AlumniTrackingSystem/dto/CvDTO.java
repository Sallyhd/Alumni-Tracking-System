package miu.edu.AlumniTrackingSystem.dto;

import miu.edu.AlumniTrackingSystem.entity.Department;
import miu.edu.AlumniTrackingSystem.entity.JobExperience;

import java.util.List;

public class CvDTO {


        private String firstName;

        private String lastName;

        private String email;

        private float gpa;
        private List<JobExperience> professionalExperience;
        private AddressDTO address;

        private Department major;
    }



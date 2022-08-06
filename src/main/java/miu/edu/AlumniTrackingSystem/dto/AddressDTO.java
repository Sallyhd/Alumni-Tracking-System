package miu.edu.AlumniTrackingSystem.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;


    @Data
    @NoArgsConstructor
    public class AddressDTO {
        private int id;
        private String street;
        private String city;
        private String state;
        private int zip;
        @JsonBackReference(value = "mailingAddress")
        private StudentDTO student;
        @JsonBackReference(value = "faculty")
        private FacultyDTO faculty;
        @JsonBackReference(value = "dutyStation")
        private JobAdvertisementDTO jobAdvertisement;
    }





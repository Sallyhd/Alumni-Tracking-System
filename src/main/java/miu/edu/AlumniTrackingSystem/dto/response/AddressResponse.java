package miu.edu.AlumniTrackingSystem.dto.response;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 @Data
 @NoArgsConstructor
 @AllArgsConstructor
 public class AddressResponse {
        private int id;
        private String street;
        private String city;
        private String state;
        private int zip;
//        @JsonBackReference(value = "studentAddressResponse")
//        private StudentResponse student;
        @JsonBackReference(value = "facultyAddressResponse")
        private FacultyResponse faculty;
//        @JsonBackReference(value = "jobAdvertisementAddressResponse")
//        private JobAdvertisementResponse jobAdvertisement;
 }





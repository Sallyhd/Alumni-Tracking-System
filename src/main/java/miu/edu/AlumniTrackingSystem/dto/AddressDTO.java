package miu.edu.AlumniTrackingSystem.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
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

 }





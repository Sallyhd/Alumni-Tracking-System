package miu.edu.AlumniTrackingSystem.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobApplicationDTO {

    private Integer id;
    @JsonBackReference(value = "applications")
    private StudentDTO  student;
    @JsonBackReference(value="applicants")
    private JobAdvertisementDTO jobAdvertisement;
}

package miu.edu.AlumniTrackingSystem.dto.response;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobApplicationResponse {

    private Integer id;
    @JsonBackReference(value = "jobApplicationsstudentResponse")
    private StudentResponse  student;
    @JsonBackReference(value="jobAdvertisementApplicationResponse")
    private JobAdvertisementResponse jobAdvertisement;
}

package miu.edu.AlumniTrackingSystem.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobExperienceDTO {

    private Integer id;
    private String companyName;
    private LocalDate startDate;
    private LocalDate finishDate;
    private String description;
    @JsonBackReference(value = "experiences")
    private StudentDTO student;

}

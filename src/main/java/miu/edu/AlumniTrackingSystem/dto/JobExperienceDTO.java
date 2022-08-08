package miu.edu.AlumniTrackingSystem.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobExperienceDTO {

    private Integer id;
    private String companyName;
    private Date startDate;
    private Date finishDate;
    private String description;
    @JsonBackReference(value = "experience")
    private StudentDTO student;

}

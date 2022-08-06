package miu.edu.AlumniTrackingSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobADvertisementGetDTO {
    private Integer id;
    private String companyName;
    private String description;
    private String benefits;

}

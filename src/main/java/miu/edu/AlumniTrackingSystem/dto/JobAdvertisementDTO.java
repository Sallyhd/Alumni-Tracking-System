package miu.edu.AlumniTrackingSystem.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementDTO {

    private Integer id;
    private String companyName;
    private String description;
    private String benefits;
    private List<TagDTO> tags;

    @JsonManagedReference(value = "attach")
    private List<JobAttachmentDTO> jobAttachments;
    @JsonBackReference(value = "advertisements")
    private StudentDTO student;
    @JsonManagedReference(value = "applicants")
    private List<JobApplicationDTO> jobApplications;

    @JsonManagedReference(value = "dutyStation")
    private AddressDTO address;

}

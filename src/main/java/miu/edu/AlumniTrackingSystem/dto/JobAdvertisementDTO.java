package miu.edu.AlumniTrackingSystem.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.AlumniTrackingSystem.entity.Student;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementDTO {

    private Integer id;
    private String companyName;
    private String description;
    private List<TagDTO> tags;

    private List<JobAttachmentDTO> jobAttachments;

    private List<JobApplicationDTO> jobApplications;

    private AddressDTO address;

    @JsonManagedReference
    private StudentDTO student;
}

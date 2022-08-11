package miu.edu.AlumniTrackingSystem.dto.response;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.AlumniTrackingSystem.dto.TagDTO;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementResponse {

    private Integer id;
    private String companyName;
    private String description;
    private List<TagDTO> tags;

    @JsonManagedReference(value="jobAdvertisementAttachmentResponse")
    private List<JobAttachmentResponse> jobAttachments;
    @JsonBackReference(value="jobAdvertisementstudentResponse")
    private StudentResponse student;
    @JsonManagedReference(value="jobAdvertisementApplicationResponse")
    private List<JobApplicationResponse> jobApplications;

    @JsonManagedReference(value = "jobAdvertisementAddressResponse")
    private AddressResponse address;

}

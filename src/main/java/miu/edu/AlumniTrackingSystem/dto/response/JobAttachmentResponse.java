package miu.edu.AlumniTrackingSystem.dto.response;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAttachmentResponse {
    private Integer id;
    private String name;
    // cloud url of the file
    private String url;
    @JsonBackReference(value="jobAdvertisementAttachmentResponse")
    private JobAdvertisementResponse jobAdvertisement;
}

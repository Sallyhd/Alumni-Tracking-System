package miu.edu.AlumniTrackingSystem.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class JobAdvAndFileDTO {
    private JobAdvertisementDTO jobAdvertisementDTO;
    private MultipartFile file;
}

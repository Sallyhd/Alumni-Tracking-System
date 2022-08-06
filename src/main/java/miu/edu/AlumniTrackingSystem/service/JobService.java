package miu.edu.AlumniTrackingSystem.service;

import miu.edu.AlumniTrackingSystem.Exceptions.RecordNotFoundException;
import miu.edu.AlumniTrackingSystem.dto.*;
import miu.edu.AlumniTrackingSystem.entity.JobAdvertisment;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface JobService {
    List<StudentDTO> getApplicants(Integer jobId);
    void applyToJob(Integer jobId,String username);
    JobAdvertisementDTO getById(int id);
    List<JobAdvertisementDTO> getAllJobAdvertisements(String username);
    Page<JobAdvertisment> getAllJobAdvPaginated(PagingRequest pagingRequest);
    void saveJobAdvertisement(JobAdvertisementDTO jobAdvertisement , MultipartFile file) throws RecordNotFoundException;

    void deleteJobAdvertismentByOwnerId(Integer id) throws RecordNotFoundException;
    List<TagCountDTO> countTotalTagsByName();

    List<JobAdvertisment> findJobAdvertisementsByTags_Name(String tagName);
    List<JobAdvertisment> findJobAdvertisementsByAddress_State(String stateName);
    List<JobAdvertisment> findJobAdvertisementsByAddress_City(String cityName);
    List<JobAdvertisment> findJobAdvertisementsByCompanyName(String companyName);
}

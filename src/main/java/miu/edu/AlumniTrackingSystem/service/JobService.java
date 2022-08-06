package miu.edu.AlumniTrackingSystem.service;

import miu.edu.AlumniTrackingSystem.Exceptions.RecordNotFoundException;
import miu.edu.AlumniTrackingSystem.dto.*;
import miu.edu.AlumniTrackingSystem.entity.JobAdvertisment;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface JobService {
    public List<StudentDTO> getApplicants(Integer jobId);
    public void advertiseJob();
    public void applyToJob(Integer jobId,String username);
    JobADvertisementGetDTO getById(int id);
    public List<JobAdvertisementDTO> getJobAdvertisements(int limit, int offset);
    public List<JobAdvertisementDTO> getAllJobAdvertisements(String username);
    Page<JobAdvertisment> getAllJobAdvPaginated(PagingRequest pagingRequest);

    List<JobAdvertisementDTO> filter(String tag, String state, String city, String companyName);

    void saveJobAdvertisement(JobAdvertisment jobAdvertisement , MultipartFile file) throws RecordNotFoundException;

    List<JobAdvertisment> getJobAdvByMostRecentApplied();

    void deleteEmployeeById(Integer id) throws RecordNotFoundException;
    List<TagCountDTO> countTotalTagsByName();

    // List<JobCount> countTotalJobsByCompanyName();
}

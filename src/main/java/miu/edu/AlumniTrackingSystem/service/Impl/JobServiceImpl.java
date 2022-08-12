package miu.edu.AlumniTrackingSystem.service.Impl;


import lombok.AllArgsConstructor;
import miu.edu.AlumniTrackingSystem.configuration.Utils;
import miu.edu.AlumniTrackingSystem.dto.*;
import miu.edu.AlumniTrackingSystem.entity.*;
import miu.edu.AlumniTrackingSystem.repository.JobAdvertisementRepository;
import miu.edu.AlumniTrackingSystem.repository.JobApplicationRepository;
import miu.edu.AlumniTrackingSystem.repository.StudentRepository;
import miu.edu.AlumniTrackingSystem.service.JobAttachmentService;
import miu.edu.AlumniTrackingSystem.service.JobService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobAdvertisementRepository jobAdvertisementRepository;
    @Autowired
    private JobApplicationRepository jobApplicationRepository;
    @Autowired
    private JobAttachmentService jobAttachmentService;
    @Autowired
    private  StudentRepository studentRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<StudentDTO> getApplicants(Integer jobId) {
        return jobAdvertisementRepository.findById(jobId)
                .map((e) -> e.getJobApplications())
                .orElse(new ArrayList<>())
                .stream().map(application -> application.getStudent())
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .toList();
    }

    @Override
    public void applyToJob(Integer advId, int stdId) {
        Student st =  studentRepository.findById(stdId).get();
        JobAdvertisment job=jobAdvertisementRepository.findById(advId).get();
        JobApplication jobApp = new JobApplication();
        jobApp.setStudent(st);
        job.getJobApplications().add(jobApp);
        jobAdvertisementRepository.save(job);
    }

    @Override
    public JobAdvertisementDTO getById(int id) {
        return modelMapper.map(jobAdvertisementRepository.findById(id), JobAdvertisementDTO.class);
    }

    @Override
    public List<JobAdvertisementDTO> getAllJobAdvertisements(String username) {
        List<JobAdvertisementDTO> result = new ArrayList<JobAdvertisementDTO>();
        for (JobAdvertisment std : jobAdvertisementRepository.findJobAdvertismentByStudentUsername(username)) {
            result.add(modelMapper.map(std,JobAdvertisementDTO.class));
        }
        return result;
    }

    @Override
    public Page<JobAdvertisment> getAllJobAdvPaginated(PagingRequest pagingRequest) {
            var direction = (pagingRequest.isAscending()) ? Sort.Direction.ASC : Sort.Direction.DESC;

            var request = PageRequest
                    .of(pagingRequest.getPage(), pagingRequest.getPageSize(), direction,pagingRequest.getSortBy());

            return jobAdvertisementRepository.findAll(request);
    }

    @Override
    public void saveJobAdvertisement(JobAdvertisementDTO jobAdvertisement, MultipartFile file) {

        Optional<JobAdvertisment> jobAdv = jobAdvertisementRepository.findById(jobAdvertisement.getId());

        if (!jobAdv.isPresent()) {
            JobAdvertisment newJobAdvertisement = new JobAdvertisment();
            newJobAdvertisement = jobAdvertisementRepository.save(
                    modelMapper.map(jobAdvertisement, JobAdvertisment.class));
            JobAttachment jb = jobAttachmentService.save(newJobAdvertisement.getId(), file);
            newJobAdvertisement.setJobAttatchments(Arrays.asList(jb));
        } else {
            jobAdvertisementRepository.save(modelMapper.map(jobAdvertisement, JobAdvertisment.class));
        }

    }

    @Override
    public void deleteJobAdvertismentByOwnerId(Integer id) {
        jobAdvertisementRepository.deleteJobAdvertismentByStudentId(id);
    }

    @Override
    public List<JobAdvertisment> findJobAdvertisementsByTags_Name(String tagName) {
        return jobAdvertisementRepository.findJobAdvertisementsByTags_Name(tagName);
    }

    @Override
    public List<JobAdvertisment> findJobAdvertisementsByAddress_State(String stateName) {
        return jobAdvertisementRepository.findJobAdvertisementsByAddress_State(stateName);
    }

    @Override
    public List<JobAdvertisment> findJobAdvertisementsByAddress_City(String cityName) {
        return jobAdvertisementRepository.findJobAdvertisementsByAddress_City(cityName);
    }

    @Override
    public List<JobAdvertisment> findJobAdvertisementsByCompanyName(String companyName) {
        return jobAdvertisementRepository.findJobAdvertisementsByCompanyName(companyName);
    }
}

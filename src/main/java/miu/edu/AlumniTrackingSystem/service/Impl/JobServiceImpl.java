package miu.edu.AlumniTrackingSystem.service.Impl;


import lombok.AllArgsConstructor;
import miu.edu.AlumniTrackingSystem.configuration.Utils;
import miu.edu.AlumniTrackingSystem.dto.*;
import miu.edu.AlumniTrackingSystem.entity.JobAdvertisment;
import miu.edu.AlumniTrackingSystem.entity.JobApplication;
import miu.edu.AlumniTrackingSystem.entity.JobAttachment;
import miu.edu.AlumniTrackingSystem.entity.Student;
import miu.edu.AlumniTrackingSystem.repository.JobAdvertisementRepository;
import miu.edu.AlumniTrackingSystem.repository.JobApplicationRepository;
import miu.edu.AlumniTrackingSystem.repository.StudentRepository;
import miu.edu.AlumniTrackingSystem.service.JobAttachmentService;
import miu.edu.AlumniTrackingSystem.service.JobService;
import org.modelmapper.ModelMapper;
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
@AllArgsConstructor
@Transactional
public class JobServiceImpl implements JobService {
    private final JobAdvertisementRepository jobAdvertisementRepository;

    private final JobApplicationRepository jobApplicationRepository;
    private final JobAttachmentService jobAttachmentService;
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

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
    public void applyToJob(Integer advId, String username) {
        Student st = studentRepository.getStudentsByUsername(username);
        JobAdvertisment job=jobAdvertisementRepository.findById(advId).get();
        st.getJobApplications().add(new JobApplication(st,job));
    }

    @Override
    public JobAdvertisementDTO getById(int id) {
        return modelMapper.map(jobAdvertisementRepository.findById(id), JobAdvertisementDTO.class);
    }

    @Override
    public List<JobAdvertisementDTO> getAllJobAdvertisements(String username) {
        return Utils.mapList(jobAdvertisementRepository.findJobAdvertismentByStudentUsername(username),JobAdvertisementDTO.class);
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

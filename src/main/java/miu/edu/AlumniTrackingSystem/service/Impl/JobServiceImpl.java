package miu.edu.AlumniTrackingSystem.service.Impl;


import lombok.AllArgsConstructor;
import miu.edu.AlumniTrackingSystem.Exceptions.RecordNotFoundException;
import miu.edu.AlumniTrackingSystem.configuration.Utils;
import miu.edu.AlumniTrackingSystem.dto.*;
import miu.edu.AlumniTrackingSystem.entity.JobAdvertisment;
import miu.edu.AlumniTrackingSystem.entity.JobApplication;
import miu.edu.AlumniTrackingSystem.entity.Student;
import miu.edu.AlumniTrackingSystem.repository.JobAdvertisementRepository;
import miu.edu.AlumniTrackingSystem.repository.JobApplicationRepository;
import miu.edu.AlumniTrackingSystem.repository.StudentRepository;
import miu.edu.AlumniTrackingSystem.service.JobAttachmentService;
import miu.edu.AlumniTrackingSystem.service.JobService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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
    public void applyToJob(Integer jobId, String username) {
        Student st = studentRepository.getStudentsByUsername(username);
        JobAdvertisment job=jobAdvertisementRepository.findById(jobId).get();
        //job.getJobApplications().add(st);
        st.getJobApplications().add(new JobApplication(st,job));
    }

    @Override
    public JobAdvertisementDTO getById(int id) {
        return modelMapper.map(jobAdvertisementRepository.findById(id), JobAdvertisementDTO.class);
    }

    @Override
    public List<JobAdvertisementDTO> getJobAdvertisements(int limit, int offset) {
        return null;
    }

    @Override
    public List<JobAdvertisementDTO> getAllJobAdvertisements(String username) {
        return Utils.mapList(jobAdvertisementRepository.findJobAdvertismentByStudentUsername(username),JobAdvertisementDTO.class);
    }

    @Override
    public Page<JobAdvertisment> getAllJobAdvPaginated(PagingRequest pagingRequest) {
        return null;
    }

    @Override
    public void saveJobAdvertisement(JobAdvertisementDTO jobAdvertisement, MultipartFile file) throws RecordNotFoundException {

    }

    @Override
    public void deleteJobAdvertismentByOwnerId(Integer id) throws RecordNotFoundException {

    }

    @Override
    public List<TagCountDTO> countTotalTagsByName() {
        return null;
    }
}

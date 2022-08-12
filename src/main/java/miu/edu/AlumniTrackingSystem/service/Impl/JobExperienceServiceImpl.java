package miu.edu.AlumniTrackingSystem.service.Impl;

import miu.edu.AlumniTrackingSystem.dto.JobExperienceDTO;
import miu.edu.AlumniTrackingSystem.entity.JobExperience;
import miu.edu.AlumniTrackingSystem.entity.Student;
import miu.edu.AlumniTrackingSystem.repository.JobExperienceRepository;
import miu.edu.AlumniTrackingSystem.repository.StudentRepository;
import miu.edu.AlumniTrackingSystem.service.JobExperienceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

public class JobExperienceServiceImpl implements JobExperienceService {

    @Autowired
    JobExperienceRepository jobExperienceRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    StudentRepository studentRepository;


    @Override
    public void addExperience(JobExperienceDTO jobExperienceDTO, String username) {

        JobExperience jobExperience = modelMapper.map(jobExperienceDTO, JobExperience.class);
        jobExperience.setStudent(studentRepository.getStudentByUsername(username));
        studentRepository.getStudentByUsername(username).getProfessionalExperiences().add(jobExperience);

    }

    @Override
    public void removeExperience(Integer experienceId, String Username) {

        Student s = studentRepository.getStudentByUsername(Username);
        jobExperienceRepository.deleteById(experienceId);

    }
}

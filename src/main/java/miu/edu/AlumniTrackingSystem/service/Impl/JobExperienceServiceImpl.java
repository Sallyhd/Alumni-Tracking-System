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
        jobExperience.setStudent(studentRepository.getStudentsByUsername(username));
        studentRepository.getStudentsByUsername(username).getProfessionalExperiences().add(jobExperience);

    }

    @Override
    public void removeExperience(Integer experienceId, String Username) {

        Student s = studentRepository.getStudentsByUsername(Username);
        jobExperienceRepository.deleteById(experienceId);

    }
}



//    @Override
//    public void addExperience(ProfessionalExperienceDto professionalExperienceDto, String username) {
//        ProfessionalExperience professionalExperience =
//                modelMapper.map(professionalExperienceDto , ProfessionalExperience.class);
//        professionalExperience.setStudent(studentRepo.getStudentByUsername(username));
//        studentRepo.getStudentByUsername(username).getProfessionalExperiences().add(professionalExperience);
//
//    }
//
//    @Override
//    public void removeExperience(Integer experienceId,String username) {
//        Student s= studentRepo.getStudentByUsername(username);
//        professionalExperienceRepo.deleteById(experienceId);
//    }

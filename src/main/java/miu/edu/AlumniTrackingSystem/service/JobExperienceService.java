package miu.edu.AlumniTrackingSystem.service;

import miu.edu.AlumniTrackingSystem.dto.JobExperienceDTO;
import org.springframework.stereotype.Service;


public interface JobExperienceService {

    void addExperience(JobExperienceDTO jobExperienceDTO, String username);
    public void removeExperience(Integer experienceId,String Username);
}

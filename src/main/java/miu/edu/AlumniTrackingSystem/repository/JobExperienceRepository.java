package miu.edu.AlumniTrackingSystem.repository;

import miu.edu.AlumniTrackingSystem.entity.JobExperience;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobExperienceRepository extends CrudRepository<JobExperience, Integer> {


}

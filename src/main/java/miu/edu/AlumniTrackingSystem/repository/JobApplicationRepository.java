package miu.edu.AlumniTrackingSystem.repository;


import miu.edu.AlumniTrackingSystem.entity.Department;
import miu.edu.AlumniTrackingSystem.entity.JobApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepository extends CrudRepository<JobApplication,Integer> {

}

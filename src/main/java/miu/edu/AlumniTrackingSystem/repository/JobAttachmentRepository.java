package miu.edu.AlumniTrackingSystem.repository;


import miu.edu.AlumniTrackingSystem.entity.JobAttachment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobAttachmentRepository extends CrudRepository<JobAttachment,Integer> {
}

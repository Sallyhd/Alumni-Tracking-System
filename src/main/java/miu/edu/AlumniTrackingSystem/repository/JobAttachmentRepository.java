package miu.edu.AlumniTrackingSystem.repository;


import miu.edu.AlumniTrackingSystem.entity.JobAttachment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobAttachmentRepository extends CrudRepository<JobAttachment,Integer> {
    @Query("SELECT name FROM JobAttachment where jobAdvertisment.id =?1")
    String findNameByJobAdvertisementId(Integer id);
}

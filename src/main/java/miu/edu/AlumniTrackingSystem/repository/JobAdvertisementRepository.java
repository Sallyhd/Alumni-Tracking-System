package miu.edu.AlumniTrackingSystem.repository;

import miu.edu.AlumniTrackingSystem.entity.JobAdvertisment;
import miu.edu.AlumniTrackingSystem.entity.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobAdvertisementRepository extends CrudRepository<JobAdvertisment, Integer> {
//    public List<JobAdvertisment> findJobAdvertisementsByTags(List<Tag> tag);
//    public List<JobAdvertisment> findJobAdvertisementsByAddress_State(String stateName);
//    public List<JobAdvertisment> findJobAdvertisementsByAddress_City(String cityName);
//    public List<JobAdvertisment> findJobAdvertisementsByCompanyName(String companyName);
  // public JobAdvertisment findById(int id);
}

package miu.edu.AlumniTrackingSystem.repository;

import miu.edu.AlumniTrackingSystem.entity.JobAdvertisment;
import miu.edu.AlumniTrackingSystem.entity.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobAdvertisementRepository extends PagingAndSortingRepository<JobAdvertisment, Integer> {
    public List<JobAdvertisment> findJobAdvertisementsByTags_Name(String tagName);
    public List<JobAdvertisment> findJobAdvertisementsByAddress_State(String stateName);
    public List<JobAdvertisment> findJobAdvertisementsByAddress_City(String cityName);
    public List<JobAdvertisment> findJobAdvertisementsByCompanyName(String companyName);
    public List<JobAdvertisment> findJobAdvertismentByStudentUsername(String username);
  // public JobAdvertisment findById(int id);
}

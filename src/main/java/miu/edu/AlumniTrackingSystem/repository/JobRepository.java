package miu.edu.AlumniTrackingSystem.repository;

import miu.edu.AlumniTrackingSystem.dto.TagCountDTO;
import miu.edu.AlumniTrackingSystem.entity.JobAdvertisment;
import miu.edu.AlumniTrackingSystem.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends CrudRepository<JobAdvertisment, Integer> {

    //    public List<JobAdvertisement> findAllBy
//    @Query("select job from JobAdvertisment job join job.address ad join job.tags tag where 1=1 OR tag.name =?1 OR ad.state = ?2 OR ad.city = ?3 OR job.companyName = ?4")
//    List<JobAdvertisment> findByFilter(String tag, String state, String city, String companyName);
//
//    @Query("select job.id,job.description,job.companyName,job.benefits,ad.street,ad.city,ad.state,ad.zip from JobAdvertisement job join job.address ad where job.student=?1")
//    List<JobAdvertisment> getJobAdvertisementByStudent(Student student);
//
//    //@Query("SELECT new com.cs545waa.waaJune2022finalProject.dto.TagCount(t.name , COUNT(t.name)) "
//           // + "FROM JobAdvertisement AS j  join j.tags t GROUP BY t.name ORDER BY t.name DESC")
//    List<TagCountDTO> countTotalTagsByName();
//   // @Query("SELECT new com.cs545waa.waaJune2022finalProject.dto.JobCount(j.companyName, COUNT(j.companyName)) "
//           // + "FROM JobAdvertisement AS j GROUP BY j.companyName ORDER BY j.companyName DESC")
//    //List<JobCount> countTotalJobsByCompanyName();
}

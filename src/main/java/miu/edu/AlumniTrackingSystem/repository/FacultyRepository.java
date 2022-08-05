package miu.edu.AlumniTrackingSystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import miu.edu.AlumniTrackingSystem.entity.Faculty;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty,Integer> {
}

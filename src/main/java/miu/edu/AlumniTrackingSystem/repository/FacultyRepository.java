package miu.edu.AlumniTrackingSystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends CrudRepository<miu.edu.AlumniTrackingSystem.entity.Faculty,Integer> {
}

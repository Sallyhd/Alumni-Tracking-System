package miu.edu.AlumniTrackingSystem.repository;

import miu.edu.AlumniTrackingSystem.entity.Faculty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty, Integer> {
}

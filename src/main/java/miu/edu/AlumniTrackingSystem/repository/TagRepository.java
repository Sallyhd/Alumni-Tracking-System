package miu.edu.AlumniTrackingSystem.repository;


import miu.edu.AlumniTrackingSystem.entity.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag,Integer> {
}

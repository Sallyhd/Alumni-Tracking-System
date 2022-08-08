package miu.edu.AlumniTrackingSystem.repository;

import miu.edu.AlumniTrackingSystem.entity.Department;
import miu.edu.AlumniTrackingSystem.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {
    List<Student> getStudentByAddress_State(String state);
    List<Student> getStudentByAddress_City(String city);
    List<Student> getStudentsByMajor(Department department);
    List<Student> getStudentsByFirstnameContaining(String name);
    Student getStudentsByUsername(String username);
    Student findStudentsById(int userId);

}

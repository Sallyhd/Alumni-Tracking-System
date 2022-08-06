package miu.edu.AlumniTrackingSystem.service;

import miu.edu.AlumniTrackingSystem.dto.StudentDTO;
import miu.edu.AlumniTrackingSystem.entity.Department;

import java.util.List;

public interface StudentService extends UserService<StudentDTO>{
    List<StudentDTO> getStudentByState(String stateName);

    List<StudentDTO> getStudentByLastName(String lastName);

    List<StudentDTO> getStudentByCity(String cityName);

    List<StudentDTO> getStudentByMajor(Department major);
    List<StudentDTO> getStudentById(int id);
}

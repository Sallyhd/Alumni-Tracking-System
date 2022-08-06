package miu.edu.AlumniTrackingSystem.service;

import miu.edu.AlumniTrackingSystem.dto.DepartmentDTO;
import miu.edu.AlumniTrackingSystem.dto.StudentDTO;

import java.util.List;

public interface StudentService extends UserService<StudentDTO>{
    List<StudentDTO> getStudentByState(String stateName);

    List<StudentDTO> getStudentByLastName(String lastName);

    List<StudentDTO> getStudentByCity(String cityName);

    List<StudentDTO> getStudentByMajor(DepartmentDTO major);
    StudentDTO getStudentByUserName(String username);
    List<StudentDTO> getStudentById(int id);
    List<StudentDTO> findAll();
    StudentDTO findById(int id);
}

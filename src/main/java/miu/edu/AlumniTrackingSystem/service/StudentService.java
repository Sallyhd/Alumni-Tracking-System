package miu.edu.AlumniTrackingSystem.service;

import miu.edu.AlumniTrackingSystem.dto.DepartmentDTO;
import miu.edu.AlumniTrackingSystem.dto.JobExperienceDTO;
import miu.edu.AlumniTrackingSystem.dto.StudentDTO;
import miu.edu.AlumniTrackingSystem.dto.response.StudentResponse;

import java.util.List;

public interface StudentService extends UserService<StudentDTO>{
    List<StudentResponse> getStudentByState(String stateName);

    List<StudentResponse> getStudentByName(String name);

    List<StudentResponse> getStudentByCity(String cityName);

    List<StudentResponse> getStudentByMajor(DepartmentDTO major);
    StudentResponse getStudentByUserName(String username);
    List<StudentResponse> getStudentById(int id);
    List<StudentResponse> findAll();
    StudentResponse findById(int id);
    void AddJobExperience(int stdId , JobExperienceDTO jobExperienceResponse);
}

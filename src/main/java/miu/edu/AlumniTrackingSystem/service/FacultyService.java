package miu.edu.AlumniTrackingSystem.service;

import miu.edu.AlumniTrackingSystem.dto.FacultyDTO;
import miu.edu.AlumniTrackingSystem.dto.response.FacultyResponse;

import java.util.List;

public interface FacultyService extends UserService<FacultyDTO> {
    List<FacultyResponse> findAll();
    FacultyResponse findById(int id);
    FacultyResponse getFacultyByFirstnameAndLastname(String fname,String lname);
}

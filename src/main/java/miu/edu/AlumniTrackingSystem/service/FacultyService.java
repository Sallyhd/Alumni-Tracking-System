package miu.edu.AlumniTrackingSystem.service;

import miu.edu.AlumniTrackingSystem.dto.FacultyDTO;

import java.util.List;

public interface FacultyService extends UserService<FacultyDTO> {
    List<FacultyDTO> findAll();
    FacultyDTO findById(int id);
    FacultyDTO getFacultyByFirstnameAndLastname(String fname,String lname);
}

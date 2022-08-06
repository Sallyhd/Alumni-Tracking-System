package miu.edu.AlumniTrackingSystem.service;

import miu.edu.AlumniTrackingSystem.dto.DepartmentDTO;

import java.util.Optional;

public interface DepartmentService {

    Optional<DepartmentDTO> getById(int id);
}

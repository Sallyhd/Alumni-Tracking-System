package miu.edu.AlumniTrackingSystem.service.Impl;

import miu.edu.AlumniTrackingSystem.dto.DepartmentDTO;
import miu.edu.AlumniTrackingSystem.repository.DepartmentRepository;
import miu.edu.AlumniTrackingSystem.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Optional<DepartmentDTO> getById(int id) {
        return departmentRepo.findById(id).map(department->modelMapper.map(department,DepartmentDTO.class));
    }
}

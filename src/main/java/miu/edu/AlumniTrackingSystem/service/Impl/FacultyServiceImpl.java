package miu.edu.AlumniTrackingSystem.service.Impl;

import miu.edu.AlumniTrackingSystem.dto.FacultyDTO;
import miu.edu.AlumniTrackingSystem.entity.Faculty;
import miu.edu.AlumniTrackingSystem.repository.FacultyRepository;
import miu.edu.AlumniTrackingSystem.service.FacultyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void register(FacultyDTO newUser) {
        facultyRepository.save(modelMapper.map(newUser, Faculty.class));
    }

    @Override
    public void editProfile(FacultyDTO user) {
        facultyRepository.save(modelMapper.map(user, Faculty.class));
    }
}

package miu.edu.AlumniTrackingSystem.service.impls;

import miu.edu.AlumniTrackingSystem.dto.FacultyDTO;
import miu.edu.AlumniTrackingSystem.repository.FacultyRepository;
import miu.edu.AlumniTrackingSystem.service.FacultyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {
    private final FacultyRepository facultyRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public FacultyServiceImpl(FacultyRepository facultyRepo, ModelMapper modelMapper) {
        this.facultyRepo = facultyRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<FacultyDTO> findAll() {
        List<FacultyDTO> faculties = new ArrayList<>();
        facultyRepo.findAll().forEach((faculty)->{
            FacultyDTO facultyDTO = modelMapper.map(faculty, FacultyDTO.class);
            faculties.add(facultyDTO);
        });
        return faculties;
    }
}

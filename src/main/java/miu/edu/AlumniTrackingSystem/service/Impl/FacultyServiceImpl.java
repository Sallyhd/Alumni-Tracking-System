package miu.edu.AlumniTrackingSystem.service.Impl;

import miu.edu.AlumniTrackingSystem.dto.FacultyDTO;
import miu.edu.AlumniTrackingSystem.dto.StudentDTO;
import miu.edu.AlumniTrackingSystem.entity.Faculty;
import miu.edu.AlumniTrackingSystem.entity.Student;
import miu.edu.AlumniTrackingSystem.repository.FacultyRepository;
import miu.edu.AlumniTrackingSystem.service.FacultyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<FacultyDTO> findAll() {
        List<FacultyDTO> result = new ArrayList<FacultyDTO>();
        for (Faculty faculty : facultyRepository.findAll()) {
            result.add(modelMapper.map(faculty,FacultyDTO.class));
        }
        return result;
    }

    @Override
    public FacultyDTO findById(int id) {
        return modelMapper.map(facultyRepository.findById(id).get(),FacultyDTO.class);
    }

    @Override
    public FacultyDTO getFacultyByFirstnameAndLastname(String fname, String lname) {
        return modelMapper.map(facultyRepository.getFacultyByFirstnameAndLastname(fname,lname),FacultyDTO.class);
    }
}

package miu.edu.AlumniTrackingSystem.service.Impl;

import miu.edu.AlumniTrackingSystem.dto.FacultyDTO;
import miu.edu.AlumniTrackingSystem.dto.StudentDTO;
import miu.edu.AlumniTrackingSystem.dto.response.FacultyResponse;
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
    public void editProfile(int id ,FacultyDTO user) {
        Faculty f = modelMapper.map(user,Faculty.class);
        System.out.println("firstStudentDTO"+user);
        System.out.println("firstStudentDTO"+f);
        facultyRepository.save(modelMapper.map(user, Faculty.class));
    }

    @Override
    public List<FacultyResponse> findAll() {
        List<FacultyResponse> result = new ArrayList<FacultyResponse>();
        for (Faculty faculty : facultyRepository.findAll()) {
            result.add(modelMapper.map(faculty,FacultyResponse.class));
        }
        return result;
    }

    @Override
    public FacultyResponse findById(int id) {
        return modelMapper.map(facultyRepository.findById(id).get(),FacultyResponse.class);
    }

    @Override
    public FacultyResponse getFacultyByFirstnameAndLastname(String fname, String lname) {
        return modelMapper.map(facultyRepository.getFacultyByFirstnameAndLastname(fname,lname),FacultyResponse.class);
    }
}

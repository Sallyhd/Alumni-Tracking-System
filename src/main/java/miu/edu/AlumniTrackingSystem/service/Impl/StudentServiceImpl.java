package miu.edu.AlumniTrackingSystem.service.Impl;

import miu.edu.AlumniTrackingSystem.configuration.Utils;
import miu.edu.AlumniTrackingSystem.dto.StudentDTO;
import miu.edu.AlumniTrackingSystem.entity.Department;
import miu.edu.AlumniTrackingSystem.entity.Student;
import miu.edu.AlumniTrackingSystem.repository.StudentRepository;
import miu.edu.AlumniTrackingSystem.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void register(StudentDTO newUser) {
        studentRepository.save(modelMapper.map(newUser,Student.class));
    }

    @Override
    public void editProfile(StudentDTO user) {
        studentRepository.save(modelMapper.map(user,Student.class));
    }

    @Override
    public List<StudentDTO> getStudentByState(String state) {
        return Utils.mapList(studentRepository.getStudentByAddress_State(state),StudentDTO.class);
    }
    @Override
    public List<StudentDTO> getStudentByLastName(String lastName) {
        return Utils.mapList(studentRepository.getStudentsByLastname(lastName),StudentDTO.class);
    }

    @Override
    public List<StudentDTO> getStudentByCity(String cityName) {
        return Utils.mapList(studentRepository.getStudentByAddress_City(cityName),StudentDTO.class);
    }

    @Override
    public List<StudentDTO> getStudentByMajor(Department major) {
        return Utils.mapList(studentRepository.getStudentsByMajor(major),StudentDTO.class);
    }

    @Override
    public List<StudentDTO> getStudentById(int id) {
        return  null;
        //modelMapper
        //return Utils.mapList(studentRepository.findStudentsById(id),StudentDTO.class);
    }
}

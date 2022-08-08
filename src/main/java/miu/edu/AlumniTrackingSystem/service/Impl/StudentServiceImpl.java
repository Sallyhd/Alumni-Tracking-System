package miu.edu.AlumniTrackingSystem.service.Impl;

import miu.edu.AlumniTrackingSystem.configuration.Utils;
import miu.edu.AlumniTrackingSystem.dto.DepartmentDTO;
import miu.edu.AlumniTrackingSystem.dto.JobExperienceDTO;
import miu.edu.AlumniTrackingSystem.dto.StudentDTO;
import miu.edu.AlumniTrackingSystem.entity.Department;
import miu.edu.AlumniTrackingSystem.entity.JobExperience;
import miu.edu.AlumniTrackingSystem.entity.Student;
import miu.edu.AlumniTrackingSystem.repository.JobExperienceRepository;
import miu.edu.AlumniTrackingSystem.repository.StudentRepository;
import miu.edu.AlumniTrackingSystem.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private JobExperienceRepository jobExperienceRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void register(StudentDTO newUser) {
        studentRepository.save(modelMapper.map(newUser,Student.class));
    }

    @Override
    public void editProfile(StudentDTO user) {
        System.out.println("firstStudentDTO"+user);
        studentRepository.save(modelMapper.map(user,Student.class));
    }

    @Override
    public List<StudentDTO> getStudentByState(String state) {
        return Utils.mapList(studentRepository.getStudentByAddress_State(state),StudentDTO.class);
    }
    @Override
    public List<StudentDTO> getStudentByName(String name) {
        return Utils.mapList(studentRepository.getStudentsByFirstnameContaining(name),StudentDTO.class);
    }

    @Override
    public List<StudentDTO> getStudentByCity(String cityName) {
        return Utils.mapList(studentRepository.getStudentByAddress_City(cityName),StudentDTO.class);
    }

    @Override
    public List<StudentDTO> getStudentByMajor(DepartmentDTO major) {
        Department dept =modelMapper.map(major,Department.class);
        return Utils.mapList(studentRepository.getStudentsByMajor(dept),StudentDTO.class);
    }

    @Override
    public StudentDTO getStudentByUserName(String username) {
        return modelMapper.map(studentRepository.getStudentsByUsername(username),StudentDTO.class);
    }

    @Override
    public List<StudentDTO> getStudentById(int id) {
        return  null;
        //modelMapper
        //return Utils.mapList(studentRepository.findStudentsById(id),StudentDTO.class);
    }

    @Override
    public List<StudentDTO> findAll() {
        List<StudentDTO> result = new ArrayList<StudentDTO>();
        for (Student std : studentRepository.findAll()) {
            result.add(modelMapper.map(std,StudentDTO.class));
        }
        return result;
    }

    @Override
    public StudentDTO findById(int id) {
        return modelMapper.map(studentRepository.findById(id).get(),StudentDTO.class);
    }

    @Override
    public void AddJobExperience(int stdId ,JobExperienceDTO jobExperienceDTO) {
        Student std = studentRepository.findById(stdId).get();
        std.getProfessionalExperiences().add(modelMapper.map(jobExperienceDTO, JobExperience.class));
        studentRepository.save(std);
    }

}

package miu.edu.AlumniTrackingSystem.service.Impl;

import miu.edu.AlumniTrackingSystem.configuration.Utils;
import miu.edu.AlumniTrackingSystem.dto.DepartmentDTO;
import miu.edu.AlumniTrackingSystem.dto.JobAdvertisementDTO;
import miu.edu.AlumniTrackingSystem.dto.JobExperienceDTO;
import miu.edu.AlumniTrackingSystem.dto.StudentDTO;
import miu.edu.AlumniTrackingSystem.dto.response.StudentResponse;
import miu.edu.AlumniTrackingSystem.entity.Department;
import miu.edu.AlumniTrackingSystem.entity.JobAdvertisment;
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
    public void editProfile(int id , StudentDTO user) {
        System.out.println("firstStudentResponse"+user);
        studentRepository.save(modelMapper.map(user,Student.class));
    }

    @Override
    public List<StudentResponse> getStudentByState(String state) {
        List<StudentResponse> result = new ArrayList<StudentResponse>();
        for (Student std : studentRepository.getStudentByAddress_State(state)) {
            result.add(modelMapper.map(std,StudentResponse.class));
        }
        return result;
    }
    @Override
    public List<StudentResponse> getStudentByName(String name) {
        List<StudentResponse> result = new ArrayList<StudentResponse>();
        for (Student std : studentRepository.getStudentsByFirstnameContaining(name)) {
            result.add(modelMapper.map(std,StudentResponse.class));
        }
        return result;
    }

    @Override
    public List<StudentResponse> getStudentByCity(String cityName) {
        List<StudentResponse> result = new ArrayList<StudentResponse>();
        for (Student std : studentRepository.getStudentByAddress_City(cityName)) {
            result.add(modelMapper.map(std,StudentResponse.class));
        }
        return result;
    }

    @Override
    public List<StudentResponse> getStudentByMajor(DepartmentDTO major) {
        Department dept =modelMapper.map(major,Department.class);
        List<StudentResponse> result = new ArrayList<StudentResponse>();
        for (Student std : studentRepository.getStudentsByMajor(dept)) {
            result.add(modelMapper.map(std,StudentResponse.class));
        }
        return result;
    }

    @Override
    public StudentResponse getStudentByUserName(String username) {
        return modelMapper.map(studentRepository.getStudentByUsername(username),StudentResponse.class);
    }

    @Override
    public List<StudentResponse> getStudentById(int id) {
        return  null;
        //modelMapper
        //return Utils.mapList(studentRepository.findStudentsById(id),StudentResponse.class);
    }

    @Override
    public List<StudentResponse> findAll() {
        List<StudentResponse> result = new ArrayList<StudentResponse>();
        for (Student std : studentRepository.findAll()) {
            result.add(modelMapper.map(std,StudentResponse.class));
        }
        return result;
    }

    @Override
    public StudentResponse findById(int id) {
        return modelMapper.map(studentRepository.findById(id).get(),StudentResponse.class);
    }

    @Override
    public void AddJobExperience(int stdId ,JobExperienceDTO jobExperienceDTO) {
        Student std = studentRepository.findById(stdId).get();
        std.getProfessionalExperiences().add(modelMapper.map(jobExperienceDTO, JobExperience.class));
        studentRepository.save(std);
    }

}

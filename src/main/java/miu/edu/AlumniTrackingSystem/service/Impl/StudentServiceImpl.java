package miu.edu.AlumniTrackingSystem.service.Impl;

import miu.edu.AlumniTrackingSystem.entity.Student;
import miu.edu.AlumniTrackingSystem.repository.StudentRepository;
import miu.edu.AlumniTrackingSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;


    @Override
    public void register(Student newUser) {

    }

    @Override
    public void editProfile(Student user) {

    }
}

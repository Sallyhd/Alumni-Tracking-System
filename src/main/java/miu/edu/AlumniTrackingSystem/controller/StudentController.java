package miu.edu.AlumniTrackingSystem.controller;

import miu.edu.AlumniTrackingSystem.dto.StudentDTO;
import miu.edu.AlumniTrackingSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity register(@RequestBody StudentDTO newStudent)
    {
        studentService.register(newStudent);
        return  ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PostMapping("/edit")
    public ResponseEntity editProfile(@RequestBody StudentDTO student){
        studentService.editProfile(student);
        return  ResponseEntity.ok(HttpStatus.OK);
    }
}

package miu.edu.AlumniTrackingSystem.controller;

import miu.edu.AlumniTrackingSystem.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/faculties")
@CrossOrigin("*")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

}

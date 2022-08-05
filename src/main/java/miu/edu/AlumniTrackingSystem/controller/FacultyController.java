package miu.edu.AlumniTrackingSystem.controller;

import miu.edu.AlumniTrackingSystem.dto.FacultyDTO;
import miu.edu.AlumniTrackingSystem.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/faculties")
public class FacultyController {

    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping
    public List<FacultyDTO> findAll() {
        return facultyService.findAll();
    }


}

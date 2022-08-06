package miu.edu.AlumniTrackingSystem.controller;

import miu.edu.AlumniTrackingSystem.dto.FacultyDTO;
import miu.edu.AlumniTrackingSystem.dto.StudentDTO;
import miu.edu.AlumniTrackingSystem.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/faculties")
@CrossOrigin("*")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @GetMapping
    public ResponseEntity getFacultyList(){
        return  ResponseEntity.ok(facultyService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity getFacultyById(@PathVariable int id){
        return  ResponseEntity.ok(facultyService.findById(id));
    }
    @PostMapping
    public ResponseEntity register(@RequestBody FacultyDTO newFaculty)
    {
        facultyService.register(newFaculty);
        return  ResponseEntity.ok(HttpStatus.CREATED);
    }
    @PutMapping("/edit")
    public ResponseEntity editProfile(@RequestBody FacultyDTO faculty){
        facultyService.editProfile(faculty);
        return  ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/findByName")
    public ResponseEntity getFacultyByName(@RequestParam String fname, @RequestParam String lname){
        return  ResponseEntity.ok(facultyService.getFacultyByFirstnameAndLastname(fname,lname));
    }

}

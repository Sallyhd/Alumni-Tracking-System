package miu.edu.AlumniTrackingSystem.controller;

import miu.edu.AlumniTrackingSystem.dto.FacultyDTO;
import miu.edu.AlumniTrackingSystem.service.CommentService;
import miu.edu.AlumniTrackingSystem.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/faculties")
@CrossOrigin("*")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private CommentService commentService;

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
    @PutMapping(value = "/{id}")
    public ResponseEntity editProfile(@PathVariable int id,@RequestBody FacultyDTO faculty){
        System.out.println("firstStudentDTO"+faculty.getFirstname()+faculty.getId());
        facultyService.editProfile(id,faculty);
        return  ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/findByName")
    public ResponseEntity getFacultyByName(@RequestParam String fname, @RequestParam String lname){
        return  ResponseEntity.ok(facultyService.getFacultyByFirstnameAndLastname(fname,lname));
    }

    @GetMapping("/comments")
    public ResponseEntity getComments(){
        return  ResponseEntity.ok(commentService.getAllComment());
    }

}

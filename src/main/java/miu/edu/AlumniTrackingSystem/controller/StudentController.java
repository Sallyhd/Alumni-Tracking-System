package miu.edu.AlumniTrackingSystem.controller;

import miu.edu.AlumniTrackingSystem.dto.DepartmentDTO;
import miu.edu.AlumniTrackingSystem.dto.JobAdvAndFileDTO;
import miu.edu.AlumniTrackingSystem.dto.StudentDTO;
import miu.edu.AlumniTrackingSystem.entity.JobAdvertisment;
import miu.edu.AlumniTrackingSystem.service.DepartmentService;
import miu.edu.AlumniTrackingSystem.service.JobAdvertisementService;
import miu.edu.AlumniTrackingSystem.service.JobService;
import miu.edu.AlumniTrackingSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private DepartmentService deptService;

    @Autowired
    private JobService jobService;

    @PostMapping
    public ResponseEntity register(@RequestBody StudentDTO newStudent)
    {
        studentService.register(newStudent);
        return  ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity editProfile(@RequestBody StudentDTO student){
        studentService.editProfile(student);
        return  ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getStudents(){
        return  ResponseEntity.ok(studentService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity getStudentById(@PathVariable int id){
        return  ResponseEntity.ok(studentService.findById(id));
    }
    @GetMapping("/findByCity")
    public ResponseEntity getStudentByCity(@RequestParam String city){
        return  ResponseEntity.ok(studentService.getStudentByCity(city));
    }
    @GetMapping("/findByState")
    public ResponseEntity getStudentByState(@RequestParam String  state){
        return  ResponseEntity.ok(studentService.getStudentByState(state));
    }
    @GetMapping("/findByMajor")
    public ResponseEntity getStudentByMajor(@RequestParam int majorId){
        DepartmentDTO major = deptService.getById(majorId).get();
        return  ResponseEntity.ok(studentService.getStudentByMajor(major));
    }
    @GetMapping("/findByLastname")
    public ResponseEntity getStudentByLastname(@RequestParam String lastname){
        return  ResponseEntity.ok(studentService.getStudentByLastName(lastname));
    }
    @PostMapping("/JobAdv")
    public ResponseEntity addJobAdv(@RequestBody JobAdvAndFileDTO advAndFileDTO){
        try {
            jobService.saveJobAdvertisement(advAndFileDTO.getJobAdvertisementDTO(), advAndFileDTO.getFile());
            return ResponseEntity.ok(HttpStatus.CREATED);
        }catch(Exception ex){
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }
    }
}

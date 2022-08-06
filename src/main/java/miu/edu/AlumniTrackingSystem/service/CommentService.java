package miu.edu.AlumniTrackingSystem.service;

import miu.edu.AlumniTrackingSystem.dto.CommentDTO;
import miu.edu.AlumniTrackingSystem.entity.Faculty;
import miu.edu.AlumniTrackingSystem.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentService {


    public void AddComment(Student student, Faculty faculty, String discription);
    public List<CommentDTO> getAllComment();


}
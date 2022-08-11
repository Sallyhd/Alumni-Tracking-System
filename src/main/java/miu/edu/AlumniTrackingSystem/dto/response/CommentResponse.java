package miu.edu.AlumniTrackingSystem.dto.response;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.AlumniTrackingSystem.entity.Faculty;
import miu.edu.AlumniTrackingSystem.entity.Student;

import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponse {

  private int id;
  private String discription;
  private StudentResponse student;

  private FacultyResponse faculty;

}

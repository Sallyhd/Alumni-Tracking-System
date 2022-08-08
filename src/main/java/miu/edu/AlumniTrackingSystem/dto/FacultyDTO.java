package miu.edu.AlumniTrackingSystem.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.AlumniTrackingSystem.entity.Address;
import miu.edu.AlumniTrackingSystem.entity.Comment;
import miu.edu.AlumniTrackingSystem.entity.Department;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacultyDTO extends UserDTO {
    @JsonManagedReference(value="stdComm")
    private List<CommentDTO> comments;
    @JsonManagedReference(value="faculty")
    private AddressDTO address;
    private DepartmentDTO department;
}

package miu.edu.AlumniTrackingSystem.dto.response;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.AlumniTrackingSystem.dto.DepartmentDTO;
import miu.edu.AlumniTrackingSystem.dto.UserDTO;
import miu.edu.AlumniTrackingSystem.entity.Address;
import miu.edu.AlumniTrackingSystem.entity.Comment;
import miu.edu.AlumniTrackingSystem.entity.Department;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacultyResponse extends UserDTO {

    @JsonManagedReference(value="facultyAddressResponse")
    private AddressResponse address;
    private DepartmentDTO department;
}

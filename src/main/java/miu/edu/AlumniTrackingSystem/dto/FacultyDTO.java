package miu.edu.AlumniTrackingSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.AlumniTrackingSystem.entity.Address;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacultyDTO {
    private  String email;
    private String username;
    private String password;

    private boolean active;
    private LocalDateTime LastLoggedInAt;

    private Address address;
}

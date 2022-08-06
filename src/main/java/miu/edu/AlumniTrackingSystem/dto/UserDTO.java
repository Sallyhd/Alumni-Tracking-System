package miu.edu.AlumniTrackingSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int id;
    private String firstname;
    private String lastname;

    private  String email;
    private String username;
    private String password;

    private boolean active;
    private LocalDateTime LastLoggedInAt;
}

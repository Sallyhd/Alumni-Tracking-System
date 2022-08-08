package miu.edu.AlumniTrackingSystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int id;
    private String firstname;
    private String lastname;

    private  String email;
    private String username;
    @JsonIgnore
    private String password;

    private boolean active;
    private Date LastLoggedInAt;
}

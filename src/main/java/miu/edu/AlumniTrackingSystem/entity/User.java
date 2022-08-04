package miu.edu.AlumniTrackingSystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Users")
public class User extends BaseClass{

    private  String email;
    private String username;
    private String password;

    private boolean active;
    private LocalDateTime LastLoggedInAt;
    private boolean isDeleted;
}

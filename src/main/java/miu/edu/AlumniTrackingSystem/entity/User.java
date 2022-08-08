package miu.edu.AlumniTrackingSystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Users")
public class User extends BaseClass{

    private String firstname;
    private String lastname;

    private  String email;
    private String username;
    private String password;

    private boolean active;
    private Date LastLoggedInAt;
}

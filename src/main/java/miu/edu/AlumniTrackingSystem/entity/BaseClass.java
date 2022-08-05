package miu.edu.AlumniTrackingSystem.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class BaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  int id;

    private boolean isDeleted;
}

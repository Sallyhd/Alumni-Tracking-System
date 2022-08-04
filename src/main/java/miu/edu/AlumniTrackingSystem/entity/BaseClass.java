package miu.edu.AlumniTrackingSystem.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class BaseClass {
    @Id
    @GeneratedValue
    private  int id;

    private boolean isDeleted;
}

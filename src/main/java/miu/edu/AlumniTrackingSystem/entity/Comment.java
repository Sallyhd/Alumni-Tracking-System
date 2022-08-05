package miu.edu.AlumniTrackingSystem.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Comment extends BaseClass{
    @ManyToOne
    private Student student;

    @ManyToOne
    private Faculty faculty;


    private String discription;
}

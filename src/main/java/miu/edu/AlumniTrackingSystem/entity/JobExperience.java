package miu.edu.AlumniTrackingSystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class JobExperience extends BaseClass{
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Tag> tags;

    @ManyToOne
    private Student student;
}

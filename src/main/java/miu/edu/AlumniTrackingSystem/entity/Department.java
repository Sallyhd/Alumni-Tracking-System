package miu.edu.AlumniTrackingSystem.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Department {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(mappedBy = "major")
    private List<Student> students;

    @OneToMany(mappedBy = "department")
    private List<Faculty> facultyList;

}

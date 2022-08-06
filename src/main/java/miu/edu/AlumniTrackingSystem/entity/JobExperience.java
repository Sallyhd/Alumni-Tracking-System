package miu.edu.AlumniTrackingSystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class JobExperience extends BaseClass{

   private String companyName;
   private LocalDate startDate;
   private LocalDate finishDate;
   private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Tag> tags;

    @ManyToOne
    private Student student;
}

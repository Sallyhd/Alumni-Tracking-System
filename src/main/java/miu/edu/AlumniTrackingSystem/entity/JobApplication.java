package miu.edu.AlumniTrackingSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class JobApplication extends BaseClass{
    @JsonBackReference(value = "applicationsEntity")
    @ManyToOne
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    private JobAdvertisment jobAdvertisment;
}

package miu.edu.AlumniTrackingSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class JobApplication extends BaseClass{
    @ManyToOne
    private Student student;

    @ManyToOne
    private JobAdvertisment jobAdvertisment;


}

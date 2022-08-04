package miu.edu.AlumniTrackingSystem.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address extends BaseClass{
    @OneToOne
    @JoinColumn
    private Student student;

    @OneToOne
    @JoinColumn
    private Faculty faculty;

    @OneToOne
    @JoinColumn
    private JobAdvertisment jobAdvertisment;
}

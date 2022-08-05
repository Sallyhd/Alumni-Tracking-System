package miu.edu.AlumniTrackingSystem.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address extends BaseClass{
    @OneToOne(mappedBy = "address")
    private Student student;

    @OneToOne(mappedBy = "address")
    private Faculty faculty;

    @OneToOne(mappedBy = "address")
    private JobAdvertisment jobAdvertisment;
}

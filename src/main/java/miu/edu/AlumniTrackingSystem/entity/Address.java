package miu.edu.AlumniTrackingSystem.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address extends BaseClass{

    @NotNull
    private String street;

    @NotNull
    private String city;

    @NotNull
    private String state;

    @NotNull
    private int zip;

    @OneToOne(mappedBy = "address")
    private Student student;

    @OneToOne(mappedBy = "address")
    private Faculty faculty;

    @OneToOne(mappedBy = "address")
    private JobAdvertisment jobAdvertisment;
}

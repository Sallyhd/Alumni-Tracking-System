package miu.edu.AlumniTrackingSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
public class JobAttachment extends BaseClass {

    private String name;

    private String url;

    @ManyToOne
    @JsonBackReference("jobAttatchmentsEntity")
    private JobAdvertisment jobAdvertisment;

}

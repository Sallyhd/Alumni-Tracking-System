package miu.edu.AlumniTrackingSystem.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
public class JobAttachment extends BaseClass {

    private String name;

    private String url;

    @ManyToOne
    private JobAdvertisment jobAdvertisment;

}

package miu.edu.AlumniTrackingSystem.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class JobAttatchment extends BaseClass {

    @ManyToOne
    private JobAdvertisment jobAdvertisment;
}

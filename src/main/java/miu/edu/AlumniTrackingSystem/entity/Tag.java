package miu.edu.AlumniTrackingSystem.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@Entity
public class Tag extends BaseClass{

    @ManyToMany(mappedBy = "tags")
    private List<JobAdvertisment> jobAdvertisments;
}

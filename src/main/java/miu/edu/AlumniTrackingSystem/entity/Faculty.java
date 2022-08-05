package miu.edu.AlumniTrackingSystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@PrimaryKeyJoinColumns({
        @PrimaryKeyJoinColumn(name="User_Id",referencedColumnName="id")})
public class Faculty extends  User{

    @OneToMany(mappedBy = "faculty")
    private List<Comment> comments;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @ManyToOne
    private Department department;
}

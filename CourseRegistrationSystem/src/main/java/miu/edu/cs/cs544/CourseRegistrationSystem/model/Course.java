package miu.edu.cs.cs544.CourseRegistrationSystem.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String code;
    private String description;
    @OneToMany
    private List<CourseOffering> courseOfferings;
}

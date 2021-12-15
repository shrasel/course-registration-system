package miu.edu.cs.cs544.CourseRegistrationSystem.Model;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.CourseOffering;
import lombok.Data;

import javax.persistence.*;
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

    @OneToMany(fetch = FetchType.LAZY)
    private List<CourseOffering> courseOfferings;
}

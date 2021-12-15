package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import lombok.Data;
import miu.edu.cs.cs544.CourseRegistrationSystem.Enum.Semester;

import javax.persistence.*;

@Entity
@Data
public class AcademicBlock {
    @Id
    @GeneratedValue
    private Integer id;
    private String code;
    private String name;

    @Enumerated(EnumType.STRING)
    private Semester semester;
}

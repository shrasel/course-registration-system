package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import lombok.Data;

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

    public AcademicBlock() {
    }

    public AcademicBlock(Integer id, String code, String name, Semester semester) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.semester = semester;
    }
}

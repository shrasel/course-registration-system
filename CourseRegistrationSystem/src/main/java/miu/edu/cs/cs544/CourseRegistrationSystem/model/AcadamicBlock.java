package miu.edu.cs.cs544.CourseRegistrationSystem.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class AcadamicBlock {
    private Integer id;
    private String code;
    private String name;

    @Enumerated(EnumType.STRING)
    private Semester semester;
}

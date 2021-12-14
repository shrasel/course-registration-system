package miu.edu.cs.cs544.CourseRegistrationSystem.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class AcadamicBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate StartDate;

    private LocalDate EndDate;


    private List<CourseOffering> courseOfferings;


    @Enumerated(EnumType.STRING)
    private Semester semester;
}

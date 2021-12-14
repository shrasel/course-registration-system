package miu.edu.cs.cs544.CourseRegistrationSystem.controller;

import lombok.Data;
import miu.edu.cs.cs544.CourseRegistrationSystem.model.CourseOffering;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class AcadmicBlockController {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate StartDate;

    private LocalDate EndDate;

    private String Semester;

    private List<CourseOffering> courseOfferings;



}

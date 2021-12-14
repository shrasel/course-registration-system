package miu.edu.cs.cs544.CourseRegistrationSystem.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcadamicBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate StartDate;

    private LocalDate EndDate;

    private String Semester;

    @OneToMany
    private List<CourseOffering> courseOfferings;

    @Enumerated(EnumType.STRING)
    private Semester semester;
}

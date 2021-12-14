package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private List<CourseOffering> courseOfferings;

    @Enumerated(EnumType.STRING)
    private Semester semester;
}

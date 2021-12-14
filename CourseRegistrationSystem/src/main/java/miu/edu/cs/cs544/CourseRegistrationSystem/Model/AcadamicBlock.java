package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcadamicBlock {
    @Id
    @GeneratedValue
	private Long id;
    private String code;
    private String name;

    @Enumerated(EnumType.STRING)
    private Semester semester;
}

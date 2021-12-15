package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany
    private List<RegistrationGroup> registrationGroups;
}

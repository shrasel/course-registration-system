package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class RegistrationEvent {
    @Id
    @GeneratedValue
    private  int id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany
    private List<RegistrationGroup> registrationGroups;
}

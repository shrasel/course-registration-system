package miu.edu.cs.cs544.CourseRegistrationSystem.model;

import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

public class RegistrationEvent {
    private  int id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany
    private List<RegistrationGroup> registrationGroups;
}

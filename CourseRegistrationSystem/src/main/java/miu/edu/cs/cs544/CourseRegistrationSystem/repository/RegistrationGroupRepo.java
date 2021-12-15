package miu.edu.cs.cs544.CourseRegistrationSystem.repository;

import miu.edu.cs.cs544.CourseRegistrationSystem.Enum.Group;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Registration;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.RegistrationGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RegistrationGroupRepo extends JpaRepository<RegistrationGroup,Integer> {
    RegistrationGroup findByGroup(Group name);
}

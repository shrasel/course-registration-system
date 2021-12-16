package miu.edu.cs.cs544.CourseRegistrationSystem.repository;

import miu.edu.cs.cs544.CourseRegistrationSystem.Model.RegistrationGroupStudents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationGroupStudentRepo extends JpaRepository<RegistrationGroupStudents,Integer> {

}

package miu.edu.cs.cs544.CourseRegistrationSystem.repository;

import miu.edu.cs.cs544.CourseRegistrationSystem.model.RegistrationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional

public interface RegistrationRequestRepository extends JpaRepository<RegistrationRequest, Integer> {


}

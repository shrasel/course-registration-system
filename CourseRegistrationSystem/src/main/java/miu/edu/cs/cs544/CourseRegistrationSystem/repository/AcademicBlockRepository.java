package miu.edu.cs.cs544.CourseRegistrationSystem.repository;


import miu.edu.cs.cs544.CourseRegistrationSystem.model.AcademicBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AcademicBlockRepository extends JpaRepository<AcademicBlock,Integer> {
}


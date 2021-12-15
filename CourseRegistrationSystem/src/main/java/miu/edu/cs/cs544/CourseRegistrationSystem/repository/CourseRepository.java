package miu.edu.cs.cs544.CourseRegistrationSystem.repository;

import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CourseRepository extends JpaRepository<Course,Integer> {
}

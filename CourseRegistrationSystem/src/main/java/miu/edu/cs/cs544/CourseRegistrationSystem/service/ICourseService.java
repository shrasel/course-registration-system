package miu.edu.cs.cs544.CourseRegistrationSystem.service;

import miu.edu.cs.cs544.CourseRegistrationSystem.Model.AcademicBlock;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Course;
import miu.edu.cs.cs544.CourseRegistrationSystem.repository.AcademicBlockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICourseService {
    public List<Course> findAll() ;

    public Course getOne(int id);

    public Course addCourse(Course course);

    public Course updateCourse(Integer id,Course course) ;

    public void deletecourse(Integer id,Course course);
}

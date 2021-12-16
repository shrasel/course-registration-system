package miu.edu.cs.cs544.CourseRegistrationSystem.service;


import miu.edu.cs.cs544.CourseRegistrationSystem.model.Course;
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


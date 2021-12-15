package miu.edu.cs.cs544.CourseRegistrationSystem.service.Impl;

import lombok.Data;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Course;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.CourseOffering;
import miu.edu.cs.cs544.CourseRegistrationSystem.repository.CourseRepository;
import miu.edu.cs.cs544.CourseRegistrationSystem.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Data
public class CourseServiceImpl implements ICourseService {

    @Autowired
    CourseRepository repository;

    @Override
    public List<Course> findAll() {
        return repository.findAll();
    }

    @Override
    public Course getOne(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Course addCourse(Course course) {
        return repository.save(course);
    }

    @Override
    public Course updateCourse(Integer id, Course course) {
        Course newcourse = repository.findById(id).orElse(null);
        course.setName(course.getName());
        course.setCode(course.getCode());
        return repository.save(newcourse);
    }

    @Override
    public void deletecourse(Integer id,Course course) {
repository.delete(course);
    }
}

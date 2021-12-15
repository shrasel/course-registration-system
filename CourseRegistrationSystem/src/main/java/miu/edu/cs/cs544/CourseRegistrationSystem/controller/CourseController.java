package miu.edu.cs.cs544.CourseRegistrationSystem.controller;

import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Course;
import miu.edu.cs.cs544.CourseRegistrationSystem.service.Impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/course")
@Transactional
public class CourseController {

    @Autowired
    CourseServiceImpl courseService;

    @PostMapping
    public Course createCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }
    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.findAll();
    }
@GetMapping("/{id}")
    public Course getOneCourse(@PathVariable int id){
        return courseService.getOne(id);
    }
    @PutMapping(value = {"id"})
    public Course updateCourse(@PathVariable Integer id,@RequestBody Course course) {
        return courseService.updateCourse(id,course);
    }
 @DeleteMapping(value = {"id"})
    public void deletecourse(@PathVariable Integer id,@RequestBody Course course){
        courseService.deletecourse(id,course);
    }

}

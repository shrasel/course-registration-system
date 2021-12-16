package miu.edu.cs.cs544.CourseRegistrationSystem.controller;

import miu.edu.cs.cs544.CourseRegistrationSystem.model.CourseOffering;
import miu.edu.cs.cs544.CourseRegistrationSystem.service.CourseOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courseoffering")
public class CourseOfferingController {

    @Autowired
    private CourseOfferingService courseOfferingService;

    @PostMapping
    public CourseOffering createCourseOffering(@RequestBody CourseOffering courseOffering) {
        return courseOfferingService.create(courseOffering);

    }
    @PutMapping("/{courseOfferingId}")
    public ResponseEntity<?> updateCourseOffering(@PathVariable int courseOfferingId, @RequestBody CourseOffering courseOffering) {
        if (courseOfferingId==courseOffering.getId()) {
            return ResponseEntity.ok(courseOfferingService.update(courseOfferingId, courseOffering));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping
    public String listCoursesOffering(Model model) {
        model.addAttribute("CoursesOffering", courseOfferingService.findAll());
        return "CoursesOffering";
    }
    @GetMapping("/delete")
    public String deleteCourseOffering(Model model, @PathVariable("courseOffering") int courseOfferingId) {
        courseOfferingService.deleteCourseOffering(courseOfferingId);
        return listCoursesOffering(model);
    }


}

package miu.edu.cs.cs544.CourseRegistrationSystem.controller;

import miu.edu.cs.cs544.CourseRegistrationSystem.Model.CourseOffering;
import miu.edu.cs.cs544.CourseRegistrationSystem.service.CourseOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/courseoffering")
public class CourseOfferingController {

    @Autowired
    private CourseOfferingService courseOfferingService;

    @PostMapping("/add")
    public ResponseEntity<CourseOffering> addCourseOffering(@RequestBody  CourseOffering courseOffering){
        CourseOffering addedcourseoffering= courseOfferingService.add(courseOffering);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedcourseoffering.getId())
                .toUri();
        return ResponseEntity.created(uri).body(addedcourseoffering);
    }
    @GetMapping("/{id}")
    public CourseOffering findByid(@PathVariable int  id) {
        return courseOfferingService.findById(id).get();
    }
    @GetMapping("/all")
    public List<CourseOffering> listAllCourseOffering() {
        return courseOfferingService.findAll();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<CourseOffering> updateCourseOffering(@PathVariable int id, @RequestBody  CourseOffering courseOffering){
        CourseOffering updatedCourseOffering=null;
        CourseOffering tobeUpdateCourseOffering =courseOfferingService.findById(id).get();
        if(tobeUpdateCourseOffering==null){
            updatedCourseOffering= courseOfferingService.add(courseOffering);
        }else {
            courseOffering.setId(tobeUpdateCourseOffering.getId());
            updatedCourseOffering= courseOfferingService.update(courseOffering);
        }
        return  ResponseEntity.ok(updatedCourseOffering);
    }




}

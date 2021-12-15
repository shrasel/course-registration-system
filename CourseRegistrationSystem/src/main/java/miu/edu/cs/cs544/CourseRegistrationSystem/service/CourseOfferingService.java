package miu.edu.cs.cs544.CourseRegistrationSystem.service;

import miu.edu.cs.cs544.CourseRegistrationSystem.Model.CourseOffering;
import miu.edu.cs.cs544.CourseRegistrationSystem.repository.CourseOfferingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public  class CourseOfferingService {

    @Autowired
    private CourseOfferingRepository courseOfferingRepository ;

    public Optional<CourseOffering> findById(int id) {

        return courseOfferingRepository.findById(id);
    }

    public List<CourseOffering> findAll() {

        return courseOfferingRepository.findAll();
    }

    public CourseOffering add(CourseOffering c) {
        return  courseOfferingRepository.save(c);
    }

    public CourseOffering update(CourseOffering c) {
        return  courseOfferingRepository.save(c);
    }
}
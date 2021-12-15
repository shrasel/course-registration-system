package miu.edu.cs.cs544.CourseRegistrationSystem.service;

import miu.edu.cs.cs544.CourseRegistrationSystem.Model.CourseOffering;
import miu.edu.cs.cs544.CourseRegistrationSystem.repository.CourseOfferingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CourseOfferingService {
    @Autowired
    private CourseOfferingRepository courseOfferingRepository ;

    public CourseOffering create(CourseOffering courseOffering) {
        return courseOfferingRepository.save(courseOffering);
    }
    public Optional<CourseOffering> findById(int courseOfferingId) {
        return courseOfferingRepository.findById(courseOfferingId);
    }

    public CourseOffering update(int courseOfferingId,CourseOffering courseOffering) {
        CourseOffering entity = findById(courseOfferingId).orElse(null);
        entity.setCode(courseOffering.getCode());
        entity.setFaculty(courseOffering.getFaculty());
        entity.setCapacity(courseOffering.getCapacity());
        entity.setNbOfRegisteredStudent(courseOffering.getNbOfRegisteredStudent());
        return courseOfferingRepository.save(entity);
    }
    public void deleteCourseOffering(Integer courseOfferingId) {
        courseOfferingRepository.deleteById(courseOfferingId);
    }

    public List<CourseOffering> findAll() {
        return courseOfferingRepository.findAll();
    }
}

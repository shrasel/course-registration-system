package miu.edu.cs.cs544.CourseRegistrationSystem.service;

import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Registration;
import miu.edu.cs.cs544.CourseRegistrationSystem.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository ;

    public Registration create(Registration registration) {

        return registrationRepository.save(registration);
    }
    public Optional<Registration> findById(int registrationId) {
        return registrationRepository.findById(registrationId);
    }

    /*public Registration update(int registrationId,Registration registration) {
        Registration entity = findById(registrationId).orElse(null);
        entity.setStudentId(registration.getStudentId());
        entity.setCourseId(registration.getCourseId());
        entity.setCourseOffering(registration.getCourseOffering());
        return registrationRepository.save(entity);
    }*/
    public void deleteRegistration (Integer registrationId) {
        registrationRepository.deleteById(registrationId);
    }

    public List<Registration> findAll() {
        return registrationRepository.findAll();
    }
}

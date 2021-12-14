package miu.edu.cs.cs544.CourseRegistrationSystem.service;

import miu.edu.cs.cs544.CourseRegistrationSystem.Model.CourseOffering;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Registration;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.RegistrationRequest;
import miu.edu.cs.cs544.CourseRegistrationSystem.repository.RegistrationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.ManyToOne;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationRequestService {
    @Autowired
    private RegistrationRequestRepository registrationRequestRepository ;

    public RegistrationRequest create(RegistrationRequest registrationRequest) {
        return registrationRequestRepository.save(registrationRequest);
    }
    public Optional<RegistrationRequest> findById(int registrationRequestId) {
        return registrationRequestRepository.findById(registrationRequestId);
    }

    public RegistrationRequest update(int registrationRequestId,RegistrationRequest registrationRequest) {
        RegistrationRequest entity = findById(registrationRequestId).orElse(null);
        entity.setCourseCode(registrationRequest.getCourseCode());
        entity.setPriority(registrationRequest.getPriority());
        entity.setRegistration(registrationRequest.getRegistration());
        return registrationRequestRepository.save(entity);
    }
    public void deleteRegistrationRequest (Integer registrationRequestId) {
        registrationRequestRepository.deleteById(registrationRequestId);
    }

    public List<RegistrationRequest> findAll() {
        return registrationRequestRepository.findAll();
    }
}

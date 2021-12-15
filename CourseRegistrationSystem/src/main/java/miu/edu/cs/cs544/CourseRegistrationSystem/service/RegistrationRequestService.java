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

    public RegistrationRequest add(RegistrationRequest r) {
        return  registrationRequestRepository.save(r);
    }
    public List<RegistrationRequest> findAll() {

        return registrationRequestRepository.findAll();
    }
}

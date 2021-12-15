package miu.edu.cs.cs544.CourseRegistrationSystem.service;

import miu.edu.cs.cs544.CourseRegistrationSystem.Model.CourseOffering;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Registration;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.RegistrationRequest;
import miu.edu.cs.cs544.CourseRegistrationSystem.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository ;

}

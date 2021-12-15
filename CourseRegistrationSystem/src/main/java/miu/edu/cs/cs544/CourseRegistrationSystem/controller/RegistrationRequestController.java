package miu.edu.cs.cs544.CourseRegistrationSystem.controller;

import miu.edu.cs.cs544.CourseRegistrationSystem.Model.CourseOffering;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Registration;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.RegistrationRequest;
import miu.edu.cs.cs544.CourseRegistrationSystem.service.RegistrationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/registrationrequest")
public class RegistrationRequestController {
    @Autowired
    private RegistrationRequestService registrationRequestService;

    @PostMapping("/add")
    public ResponseEntity<RegistrationRequest> addRegistrationRequest(@RequestBody @Valid RegistrationRequest registrationRequest){
        RegistrationRequest addedRegistrationRequest= registrationRequestService.add(registrationRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedRegistrationRequest.getId())
                .toUri();
        return ResponseEntity.created(uri).body(addedRegistrationRequest);
    }
    @GetMapping("/all")
    public List<RegistrationRequest> listAllRegistrationRequest() {

        return registrationRequestService.findAll();
    }
}

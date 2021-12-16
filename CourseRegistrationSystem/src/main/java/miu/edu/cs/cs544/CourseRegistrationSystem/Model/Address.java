package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Embeddable
@Data
public class Address {
    private String street;
    private String city;
    private String postalCode;
    private String state;
    private String country;

    public Address() {
    }

    public Address(String street, String city, String postalCode, String state, String country) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.state = state;
        this.country = country;
    }
}

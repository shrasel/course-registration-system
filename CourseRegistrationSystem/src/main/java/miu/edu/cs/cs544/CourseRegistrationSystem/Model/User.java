package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @Column(nullable = false, unique = true, updatable = false)
    private String email;
    private String role;
    private String username;
    private String password;

    @Column(nullable = false)
    private Address address;

    public User() {
    }

    public User(Integer id, String name, String email, String role, String username, String password, Address address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.username = username;
        this.password = password;
        this.address = address;
    }
}

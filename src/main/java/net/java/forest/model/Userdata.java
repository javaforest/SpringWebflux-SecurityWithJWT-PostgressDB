package net.java.forest.model;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class Userdata {
    @Id
    private Long id;
    @NotBlank(message = "Firstname should not be empty")
    private String firstName;
    @NotBlank(message = "Lastname should not be empty")
    private String lastName;
    @NotBlank(message = "Password should not be empty")
    private String password;
    @Email(message = "Invalid email address")
    @UniqueElements(message = "Should be unique")
    private String email;
    private String address;

    public Userdata(Long id, String firstName, String lastName, String password, String email, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdddress() {
        return address;
    }

    public void setAdddress(String adddress) {
        this.address = adddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

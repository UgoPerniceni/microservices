package fr.esgi.registry.profile.model;

import fr.esgi.registry.profile.validator.StrongPassword;

import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class ProfileDTO {

    private final String firstName;

    private final String lastName;

    @Email
    private final String email;

    @StrongPassword
    private final String password;

    @Past
    private final LocalDate birthDate;

    public ProfileDTO(String firstName, String lastName, String email, String password, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}

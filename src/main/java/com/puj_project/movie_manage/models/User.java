package com.puj_project.movie_manage.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.*;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Size(min=2, max=20, message = "Polje ime mora biti između 2 i 20 znakova.")
    @NotBlank(message="Polje ime je obavezno")
    String firstName;

    @Size(min=2, max=20, message = "Polje prezime mora biti između 2 i 20 znakova.")
    @NotBlank(message="Polje prezime je obavezno")
    String lastName;

    @NotBlank(message="Polje email je obavezno")
    @Email(message = "Email adresa mora biti u valjanom formatu.")
    String email;

    @NotBlank(message = "Molimo unesite lozinku")
    String password;

    @NotBlank(message = "Molimo potvrdite lozinku")
    @Transient
    private String confirmPassword;

    private String role = "ROLE_USER";

    private boolean enabled;

    public User() {}

    public User(Long id, String firstName, String lastName, String email, String password, String confirmPassword, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.role = "ROLE_USER";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @Size(min=2, max=20, message = "Polje ime mora biti između 2 i 20 znakova.") @NotBlank(message="Polje ime je obavezno") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@Size(min=2, max=20, message = "Polje ime mora biti između 2 i 20 znakova.") @NotBlank(message="Polje ime je obavezno")String firstName) {
        this.firstName = firstName;
    }

    public @Size(min=2, max=20, message = "Polje prezime mora biti između 2 i 20 znakova.")
    @NotBlank(message="Polje prezime je obavezno") String getLastName() {
        return lastName;
    }

    public void setLastName(@Size(min=2, max=20, message = "Polje prezime mora biti između 2 i 20 znakova.")
                            @NotBlank(message="Polje prezime je obavezno") String lastName) {
        this.lastName = lastName;
    }

    public @NotBlank(message="Polje email je obavezno")
    @Email(message = "Email adresa mora biti u valjanom formatu.")
    String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message="Polje email je obavezno")
                         @Email(message = "Email adresa mora biti u valjanom formatu.")
                         String email) {
        this.email = email;
    }

    public @NotBlank(message = "Molimo unesite lozinku")
    String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Molimo unesite lozinku")
                            String password) {
        this.password = password;
    }

    public @NotBlank(message = "Molimo potvrdite lozinku")
    @Transient String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(@NotBlank(message = "Molimo potvrdite lozinku")
                                   String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @AssertTrue(message = "Passwords must match")
    public boolean isPasswordsEqual(){
        try {
            return this.password.equals(this.confirmPassword);
        } catch (Exception e){
            return false;
        }
    }
}

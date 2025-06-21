package com.phenom.flat_mate.entity;

import com.phenom.flat_mate.enums.UserType;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    
    private String firstName;
    private String lastName;
    private UserType userType;
    private String contact;
    private String email;
    private boolean isValid;

}

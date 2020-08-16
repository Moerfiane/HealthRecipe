package org.launchcode.health_recipe.models.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterFormDTO extends LoginFormDTO {

    private String verifyPassword;


    @Size(min=3, max=30, message = "Invalid name, must be between 3 and 30 characters.")
    private String name;

    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message ="Email not valid, must have at least a minimum of 9 " +
            "characters and include @ symbol" )
    @Size(min=9)
    private String email;


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }


    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    @Override
    public String toString() {
        return email;
    }
}
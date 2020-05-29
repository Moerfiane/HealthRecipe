package org.launchcode.health_recipe.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginFormDTO  {

    @Size(min=3, max=30, message = "Invalid name, must be between 3 and 30 characters.")
    private String name;

    @NotNull
    @NotBlank
    @Size(min=3, max=30, message = "Invalid username, must be between 3 and 30 characters.")
    private String username;

    @NotNull
    @NotBlank
    @Size(min=3, max=20, message = "Invalid username, must be between 3 and 20 characters.")
    private  String password;

    @NotNull
    private int access;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        this.access = access;
    }

    @Override
    public String toString() {
        return name;
    }
}

// LisaFix13 push 05/29/2020

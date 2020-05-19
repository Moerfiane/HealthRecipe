package org.launchcode.health_recipe.models;

import org.launchcode.health_recipe.Health_RecipeApplication;
import org.launchcode.health_recipe.models.data.DietaryRestrictionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import javax.persistence.*;
import java.io.Serializable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class DietaryRestrictionsSearch {

    @Id
    private int restrict_id;

    @Column
    private String restrictions;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @ManyToMany
    private List<User> users = new ArrayList<>();

    public DietaryRestrictionsSearch() {}


    public DietaryRestrictionsSearch(String restrictions, int restrict_id) {
        super();
        this.restrictions = restrictions;
        this.restrict_id = restrict_id;
    }
  //getters and setters

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    public int getRestrict_id() {
        return restrict_id;
    }

    public void setRestrict_id(int restrict_id) {
        this.restrict_id = restrict_id;
    }

    @Override
    public String toString() {
        return "DietaryRestrictionsSearch{" +
                "restrictions='" + restrictions + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DietaryRestrictionsSearch)) return false;
        if (!super.equals(o)) return false;
        DietaryRestrictionsSearch that = (DietaryRestrictionsSearch) o;
        return getRestrict_id() == that.getRestrict_id();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getRestrict_id());
    }
}


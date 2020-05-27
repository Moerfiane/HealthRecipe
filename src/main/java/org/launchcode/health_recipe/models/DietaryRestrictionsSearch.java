package org.launchcode.health_recipe.models;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class DietaryRestrictionsSearch {

    @Id
    private Integer restrict_id;

    @Column
    private String restrictions;

    public List<UserPreference> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<UserPreference> preferences) {
        this.preferences = preferences;
    }

    @ManyToMany(mappedBy = "dietaryrestrictionssearches")
    private List<UserPreference> preferences = new ArrayList<>();

    public DietaryRestrictionsSearch() {}

    public DietaryRestrictionsSearch(Integer restrict_id, String restrictions) {
        this.restrict_id = restrict_id;
        this.restrictions = restrictions;
    }

    //getters and setters

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    public Integer getRestrict_id() {
        return restrict_id;
    }

    public void setRestrict_id(Integer restrict_id) {
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


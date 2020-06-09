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

//    @Column
//    private Integer cond_id;

    @Column
    private String health_conds;

    public List<UserPreference> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<UserPreference> preferences) {
        this.preferences = preferences;
    }

    @ManyToMany(mappedBy = "dietaryrestrictionssearches")
    private List<UserPreference> preferences = new ArrayList<>();

    public DietaryRestrictionsSearch() {}

    public DietaryRestrictionsSearch(Integer restrict_id, String restrictions, String health_conds) {
        this.restrict_id = restrict_id;
        this.restrictions = restrictions;
        this.health_conds = health_conds;
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

//    public Integer getCond_id() {
//        return cond_id;
//    }
//
//    public void setCond_id(Integer cond_id) {
//        this.cond_id = cond_id;
//    }

    public String getHealth_conds() {
        return health_conds;
    }

    public void setHealth_conds(String health_conds) {
        this.health_conds = health_conds;
    }

    @Override
    public String toString() {
        return "DietaryRestrictionsSearch{" +
                "restrictions='" + restrictions + '\'' +
                ", health_conds='" + health_conds + '\'' +
                '}';
    }
//    @Override
//    public String toString() {
//        return "DietaryRestrictionsSearch{" +
//                "restrictions='" + restrictions + '\'' +
//                '}';
//    }

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

// LisaFix13 push 05/29/2020


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

    @Column
    private String health_conds;

    @Column
    private String ingred_search;

    @Column
    private String cook_time;

    public List<UserPreference> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<UserPreference> preferences) {
        this.preferences = preferences;
    }

    @ManyToMany(mappedBy = "dietaryrestrictionssearches")
    private List<UserPreference> preferences = new ArrayList<>();

    public DietaryRestrictionsSearch() {}

    public DietaryRestrictionsSearch(Integer restrict_id, String restrictions, String health_conds,
                                     String ingred_search, List<UserPreference> preferences, String cook_time) {
        this.restrict_id = restrict_id;
        this.restrictions = restrictions;
        this.health_conds = health_conds;
        this.ingred_search = ingred_search;
        this.preferences = preferences;
        this.cook_time = cook_time;
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

    public String getHealth_conds() {
        return health_conds;
    }

    public void setHealth_conds(String health_conds) {
        this.health_conds = health_conds;
    }

    public String getIngred_search() {
        return ingred_search;
    }

    public void setIngred_search(String ingred_search) {
        this.ingred_search = ingred_search;
    }

    public String getCook_time() {
        return cook_time;
    }

    public void setCook_time(String cook_time) {
        this.cook_time = cook_time;
    }

    @Override
    public String toString() {
        return "DietaryRestrictionsSearch{" +
                "restrict_id=" + restrict_id +
                ", restrictions='" + restrictions + '\'' +
                ", health_conds='" + health_conds + '\'' +
                ", ingred_search='" + ingred_search + '\'' +
                ", cook_time='" + cook_time + '\'' +
                ", preferences=" + preferences +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DietaryRestrictionsSearch)) return false;
        DietaryRestrictionsSearch that = (DietaryRestrictionsSearch) o;
        return Objects.equals(getRestrict_id(), that.getRestrict_id()) &&
                Objects.equals(getRestrictions(), that.getRestrictions()) &&
                Objects.equals(getHealth_conds(), that.getHealth_conds()) &&
                Objects.equals(getIngred_search(), that.getIngred_search()) &&
                Objects.equals(getCook_time(), that.getCook_time()) &&
                Objects.equals(getPreferences(), that.getPreferences());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRestrict_id(), getRestrictions(), getHealth_conds(),
                getIngred_search(), getCook_time(), getPreferences());
    }
}
package org.launchcode.health_recipe.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserPreference {

    @Id
    private Integer usersId;

    @ManyToMany
    @JoinTable
    private List<DietaryRestrictionsSearch> dietaryrestrictionssearches = new ArrayList<>();

    public UserPreference() {
    }

    public UserPreference(Integer usersId, List<DietaryRestrictionsSearch> dietaryrestrictionssearches) {
        this.usersId = usersId;
        this.dietaryrestrictionssearches = dietaryrestrictionssearches;
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public List<DietaryRestrictionsSearch> getDietaryrestrictionssearches() {
        return dietaryrestrictionssearches;
    }

    public void setDietaryrestrictionssearches(List<DietaryRestrictionsSearch> dietaryrestrictionssearches) {
        this.dietaryrestrictionssearches = dietaryrestrictionssearches;
    }
}


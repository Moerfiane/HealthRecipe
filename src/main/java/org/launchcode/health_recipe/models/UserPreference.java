package org.launchcode.health_recipe.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserPreference {

    @Id
    private Integer usersId;

    private Integer preferenceId;

    public UserPreference() {}

    public UserPreference(Integer usersId, Integer preferenceId) {
        this.usersId = usersId;
        this.preferenceId = preferenceId;
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public Integer getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(Integer preferenceId) {
        this.preferenceId = preferenceId;
    }
}

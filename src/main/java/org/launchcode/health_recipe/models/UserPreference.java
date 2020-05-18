package org.launchcode.health_recipe.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserPreference {

    @Id
    private int usersId;

    private int preferenceId;

    public UserPreference(int usersId, int preferenceId) {
        this.usersId = usersId;
        this.preferenceId = preferenceId;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public int getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(int preferenceId) {
        this.preferenceId = preferenceId;
    }
}

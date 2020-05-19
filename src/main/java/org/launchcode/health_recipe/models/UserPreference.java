package org.launchcode.health_recipe.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserPreference {

    @Id
    private int usersId;

    private int preferenceId;

    @ManyToOne
    private User user;

    public UserPreference() {
    }

    public UserPreference(User user, int usersId, int preferenceId) {
        this.usersId = usersId;
        this.preferenceId = preferenceId;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public void save(UserPreference newUserPreference) {
    }
}

package org.launchcode.health_recipe.models.data;

import org.launchcode.health_recipe.models.UserPreference;
import org.springframework.data.repository.CrudRepository;

public interface UserPreferenceRepository extends CrudRepository<UserPreference, Integer[]>{


//    void save();
    private void userPreferenceRepository(Integer[] preferenceId) {
    }
}

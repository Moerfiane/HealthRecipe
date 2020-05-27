package org.launchcode.health_recipe.models.data;

import org.launchcode.health_recipe.models.UserPreference;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface UserPreferenceRepository extends CrudRepository<UserPreference, Integer[]>{



}

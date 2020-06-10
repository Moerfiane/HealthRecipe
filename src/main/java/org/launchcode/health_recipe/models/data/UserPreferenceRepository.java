package org.launchcode.health_recipe.models.data;

import org.launchcode.health_recipe.models.UserPreference;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Repository
@Transactional
public interface UserPreferenceRepository extends CrudRepository<UserPreference, Integer[]>{


}

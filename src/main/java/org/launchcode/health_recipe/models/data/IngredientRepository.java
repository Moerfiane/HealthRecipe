package org.launchcode.health_recipe.models.data;

import org.launchcode.health_recipe.models.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {


}

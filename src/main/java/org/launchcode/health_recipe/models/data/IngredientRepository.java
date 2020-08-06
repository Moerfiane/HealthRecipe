package org.launchcode.health_recipe.models.data;

import org.launchcode.health_recipe.models.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

    List<Ingredient> findById(Ingredient newIngredient);
}

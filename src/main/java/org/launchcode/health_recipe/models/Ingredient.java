package org.launchcode.health_recipe.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Ingredient extends AbstractEntity {

    @Size(min=3, message="Ingredient must be at least 3 characters long")
    private String ingredient;

    public Ingredient(@Size(min = 3, message = "Ingredient must be at least 3 characters long") String ingredient) {
        this.ingredient = ingredient;
    }

    @OneToMany
   @JoinColumn(name = "ingredient_id")
   private final List<Recipe> recipes = new ArrayList<>();


    public Ingredient() {}

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

}

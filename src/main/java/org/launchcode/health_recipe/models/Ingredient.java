package org.launchcode.health_recipe.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Ingredient extends AbstractEntity {

    @NotBlank(message = "Please provide Recipe ingredient.")
    @Size(min = 3,max = 150, message = "Ingredient must be only 3-150 characters.  Please try again.")
    public String ingredient;

    public Ingredient(String ingredient){
        super();
        this.ingredient = ingredient;
    }

    public Ingredient() {}

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
}

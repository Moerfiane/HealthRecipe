package org.launchcode.health_recipe.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public class Ingredient extends AbstractEntity{

    @NotEmpty(message = "Please add an ingredient")
    private String ingredient;

    public Ingredient() {}

    public Ingredient(String ingredient) {
        super();
        this.ingredient = ingredient;

    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public String toString() {
        return ingredient;
    }
}

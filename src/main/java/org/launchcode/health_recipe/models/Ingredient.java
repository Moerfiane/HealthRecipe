package org.launchcode.health_recipe.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Ingredient extends AbstractEntity {

    @NotBlank(message = "Please provide Recipe ingredient.")
    @Size(min = 3,max = 150, message = "Ingredient must be only 3-150 characters.  Please try again.")
    public String ingredient;

//    @ManyToOne
    @JoinColumn
    private String recipe_name;

    public Ingredient(String recipe, String ingredient){
        super();
        this.ingredient = ingredient;
        this.recipe_name = recipe;
    }

    public Ingredient() {}

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getRecipe() {
        return recipe_name;
    }

    public void setRecipe(String recipe) {
        this.recipe_name = recipe;
    }
}

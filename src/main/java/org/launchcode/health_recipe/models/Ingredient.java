package org.launchcode.health_recipe.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Ingredient extends AbstractEntity {


    @ManyToOne
    @JoinColumn(name = "recipeName", referencedColumnName = "recipeName")
    private Recipe recipe;

    @NotBlank(message = "Please provide Recipe ingredient.")
    @Size(min = 3,max = 255, message = "Ingredient must be only 3-255 characters.  Please try again.")
    private String ingredient;


    public Ingredient() {}

    public Ingredient(Recipe recipe, String ingredient){
        super();
        this.recipe = recipe;
        this.ingredient = ingredient;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
}

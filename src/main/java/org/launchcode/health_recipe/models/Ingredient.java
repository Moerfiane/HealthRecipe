package org.launchcode.health_recipe.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Ingredient extends AbstractEntity {

    @NotBlank(message = "Please provide Recipe ingredient.")
    @Size(min = 3,max = 150, message = "Ingredient must be only 3-150 characters.  Please try again.")
//    @JoinColumn(name = "ingredients")
    public String ingredient;

//    @ManyToOne
//    @JoinColumn(/*name="recipe_name",*/ nullable=false)
//    protected Recipe recipe;


    public Ingredient(String ingredient){
        this.ingredient = ingredient;
    }

    public Ingredient() {}

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }





//    @ManyToOne(optional = false)
//    private Recipe recipes;
//
//    public Recipe getRecipes() {
//        return recipes;
//    }
//
//    public void setRecipes(Recipe recipes) {
//        this.recipes = recipes;
//    }
}

// LisaFix13 push 05/29/2020

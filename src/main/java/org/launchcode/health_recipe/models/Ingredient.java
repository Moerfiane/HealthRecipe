package org.launchcode.health_recipe.models;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Ingredient extends AbstractEntity {


//    @ManyToOne
//    @JoinColumn(name = "recipeName", referencedColumnName = "recipeName")
//    private Recipe recipe;

//    Instantiating the above Class inside a Class, created the table "recipe_ingredients."

    @NaturalId
    @Column(unique=true)
    @NotBlank(message = "Please provide Recipe name.")
    @Size(min = 3,max = 255, message = "Recipe must be only 3-255 characters.  Please try again.")
    private String recipe_name;

    @NotBlank(message = "Please provide Recipe ingredient.")
    @Size(min = 3,max = 255, message = "Ingredient must be only 3-255 characters.  Please try again.")
    private String ingredient;

    public Ingredient() {}

    public Ingredient(String recipe, String ingredient){
        super();
        this.recipe_name = recipe;
        this.ingredient = ingredient;
    }

    public String getRecipe_name() {
        return recipe_name;
    }

    public void setRecipe_name(String recipe_name) {
        this.recipe_name = recipe_name;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
}

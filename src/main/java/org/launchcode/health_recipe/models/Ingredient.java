package org.launchcode.health_recipe.models;

import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class Ingredient extends AbstractEntity {

    @ManyToMany(mappedBy = "ingredients")
//    @JoinColumn(name = "recipeName", referencedColumnName = "recipeName")
    private List<Recipe> recipe = new ArrayList<>();

    private String recipeName;

    @NotBlank(message = "Please provide Recipe ingredient.")
    @Size(min = 3,max = 15500, message = "Ingredient must be max 15500.  Please try again.")
    private String ingredient;


    public Ingredient() {}

    public Ingredient(List<Recipe> recipe, String recipeName, String ingredient) {
        super();
        this.recipe = recipe;
        this.recipeName = recipeName;
        this.ingredient = ingredient;
    }


    public List<Recipe> getRecipe() {
        return recipe;
    }

    public void setRecipe(List<Recipe> recipe) {
        this.recipe = recipe;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
}
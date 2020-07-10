package org.launchcode.health_recipe.models;

import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Ingredient extends AbstractEntity {


    @ManyToMany(mappedBy = "ingredient")
//    @JoinColumn(name = "recipeName", referencedColumnName = "recipeName")
    private List<Recipe> recipe = new ArrayList<>();


    private String recipeName;

    @NotNull(message = "Please provide Recipe ingredient.")
    @Column(length=15500)
    private String ingredient;


    public Ingredient() {}

    public Ingredient(List<Recipe> recipe, String ingredient) {
        super();
        this.recipe = recipe;
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
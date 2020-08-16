package org.launchcode.health_recipe.models;

import org.springframework.stereotype.Component;
import org.w3c.dom.Text;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity(name = "Ingredient")
@Table(name = "ingredient")
public class Ingredient extends AbstractEntity {


    @OneToMany(mappedBy = "ingredient",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Recipe> recipes = new ArrayList<>();

    @NotNull(message = "Please provide Recipe ingredient.")
    @Size(min = 3,max = 16000, message = "Ingredient must be max 30000.  Please try again.")
    @Column(name = "recipe_ingredients")
    private String recipeIngredients;

    public Ingredient(List<Recipe> recipes, String recipeIngredients) {
        this.recipes = recipes;
        this.recipeIngredients = recipeIngredients;
    }

    public Ingredient() {}

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public String getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(String recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;
        if (!super.equals(o)) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(getRecipes(), that.getRecipes()) &&
                Objects.equals(recipeIngredients, that.recipeIngredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getRecipes(), recipeIngredients);
    }
}
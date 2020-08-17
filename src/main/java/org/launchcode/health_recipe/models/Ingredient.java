package org.launchcode.health_recipe.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity(name = "Ingredient")
@Table(name = "ingredient")
public class Ingredient extends AbstractEntity {

    @NotNull
    @Size(max = 75)
    private String recipeIngredients;

    @OneToMany(
        mappedBy = "ingredient",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Recipe> recipes = new ArrayList<>();

    public Ingredient(@NotNull @Size(max = 75) String recipeIngredients, List<Recipe> recipes) {
        this.recipeIngredients = recipeIngredients;
        this.recipes = recipes;
    }
    public Ingredient() {}

    public String getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(String recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;
        if (!super.equals(o)) return false;
        Ingredient that = (Ingredient) o;
        return getRecipeIngredients().equals(that.getRecipeIngredients());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getRecipeIngredients());
    }
}

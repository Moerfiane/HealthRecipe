package org.launchcode.health_recipe.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "Ingredient")
@Table(name = "ingredient")
public class Ingredient extends AbstractEntity {

    @NotNull
    @Size(max = 75)
    private String ingredientName;

    @OneToMany(
        mappedBy = "ingredient",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Recipe> recipes = new ArrayList<>();

    public Ingredient(@NotNull @Size(max = 75) String ingredientName, List<Recipe> recipes) {
        this.ingredientName = ingredientName;
        this.recipes = recipes;
    }
    public Ingredient() {}

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}

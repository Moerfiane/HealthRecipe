package org.launchcode.health_recipe.models;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity(name = "Recipe")
@Table(name = "recipe")
public class Recipe extends AbstractEntity {

    @NotNull(message = "Enter a name for the recipe.")
    private String recipeName;

    @NotNull(message = "Servings?")
    private String servings;

    @NotNull(message = "Serve time?")
    private String serve_time;

    @NotNull(message = "Recipe steps?")
    @Column(length = 15500)
    private String steps;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    public Recipe(@NotNull(message = "Enter a name for the recipe.") String recipeName, @NotNull(message = "Servings?") String servings, @NotNull(message = "Serve time?") String serve_time, @NotNull(message = "Recipe steps?") String steps, Ingredient ingredient) {
        this.recipeName = recipeName;
        this.servings = servings;
        this.serve_time = serve_time;
        this.steps = steps;
        this.ingredient = ingredient;
    }

    public Recipe() {}

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getServings() {
        return servings;
    }

    public void setServings(String servings) {
        this.servings = servings;
    }

    public String getServe_time() {
        return serve_time;
    }

    public void setServe_time(String serve_time) {
        this.serve_time = serve_time;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

}

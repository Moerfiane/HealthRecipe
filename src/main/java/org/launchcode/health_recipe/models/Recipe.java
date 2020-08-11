package org.launchcode.health_recipe.models;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity(name = "Recipe")
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue
    private int id;

    @NotNull(message = "Enter a name for the recipe.")
    private String recipeName;

    @NotNull(message = "Servings?")
    private String servings;

    @NotNull(message = "Serve time?")
    private String serve_time;

    @NotNull(message = "Recipe steps?")
    @Column(length = 15500)
    private String steps;

    @OneToMany(
            mappedBy = "recipe",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Ingredient> ingredients = new ArrayList<>();

    public Recipe(int id, @NotNull(message = "Enter a name for the recipe.") String recipeName, @NotNull(message = "Servings?") String servings, @NotNull(message = "Serve time?") String serve_time, @NotNull(message = "Recipe steps?") String steps, List<Ingredient> ingredients) {
        this.id = id;
        this.recipeName = recipeName;
        this.servings = servings;
        this.serve_time = serve_time;
        this.steps = steps;
        this.ingredients = ingredients;
    }

    public Recipe() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
        ingredient.setRecipe(this);
    }

    public void removeIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
        ingredient.setRecipe(null);
    }
}

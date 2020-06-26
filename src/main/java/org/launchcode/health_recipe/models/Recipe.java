package org.launchcode.health_recipe.models;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Entity
@Table(name = "recipe")
public class Recipe extends AbstractEntity{

    @JoinColumn
    @NotBlank(message = "Recipe name?")
    private String recipe_name;

    @NotBlank(message = "Servings?")
    private String servings;

    @NotBlank (message = "Serve time?")
    private String serve_time;

    @NotBlank (message = "Recipe steps?")
    @Column(length=15500)
    private String steps;

    private Set<Ingredient> ingredients = new HashSet<>(0);

    public Recipe() {}

    public Recipe(String name, String servings, String timeToServe, String stepsToRecipe, Set<Ingredient> ingredientSet) {
        super();
        this.recipe_name = name;
        this.servings = servings;
        this.serve_time = timeToServe;
        this.steps = stepsToRecipe;
        this.ingredients = ingredientSet;
    }

//    @OneToMany(mappedBy = "recipe")
//    private final List<Ingredient> ingredients = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(joinColumns = { @JoinColumn(name = "recipe_name") }, inverseJoinColumns = { @JoinColumn(name = "ingredient") })
    public Set<Ingredient> getIngredients() {
        return this.ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredientSet) {
        this.ingredients = ingredientSet;
    }

    public String getRecipe_name() {
        return recipe_name;
    }

    public void setRecipe_name(String recipe_name) {
        this.recipe_name = recipe_name;
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
}

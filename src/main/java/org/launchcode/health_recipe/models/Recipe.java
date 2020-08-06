package org.launchcode.health_recipe.models;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
public class Recipe extends AbstractEntity {

    @NotNull(message = "Enter a name for the recipe.")
    private String recipeName;

    @NotNull (message = "Servings?")
    private String servings;

    @NotNull (message = "Serve time?")
    private String serve_time;

    @NotNull (message = "Recipe steps?")
    @Column(length=15500)
    private String steps;

    @ManyToOne
    private Ingredient ingredient;

    public Recipe() {}

    public Recipe(Ingredient ingredient, String recipeName, String servings, String timeToServe, String stepsToRecipe) {
        this.recipeName = recipeName;
        this.servings = servings;
        this.serve_time = timeToServe;
        this.steps = stepsToRecipe;
        this.ingredient = ingredient;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
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


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Recipe)) return false;
//        if (!super.equals(o)) return false;
//        Recipe recipe = (Recipe) o;
//        return Objects.equals(getRecipeName(), recipe.getRecipeName()) &&
//                Objects.equals(getServings(), recipe.getServings()) &&
//                Objects.equals(getServe_time(), recipe.getServe_time()) &&
//                Objects.equals(getSteps(), recipe.getSteps()) &&
//                Objects.equals(getIngredient(), recipe.getIngredient());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(super.hashCode(), getRecipeName(), getServings(), getServe_time(), getSteps(), getIngredient());
//    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//        Recipe recipe = (Recipe) o;
//        return recipeName.equals(recipe.recipeName);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(super.hashCode(), recipeName);
//    }

}

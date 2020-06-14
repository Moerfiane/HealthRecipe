package org.launchcode.health_recipe.models;

import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Recipe extends AbstractEntity {

    @NotNull(message = "Please give recipe a name.")
    @NaturalId
    private String recipeName;

    @NotNull (message = "Servings?")
    private String servings;

    @NotNull (message = "Serve time?")
    private String serve_time;

    @NotNull (message = "Recipe steps?")
    @Column(length=15500)
    private String steps;

    public Recipe() {}

    public Recipe(String recipeName, String servings, String timeToServe, String stepsToRecipe) {
        super();
        this.recipeName = recipeName;
        this.servings = servings;
        this.serve_time = timeToServe;
        this.steps = stepsToRecipe;
    }

    @OneToMany(mappedBy = "recipe")
    private Collection<Ingredient> ingredient;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Recipe recipe = (Recipe) o;
        return recipeName.equals(recipe.recipeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), recipeName);
    }

    public Collection<Ingredient> getIngredient() {
        return ingredient;
    }

    public void setIngredient(Collection<Ingredient> ingredient) {
        this.ingredient = ingredient;
    }
}

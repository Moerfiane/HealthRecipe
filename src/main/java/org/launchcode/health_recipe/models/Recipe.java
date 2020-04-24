package org.launchcode.health_recipe.models;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
public class Recipe extends AbstractEntity{

//    @Id
//    @GeneratedValue
//    private int id;
//
//    @NotNull
//    @Size(max = 150)
////    @OneToMany(mappedBy ="name")
//    private String name;

    @OneToMany(/*mappedBy = "recipes"*/)
    @JoinColumn(name = "ingredient")
    private Set<Ingredient> ingredients;

//    @OneToMany(orphanRemoval=true)
//    @JoinColumn(name="ingredient") // join column is in table for Ingredient
//    public Set<Ingredient> getIngredient() {return ingredient;}

    @NotNull (message = "Servings?")
    private String servings;

    @NotNull (message = "Serve time?")
    private String serve_time;

    @NotNull (message = "Recipe steps?")
    @Column(length=15500)
    private String steps;

    public Recipe() {}

    public Recipe(/*int id, String name, */String servings, String timeToServe, String stepsToRecipe) {
        super();
        this.servings = servings;
        this.serve_time = timeToServe;
        this.steps = stepsToRecipe;
    }

//    public String getName() { return name; }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getId() { return id; }

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
        return Objects.equals(ingredients, recipe.ingredients) &&
                Objects.equals(servings, recipe.servings) &&
                Objects.equals(serve_time, recipe.serve_time) &&
                Objects.equals(steps, recipe.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ingredients, servings, serve_time, steps);
    }
}

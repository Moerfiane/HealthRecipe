package org.launchcode.health_recipe.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe extends AbstractEntity{


    @NotBlank(message = "Servings?")
    private String servings;

    @NotBlank (message = "Serve time?")
    private String serve_time;

    @NotBlank (message = "Recipe steps?")
    @Column(length=15500)
    private String steps;

    public Recipe() {}

    public Recipe(String servings, String timeToServe, String stepsToRecipe) {
        super();
        this.servings = servings;
        this.serve_time = timeToServe;
        this.steps = stepsToRecipe;
    }

    @OneToMany(mappedBy = "recipe")
    private final List<Ingredient> ingredients = new ArrayList<>();


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

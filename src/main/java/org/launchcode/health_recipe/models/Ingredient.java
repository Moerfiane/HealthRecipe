package org.launchcode.health_recipe.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ingredient extends AbstractEntity {

    @NotBlank(message = "Please provide Recipe ingredient.")
    @Size(min = 3,max = 150, message = "Ingredient must be only 3-150 characters.  Please try again.")
    public String ingredient;

    @OneToMany
    @JoinColumn(name = "ingredient_id")
    private final List<Recipe> recipes = new ArrayList<>();

    public Ingredient(String ingredient){
        this.ingredient = ingredient;
    }

    public Ingredient() {}

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

}

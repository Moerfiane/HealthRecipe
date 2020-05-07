package org.launchcode.health_recipe.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ingredient extends AbstractEntity {

    @NotBlank(message = "Please provide Recipe ingredient.")
    @Size(min = 3,max = 255, message = "Ingredient must be only 3-255 characters.  Please try again.")
    private String ingredient;

    @ManyToOne
    private Recipe recipe;

//    @ManyToOne(/*mappedBy = "recipe"*/)
////    @JoinColumn
//    public String name = this.getName();

    public Ingredient() {}

    public Ingredient(Recipe aRecipe, String anIngredient){
        super();
        this.recipe = aRecipe;
        this.ingredient = anIngredient;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
}

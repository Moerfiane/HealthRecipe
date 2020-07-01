package org.launchcode.health_recipe.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Ingredient extends AbstractEntity {

    @NotBlank(message = "Please provide Recipe ingredient.")
    @Size(min = 3, max = 255, message = "Ingredient must be only 3-255 characters.  Please try again.")
    protected String ingredient;

    @JoinColumn
    @NotBlank(message = "Please provide a Recipe Name.")
    @Size(min = 3,max = 255, message = "Recipe Name must be only 3-255 characters.  Please try again.")
    private String recipe;
//            Changed Recipe instance with simple String. Chasing down Whitelabel 500.
//            Notice Recipe replaced with String in constructor. Getter and Setter for
//            recipe_name added.

//    @ManyToOne
//    private Recipe recipe;

//    @ManyToOne(/*mappedBy = "recipe"*/)
////    @JoinColumn
//    public String name = this.getName();

    public Ingredient() {}

    public Ingredient(String aRecipe, String anIngredient){
        super();
        this.recipe = aRecipe;
        this.ingredient = anIngredient;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
}

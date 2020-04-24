package org.launchcode.health_recipe.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Ingredient extends AbstractEntity{

//    @Id
//    @GeneratedValue
//    private int id;
//
//    @NotNull
//    @Size(max = 150)
////    @ManyToOne()
//    private String name;

    @NotBlank(message = "Please provide Recipe ingredient.")
    @Size(min = 3,max = 150, message = "Ingredient must be only 3-150 characters.  Please try again.")
    @JoinColumn(name = "ingredients")
    public String ingredient;

//    @ManyToOne
//    @JoinColumn(/*name="recipe_name",*/ nullable=false)
//    protected Recipe recipe;

//    @Override
//    public String toString() {
//        return name;
//    }

    public Ingredient(/*int id, String name, */String ingredient){

        super();
        this.ingredient = ingredient;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public Ingredient() {}

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(ingredient, that.ingredient) &&
                Objects.equals(recipes, that.recipes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ingredient, recipes);
    }

    @ManyToOne(optional = false)
    private Recipe recipes;

    public Recipe getRecipes() {
        return recipes;
    }

    public void setRecipes(Recipe recipes) {
        this.recipes = recipes;
    }
}

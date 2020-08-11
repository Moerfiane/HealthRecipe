package org.launchcode.health_recipe.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity(name = "Ingredient")
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(max = 75)
    private String ingredient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public Ingredient(Long id, @NotNull @Size(max = 75) String ingredient, Recipe recipe) {
        this.id = id;
        this.ingredient = ingredient;
        this.recipe = recipe;
    }

    public Ingredient() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Ingredient )) return false;
        return id != null && id.equals(((Ingredient) obj).getId());
    }
    @Override
    public int hashCode() {
        return 31;
    }
}

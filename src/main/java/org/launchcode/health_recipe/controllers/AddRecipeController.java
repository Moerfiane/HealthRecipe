package org.launchcode.health_recipe.controllers;


import org.launchcode.health_recipe.models.DietaryRestrictionsSearch;
import org.launchcode.health_recipe.models.Ingredient;
import org.launchcode.health_recipe.models.Recipe;
import org.launchcode.health_recipe.models.data.IngredientRepository;
import org.launchcode.health_recipe.models.data.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class AddRecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping("add")
    public String displayAddRecipeForm(Model model) {
        model.addAttribute("title", "Add Recipe");
        model.addAttribute(new Recipe());
        model.addAttribute("title", "Add Ingredient");
        model.addAttribute(new Ingredient());

        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddRecipeForm(@Valid @ModelAttribute Recipe newRecipe,
                                       @ModelAttribute @Valid Ingredient newIngredient,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Recipe");
            model.addAttribute("title", "Add Ingredient");
            return "add";
        }


        newRecipe.setIngredient(newIngredient);

        ingredientRepository.save(newIngredient);
        recipeRepository.save(newRecipe);

            return "list";
        }
    }
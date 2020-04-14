package org.launchcode.health_recipe.controllers;


import org.launchcode.health_recipe.models.Ingredient;
import org.launchcode.health_recipe.models.Recipe;
import org.launchcode.health_recipe.models.data.IngredientRepository;
import org.launchcode.health_recipe.models.data.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddRecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping("add")
    public String displayAddRedipeForm(Model model) {
        model.addAttribute("title", "Add Recipe");
        model.addAttribute("recipe", recipeRepository.findAll());
        model.addAttribute("ingredient", ingredientRepository.findAll());
        model.addAttribute(new Recipe());
        model.addAttribute(new Ingredient());
        return "add";
    }

    @PostMapping("add")
    public String processAddRecipeForm(@ModelAttribute Recipe newRecipe,
                                       Errors errors, Model model){

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Recipe");
            return "add";
        }

        recipeRepository.save(newRecipe);
        return "redirect:";
    }
}
package org.launchcode.health_recipe.controllers;


import org.launchcode.health_recipe.models.Recipe;
import org.launchcode.health_recipe.models.data.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping
public class AddRecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

//    @Autowired
//    private IngredientRepository ingredientRepository;

    @GetMapping("add")
    public String displayAddRecipeForm(Model model) {
        model.addAttribute("title", "Add Recipe");
//        model.addAttribute("recipe", recipeRepository.findAll());
//        model.addAttribute("ingredient", ingredientRepository.findAll());
        model.addAttribute(new Recipe());
//        model.addAttribute(new Ingredient());
        return "add";
    }

    @PostMapping("add")
    public String processAddRecipeForm(@ModelAttribute @Valid Recipe newRecipe,
//                                       @ModelAttribute @Valid Ingredient newIngredient,
                                       Errors errors, Model model){

        if (errors.hasErrors()) {
//            model.addAttribute("title", "Add Recipe");
            return "add";
        }

        recipeRepository.save(newRecipe);
//        ingredientRepository.save(newIngredient);
//        return "redirect:";
        return "ingredient/add";
    }

}
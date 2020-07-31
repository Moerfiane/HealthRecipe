package org.launchcode.health_recipe.controllers;


import org.launchcode.health_recipe.models.Ingredient;
import org.launchcode.health_recipe.models.Recipe;
import org.launchcode.health_recipe.models.data.IngredientRepository;
import org.launchcode.health_recipe.models.data.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        return "add";
    }

//    @PostMapping("add")
//    public String processAddRecipeForm(@ModelAttribute @Valid Recipe newRecipe,
//                                       Errors errors, Model model){
//
//        if (errors.hasErrors()) {
////            model.addAttribute("title", "Add Recipe");
//            return "add";
//        }
//
//        recipeRepository.save(newRecipe);
//        return "redirect:./ingredient/add";
//    }

    @RequestMapping(value="/add",method= RequestMethod.POST,params="ingredientId")
//    @PostMapping("add")
    public String processAddRecipeForm(@ModelAttribute @Valid Recipe newRecipe,
                                       @RequestParam Integer ingredientId,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Recipe");
            return "add";
        }

        if (ingredientId != null) {
            Optional<Ingredient> ing = ingredientRepository.findById(ingredientId);
            if (ing.isPresent()) {
                Ingredient ingredient = ing.get();
                newRecipe.setIngredient(ingredient);

            }

            recipeRepository.save(newRecipe);
            return "redirect:/view/" + newRecipe.getId();
        }
        return "redirect:../add";
    }
}
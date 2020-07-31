package org.launchcode.health_recipe.controllers;


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

    public AddRecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }



    @GetMapping("add")
    public String displayAddRecipeForm(Model model) {
        model.addAttribute("title", "Add Recipe");
        model.addAttribute("recipe", new Recipe());
        model.addAttribute("title", "Add Ingredient");
        model.addAttribute("ingredient", new Ingredient());
        return "add";
    }

    @RequestMapping(value="/add",method=RequestMethod.POST)
    public String processAddRecipeForm(@Valid @ModelAttribute Recipe newRecipe,
                                        @Valid @ModelAttribute("Add Ingredient") Ingredient newIngredient,
                                        Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Recipe");
            model.addAttribute("title", "Add Ingredient");

            return "add";
        }

            recipeRepository.save(newRecipe);

            ingredientRepository.save(newIngredient);
              return "redirect:/add";
    }

//    @RequestMapping(value="/add",method=RequestMethod.POST)
//    public String processAddRecipeIngredientIDs(@ModelAttribute @Valid Recipe newRecipe,
//                                                @ModelAttribute(value = "Add Ingredient") @Valid Ingredient newIngredient,
//                                                @RequestParam(required = false) List<Integer> ingredients,
//                                                Errors errors, Model model) {
//
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Add Recipe");
//            model.addAttribute("title", "Add Ingredient");
//            return "add";
//        }
//            recipeRepository.save(newRecipe);
//            ingredientRepository.save(newIngredient);
//
////        if (ingredientId != null) {
////            Optional<Ingredient> ing = ingredientRepository.findById(ingredientId);
////            if (ing.isPresent()) {
////                Ingredient ingredient = ing.get();
////                newRecipe.setIngredients(ingredient);
////
////            }
//            List<Ingredient> ingObjs = (List<Ingredient>) ingredientRepository.findAllById(ingredients);
////            if (!ingObjs.isEmpty()) {
//                newRecipe.setIngredients(ingObjs);
////            }
//            recipeRepository.save(newRecipe);
//            return "redirect:/view/" + newRecipe.getId();
//        }

}
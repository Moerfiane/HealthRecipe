package org.launchcode.health_recipe.controllers;

import org.launchcode.health_recipe.models.Ingredient;
import org.launchcode.health_recipe.models.Recipe;
import org.launchcode.health_recipe.models.RecipeData;
import org.launchcode.health_recipe.models.data.IngredientRepository;
import org.launchcode.health_recipe.models.data.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@Controller
public class RecipeController {

    @Autowired
    RecipeData recipeData;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public RecipeController() {

        columnChoices.put("all", "All");
    }

    @RequestMapping("/list")
    public String list(Model model, Pageable page) {
        Page<Recipe> recipes;
        model.addAttribute("recipes", recipeData.findAllByPage(page));
        return "list";
    }

    @RequestMapping(value = "recipes")
    public String listRecipeByChoice(Model model, @RequestParam String column,
                                     @RequestParam ArrayList<String> value) {
        Iterable<Recipe> recipes;
        if (column.toLowerCase().equals("all")){
            recipes = recipeRepository.findAll();
            model.addAttribute("title", "All Recipes");
        } else {
            recipes = RecipeData.findByColumnAndValue(column, value, recipeRepository.findAll());
            model.addAttribute("title", "Recipe Choice");
        }
        model.addAttribute("recipes", recipes);

        return "list-recipes";
    }
//
//    @GetMapping("add")
//    public String displayAddRecipeForm(Model model) {
//        model.addAttribute("title", "Add Recipe");
//        model.addAttribute(new Recipe());
//        return "add";
//    }
//


    @GetMapping("view/{recipeId}")
    public String displayViewRecipe(Model model, @PathVariable int recipeId) {

        Optional optRecipe = recipeRepository.findById(recipeId);
        if (optRecipe.isPresent()) {
            Recipe recipe = (Recipe) optRecipe.get();
            model.addAttribute("recipes", recipe);
            return "view";
        } else {
            return "redirect:../";
        }
    }
}



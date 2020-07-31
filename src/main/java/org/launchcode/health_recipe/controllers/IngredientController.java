package org.launchcode.health_recipe.controllers;

import org.launchcode.health_recipe.models.DietaryRestrictionsSearch;
import org.launchcode.health_recipe.models.Ingredient;
import org.launchcode.health_recipe.models.Recipe;
import org.launchcode.health_recipe.models.data.IngredientRepository;
import org.launchcode.health_recipe.models.data.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/ingredient")
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    private Ingredient ingredient;

    @GetMapping("/")
    public String displayAllIngredients(Model model) {
        model.addAttribute("title", "All Ingredients");
        model.addAttribute("ingredient", ingredientRepository.findAll());
        return "ingredient/index";
    }

    @GetMapping("add")
    public String displayAddIngredientForm(Model model) {

        model.addAttribute("title", "Add Ingredient");
        model.addAttribute(new Ingredient());
        return "ingredient/add";

    }

    @RequestMapping(value="/ingredient/add",method=RequestMethod.POST)
    public String processAddIngredientForm(@ModelAttribute(value = "Add Ingredient") @Valid Ingredient newIngredient,
                                           Errors errors, Model model) {

        if (errors.hasErrors()) {
            errors.rejectValue("ingredient", "ingredient.invalid", "Ingredient is required");
            return "ingredient/add";
        }

        ingredientRepository.save(newIngredient);

        return "redirect:./add";
    }

    @GetMapping("view/{ingredientId}")
    public String displayViewIngredient(Model model, @PathVariable int ingredientId) {

        Optional optIngredient = ingredientRepository.findById(ingredientId);
        if (optIngredient.isPresent()) {
            Ingredient ingredient = (Ingredient) optIngredient.get();
            model.addAttribute("ingredients", ingredient);
            return "ingredient/view";
        } else {
            return "redirect:../";
        }
    }
}
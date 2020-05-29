package org.launchcode.health_recipe.controllers;

import org.launchcode.health_recipe.models.Ingredient;
import org.launchcode.health_recipe.models.data.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "/ingredient")
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    private Ingredient ingredient;

    @GetMapping
    public String displayAllIngredients(Model model) {
        model.addAttribute("title", "All Ingredients");
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "ingredient/index";
    }

    @GetMapping("add")
    public String displayAddIngredientForm(Model model) {
        model.addAttribute("title", "Add Ingredient");
        model.addAttribute(new Ingredient());
        return "ingredient/add";

    }

    @PostMapping("add")
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
            model.addAttribute("ingredient", ingredient);
            return "ingredients/view";
        } else {
            return "redirect:../";
        }
    }
}

// LisaFix13 push 05/29/2020
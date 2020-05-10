package org.launchcode.health_recipe.controllers;

import org.launchcode.health_recipe.models.Ingredient;
import org.launchcode.health_recipe.models.IngredientData;
import org.launchcode.health_recipe.models.data.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@Controller
@RequestMapping("ingredients")
public class IngredientController {

    @Autowired
    IngredientData ingredientData;

    @Autowired
    private IngredientRepository ingredientRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public IngredientController() {

        columnChoices.put("all", "All");
    }

//    @RequestMapping("/list")
//    public String list(Model model, Pageable page) {
//        Page<Ingredient> ingredients;
//        model.addAttribute("ingredients", ingredientData.findAllByPage(page));
//        return "list";
//    }

    @RequestMapping(value = "ingredients")
    public String listIngredientByChoice(Model model, @RequestParam String column,
                                     @RequestParam ArrayList<String> value) {
        Iterable<Ingredient> ingredients;
        if (column.toLowerCase().equals("all")){
            ingredients = ingredientRepository.findAll();
            model.addAttribute("title", "All Ingredients");
        } else {
            ingredients = IngredientData.findByColumnAndValue(column, value, ingredientRepository.findAll());
            model.addAttribute("title", "Ingredient Choice");
        }
        model.addAttribute("ingredients", ingredients);

        return "list-ingredients";
    }
//    @GetMapping("add")
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public String displayAddIngredientForm(Model model) {
        model.addAttribute("title", "Add Ingredient");
        model.addAttribute(new Ingredient());
        return "ingredients/add";
    }

//    @PostMapping("add")
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String processAddIngredientForm(@ModelAttribute(value = "Add Ingredient") @Valid Ingredient newIngredient,
                                       Errors errors, Model model){

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Ingredient");
            model.addAttribute(new Ingredient());
            errors.rejectValue("ingredient", "ingredient.invalid", "Ingredient is required");
            return "ingredients/add";
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
            return "view";
        } else {
            return "redirect:../";
        }
    }
}



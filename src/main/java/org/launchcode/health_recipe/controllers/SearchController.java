package org.launchcode.health_recipe.controllers;

import org.launchcode.health_recipe.models.Recipe;
import org.launchcode.health_recipe.models.RecipeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.launchcode.health_recipe.models.data.RecipeRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static org.launchcode.health_recipe.controllers.RecipeController.columnChoices;

@Controller
@RequestMapping(value = "search")
public class SearchController {

    @Autowired
    private RecipeRepository recipeRepository;

    @RequestMapping("")
    public String search(Model model) {
//        model.addAttribute("columns", columnChoices);
        return "search";
    }

//    @PostMapping("results")
//    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
//        Iterable<Recipe> recipes;
//        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
//            recipes = recipeRepository.findAll();
//        } else {
//            recipes = RecipeData.findByColumnAndValue(searchType, searchTerm, recipeRepository.findAll());
//        }
//        model.addAttribute("columns", columnChoices);
//        model.addAttribute("title", "Recipes with " + columnChoices.get(searchType) + ": " + searchTerm);
//        model.addAttribute("recipes", recipes);
//
//        return "search";
//    }

    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam ArrayList<String> searchTerms) {

        Iterable<Recipe> recipes;
        if (searchTerms.isEmpty() || searchTerms.contains("all".toLowerCase())) {
            recipes = recipeRepository.findAll();
        } else {
            recipes = RecipeData.findByValue(searchTerms, recipeRepository.findAll());
        }

        model.addAttribute("title",
                "Recipe Names Containing '"
                        + searchTerms.toString()
                        .replace("[", "")
                        .replace("]", "")
                        .toLowerCase()
                        + "'");
        model.addAttribute("recipes", recipes);

        return "search";
    }
}
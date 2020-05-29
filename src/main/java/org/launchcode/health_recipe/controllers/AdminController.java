package org.launchcode.health_recipe.controllers;


import org.launchcode.health_recipe.models.Ingredient;
import org.launchcode.health_recipe.models.Recipe;
import org.launchcode.health_recipe.models.RecipeData;
import org.launchcode.health_recipe.models.User;
import org.launchcode.health_recipe.models.data.IngredientRepository;
import org.launchcode.health_recipe.models.data.RecipeRepository;
import org.launchcode.health_recipe.models.data.UserRepository;
import org.launchcode.health_recipe.models.dto.RegisterFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping
public class AdminController {

    @Autowired
    private RecipeRepository recipeRepository;

    private Recipe recipe;

    @Autowired
    private IngredientRepository ingredientRepository;

    private Ingredient ingredient;

    @Autowired
    private UserRepository userRepository;


    private User user;

    @Autowired
    RecipeController recipeController;

    @Autowired
    RecipeData recipeData;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public AdminController() {

        columnChoices.put("all", "All");
    }

    @GetMapping("admin-home")
    public String displayAdminHomePage(Model model) {
        model.addAttribute("title","Welcome Admin");
        return "/admin-home";
    }

    @RequestMapping("admin/list")
    public String list(Model model, Pageable page) {
        Page<Recipe> recipes;
        model.addAttribute("recipes", recipeData.findAllByPage(page));
        return "admin/list";
    }


    @RequestMapping(value = "admin/list/recipes")
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

        return "admin/list-recipes";
    }

    @RequestMapping("/admin/search")
    public String search(Model model) {

        return "admin/search";
    }

    @PostMapping("/admin/search/results")
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

        return "admin/search";
    }

    @GetMapping("/admin/add-admin_user")
    public String displayAdminRegistrationForm(Model model) {
        model.addAttribute(new RegisterFormDTO());
        model.addAttribute("title", "Register");
        return "admin/add-admin_user";
    }

    @PostMapping("/admin/add-admin_user")
    public String processAdminRegistrationForm(@ModelAttribute @Valid RegisterFormDTO registerFormDTO,
                                               Errors errors, HttpServletRequest request,
                                               Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Register");
            return "admin/add-admin_user";
        }

        User existingUser = userRepository.findByUsername(registerFormDTO.getUsername());

        if (existingUser != null) {
            errors.rejectValue("username", "username.alreadyexists",
                    "A user with that username already exists");
            model.addAttribute("title", "Register");
            return "admin/add-admin_user";
        }

        String password = registerFormDTO.getPassword();
        String verifyPassword = registerFormDTO.getVerifyPassword();
        if (!password.equals(verifyPassword)) {
            errors.rejectValue("password", "passwords.mismatch", "Passwords do not match");
            model.addAttribute("title", "Register");
            return "admin/add-admin_user";
        }

        User newUser = new User(registerFormDTO.getName(), registerFormDTO.getEmail(), registerFormDTO.getUsername(),
                registerFormDTO.getPassword(), registerFormDTO.getAccess());

        newUser.setAccess(1);
        userRepository.save(newUser);
        return "redirect:/admin-home";
    }

//    @GetMapping("add_ingredient")
//    public String displayAddIngredientForm(Model model) {
//        model.addAttribute(new Ingredient());
//        return "add_ingredient";
//    }
//
//    @PostMapping("add_ingredient")
//    public String processAddIngredientForm(@ModelAttribute @Valid Ingredient ingredient,
//                                           Errors errors, Model model) {
//
//
//        if (errors.hasErrors()) {
//            return "add_ingredient";
//        }
//
//        ingredientRepository.save(ingredient);
//        return "redirect:/admin-home";
//    }


}

// LisaFix13 push 05/29/2020
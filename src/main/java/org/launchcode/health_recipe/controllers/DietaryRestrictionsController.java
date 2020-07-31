package org.launchcode.health_recipe.controllers;

import org.launchcode.health_recipe.models.*;
import org.launchcode.health_recipe.models.data.DietaryRestrictionsRepository;
//import org.launchcode.health_recipe.models.data.UserPreferenceRepository;
//import org.launchcode.health_recipe.models.data.UserPreferenceRepository;
import org.launchcode.health_recipe.models.data.UserPreferenceRepository;
import org.launchcode.health_recipe.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;


@Controller
public class DietaryRestrictionsController {


    @Autowired
    private DietaryRestrictionsRepository dietaryRestrictionsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPreferenceRepository userPreferenceRepository;

    private static final String drsSessionKey = "user";



        @GetMapping
        public String displayAllRestrictions (Model model){
            model.addAttribute("dietaryRestrictionsSearch", new DietaryRestrictionsSearch());
            model.addAttribute("title", "All Restrictions");
            model.addAttribute("restrictions", dietaryRestrictionsRepository.findAll());
            model.addAttribute("Title", "All Health Conditions");
            model.addAttribute("health_conds", dietaryRestrictionsRepository.findAll());
            model.addAttribute("Title", "All Ingredient Search");
            model.addAttribute("ingred_search", dietaryRestrictionsRepository.findAll());
            model.addAttribute("Title", "All Cooking Time");
            model.addAttribute("cook_time", dietaryRestrictionsRepository.findAll());
            return "/selection";
        }

        @RequestMapping(value = "/selection", method = RequestMethod.POST)
        public String processUserDietaryRestrictions (@ModelAttribute @Valid UserPreference newUserPreference,
                 Errors errors, Model model, HttpSession session, User user,
                 @RequestParam(required=false) List<Integer> dietaryrestrictionssearches) {


            if (dietaryrestrictionssearches != null) {
                Integer userId = (Integer) session.getAttribute(drsSessionKey);
                newUserPreference.setUsersId(userId);

                List<DietaryRestrictionsSearch> restObjs = (List<DietaryRestrictionsSearch>) dietaryRestrictionsRepository.findAllById(dietaryrestrictionssearches);

                if (!restObjs.isEmpty()) {
                    newUserPreference.setDietaryrestrictionssearches(restObjs);
                }

                userPreferenceRepository.save(newUserPreference);
                return "redirect:/list";
            }
            return "redirect:/list";
        }
}












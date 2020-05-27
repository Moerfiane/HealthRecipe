package org.launchcode.health_recipe.controllers;

import org.launchcode.health_recipe.models.*;
import org.launchcode.health_recipe.models.data.DietaryRestrictionsRepository;
import org.launchcode.health_recipe.models.data.UserPreferenceRepository;
import org.launchcode.health_recipe.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
    public String displayAllRestrictions(Model model) {
        model.addAttribute("dietaryRestrictionsSearch", new DietaryRestrictionsSearch());
        model.addAttribute("title", "All Restrictions");
        model.addAttribute("restrictions", dietaryRestrictionsRepository.findAll());
        return "/selection";
    }

    @RequestMapping(value = "/selection", method = RequestMethod.POST)
    public String processUserDietaryRestrictions(@ModelAttribute @Valid UserPreference newUserPreference,
                                                 Errors errors, Model model,
                                                 HttpSession session, User user,
                                                 @RequestParam List<Integer> dietaryrestrictionssearches) {

        Integer userId = (Integer) session.getAttribute(drsSessionKey);
        newUserPreference.setUsersId(userId);

        List<DietaryRestrictionsSearch> restObjs = (List<DietaryRestrictionsSearch>) dietaryRestrictionsRepository.findAllById(dietaryrestrictionssearches);
        if (!restObjs.isEmpty()) {
            newUserPreference.setDietaryrestrictionssearches(restObjs);

        }

        userPreferenceRepository.save(newUserPreference);

        return "redirect:/list/";
    }


}







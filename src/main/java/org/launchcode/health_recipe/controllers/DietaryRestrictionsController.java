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

    @RequestMapping(value = "/add", method = RequestMethod.POST, params = {"restrict_id"})
    public String processUserDietaryRestrictions(@ModelAttribute @Valid UserPreference newUserPreference,
                                                 Errors errors, Model model,
                                                 HttpSession session, User user,
                                                 @RequestParam Integer[] restrict_id) {



        Integer userId = (Integer) session.getAttribute(drsSessionKey);
        Optional<User> userObj = userRepository.findById(userId);
        if (userObj.isPresent()) {
            User user1 = userObj.get();
            newUserPreference.setUsersId(userId);
        }

        Integer[] drsObj = restrict_id;
        Integer[] preferenceId = drsObj;
        newUserPreference.getPreferenceId();
        newUserPreference.setPreferenceId(preferenceId);

        userPreferenceRepository.save(newUserPreference);


        return "redirect:/list/";
    }


}







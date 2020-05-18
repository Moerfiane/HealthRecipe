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
import java.util.List;
import java.util.Optional;


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
                                                 @RequestParam List<Integer> restrict_id) {

        Integer userId = (Integer) session.getAttribute(drsSessionKey);
        Optional<User> userObj = userRepository.findById(userId);
        User myUser = userObj.get();
        newUserPreference.setUsersId(userId);


        List<DietaryRestrictionsSearch> drsObj = (List<DietaryRestrictionsSearch>) dietaryRestrictionsRepository.findAllById(restrict_id);
        if (!drsObj.isEmpty()) {
            System.out.println(drsObj);

        }

        return "redirect:/list/";

    }
}






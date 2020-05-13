package org.launchcode.health_recipe.controllers;

import org.hibernate.criterion.Restrictions;
import org.launchcode.health_recipe.models.*;
import org.launchcode.health_recipe.models.data.DietaryRestrictionsRepository;
import org.launchcode.health_recipe.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class DietaryRestrictionsController {


    @Autowired
    private DietaryRestrictionsRepository dietaryRestrictionsRepository;

    @Autowired
    private UserRepository userRepository;


    @GetMapping
    public String displayAllRestrictions(Model model) {
        model.addAttribute("dietaryRestrictionsSearch", new DietaryRestrictionsSearch());
        model.addAttribute("title", "All Restrictions");
        model.addAttribute("restrictions", dietaryRestrictionsRepository.findAll());
        return "/selection";
    }

    @RequestMapping(value="/add",method=RequestMethod.POST, params = {"dietaryrestrictionssearches"})
    public String processUserDietaryRestrictions(@ModelAttribute @Valid User newUser,
                                    @RequestParam List<Integer> dietaryrestrictionssearches,
                                    Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "AddUserRestriction");
            return "add";
        }

        if (!dietaryrestrictionssearches.isEmpty()) {

            List<DietaryRestrictionsSearch> drsObjs = (List<DietaryRestrictionsSearch>) dietaryRestrictionsRepository.findAllById(dietaryrestrictionssearches);
            if (!drsObjs.isEmpty()) {
                newUser.setDietaryrestrictionssearches(drsObjs);
            }
            userRepository.save(newUser);
            return "redirect:/view/" + newUser.getId();
        }
        return "redirect:../add";
    }






    }



package org.launchcode.health_recipe.controllers;

import org.hibernate.criterion.Restrictions;
import org.launchcode.health_recipe.models.*;
import org.launchcode.health_recipe.models.data.DietaryRestrictionsRepository;
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

//    @Autowired
//    private UserRestrictions userRestrictions;



    @GetMapping
    public String displayAllRestrictions(Model model) {
        model.addAttribute("dietaryRestrictionsSearch", new DietaryRestrictionsSearch());
        model.addAttribute("title", "All Restrictions");
        model.addAttribute("restrictions", dietaryRestrictionsRepository.findAll());
        return "/selection";
    }

//    @RequestMapping(value = "/save/{restrict_id}", method = RequestMethod.POST)
//    public String selectedCheckboxes(@ModelAttribute @Valid DietaryRestrictionsSearch newDietaryRestrictionsSearch,
//            @RequestParam Integer restrict_id,  Errors errors, Model model) {
//
//        if (errors.hasErrors()) {
//            model.addAttribute("restrict_id", restrict_id);
//            model.addAttribute("DietaryRestrictionsSearch", dietaryRestrictionsRepository.findById(restrict_id));
//            return "/list";
//        }
//        newDietaryRestrictionsSearch.getRestrict_id();
//        dietaryRestrictionsRepository.save(newDietaryRestrictionsSearch);
//        return "/list";
//    }


    @RequestMapping(value = "/savecheckboxes", method = RequestMethod.POST)
    public String selectedCheckboxes(Model model, Integer restrict_id, Integer checked_id) {

        model.addAttribute("dietaryRestrictionsSearch", new DietaryRestrictionsSearch());
        model.addAttribute("userRestrictions", new UserRestrictions());
        model.addAttribute("restrict_id", restrict_id);
        model.addAttribute("checked_id", checked_id);

        checked_id.equals(new DietaryRestrictionsSearch().getRestrict_id());
        UserRestrictions userrestrict = new UserRestrictions();
        userrestrict.getChecked_id();
        return "checked_id";

//        List selectedCheckboxes = dietaryRestrictionsRepository.findById(restrict_id);
//
//        if (selectedCheckboxes.contains(restrict_id)) {
//            DietaryRestrictionsSearch dietaryRestrictionsSearch = (DietaryRestrictionsSearch) selectedCheckboxes.get(restrict_id);
//            dietaryRestrictionsRepository.save(dietaryRestrictionsSearch);
//
//       }


    }



}
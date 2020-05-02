package org.launchcode.health_recipe.controllers;

import org.launchcode.health_recipe.models.*;
import org.launchcode.health_recipe.models.data.DietaryRestrictionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DietaryRestrictionsController {



    @Autowired
    private DietaryRestrictionsRepository dietaryRestrictionsRepository;


//    public void setDietaryRestrictionsRepository(DietaryRestrictionsRepository dietaryRestrictionsRepository) {
//        this.dietaryRestrictionsRepository = dietaryRestrictionsRepository;
//    }

    @GetMapping
    public String displayAllRestrictions(Model model) {
        model.addAttribute("title", "All Restrictions");
        model.addAttribute("restrictions", dietaryRestrictionsRepository.findAll());
        return "/selection";
    }
  @RequestMapping(value = "", method = RequestMethod.POST )
    public String selectedCheckboxes(@ModelAttribute("dietaryRestrictionsSearch") DietaryRestrictionsSearch dietaryRestrictionsSearch) {

        return "";
    }


}



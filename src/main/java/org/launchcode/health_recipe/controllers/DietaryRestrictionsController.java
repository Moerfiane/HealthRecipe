package org.launchcode.health_recipe.controllers;

import org.hibernate.criterion.Restrictions;
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
import java.util.Optional;

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
  @PostMapping("update")
    public String selectedCheckboxes(Integer restrict_id, boolean active) {
        Optional restrict_idBeingUpdated = dietaryRestrictionsRepository.findById(restrict_id);
          if (restrict_idBeingUpdated.isPresent()) {
              DietaryRestrictionsSearch dietaryRestrictionsSearch = (DietaryRestrictionsSearch) restrict_idBeingUpdated.get();
              dietaryRestrictionsRepository.save(dietaryRestrictionsSearch);
          }

        return "redirect:../";
    }


}



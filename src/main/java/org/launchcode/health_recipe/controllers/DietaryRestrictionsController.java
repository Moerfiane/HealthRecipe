package org.launchcode.health_recipe.controllers;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.hibernate.criterion.Restrictions;
import org.launchcode.health_recipe.models.*;
import org.launchcode.health_recipe.models.data.DietaryRestrictionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Controller
public class DietaryRestrictionsController {

//    @Autowired
//    UserRestrictions userRestrictions;

    @Autowired
    private DietaryRestrictionsRepository dietaryRestrictionsRepository;

//    static HashMap<String, String> columnChoices = new HashMap<>();

//    public DietaryRestrictionsController() {
//        columnChoices.put("all", "All");
//    }

    public void setDietaryRestrictionsRepository(DietaryRestrictionsRepository dietaryRestrictionsRepository) {
        this.dietaryRestrictionsRepository = dietaryRestrictionsRepository;
    }

    @GetMapping
    public String displayAllRestrictions(Model model) {
        model.addAttribute("title", "All Restrictions");
        model.addAttribute("restrictions", dietaryRestrictionsRepository.findAll());
        return "/selection";
    }
//    @RequestMapping(method = RequestMethod.POST)
    @PostMapping("checkboxSelectedValues")
    public String postCheckboxSelectedValues( Model model) {
            model.addAttribute("checkboxSelectedValues", dietaryRestrictionsRepository);

        return "checkboxSelectedValues";
    }
//    @RequestMapping(value = "restrictions", method = RequestMethod.POST)
//    public String addSave(Model model, @RequestParam("restrict_id") Integer restrict_id) {
//        model.addAttribute("restrict_id", dietaryRestrictionsRepository.findAll());
//        return "restrict_id";
//    }

}

//    @RequestMapping(value = "restrictions")
//    public String listRestrictions(Model model, @RequestParam String column,
//                                     @RequestParam ArrayList<String> value) {
//        Iterable<DietaryRestrictionsSearch> restrictions;
//        if (column.toLowerCase().equals("all")){
//            restrictions = dietaryRestrictionsRepository.findAll();
//            model.addAttribute("title", "All restrictions");
//        } else {
//            restrictions = UserRestrictions.findByColumnAndValue(column, value, dietaryRestrictionsRepository.findAll());
//            model.addAttribute("title", "DietaryRestrictionsSearch value");
//        }
//        model.addAttribute("restrictions", restrictions);
//        System.out.println(restrictions);
//        return "selection";
//    }


//    @RequestMapping("")
//    public String listRestrictions(Model model) {
//       model.addAttribute("restrictions", userRestrictions.findAll());
//
//        return "";
//
//   }



//
//@Controller
//@RequestMapping(value="/index")
//public class DietaryRestrictionsController {
//
//    @Autowired
//    UserRestrictions userRestrictions;
//
//    @Autowired
//    DietaryRestrictionsSearch dietaryRestrictionsSearch;
//
//    @Autowired
//    private DietaryRestrictionsRepository dietaryRestrictionsRepository;
//
//
//    @RequestMapping("index")
//     public String displayAllRestrictions(Model model) {
//        String restrictions = dietaryRestrictionsSearch.getRestrictions();
//     model.addAttribute("restrictions", restrictions);
//        return "index";
//   }
//
//}

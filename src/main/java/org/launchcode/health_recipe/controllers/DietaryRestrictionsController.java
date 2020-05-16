package org.launchcode.health_recipe.controllers;

import org.launchcode.health_recipe.models.*;
import org.launchcode.health_recipe.models.data.DietaryRestrictionsRepository;
import org.launchcode.health_recipe.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;


@Controller
public class DietaryRestrictionsController {


    @Autowired
    private DietaryRestrictionsRepository dietaryRestrictionsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    AuthenticationController authenticationController;

    public void SecurityContextHolder() {}

    @GetMapping
    public String displayAllRestrictions(Model model) {
        model.addAttribute("dietaryRestrictionsSearch", new DietaryRestrictionsSearch());
        model.addAttribute("title", "All Restrictions");
        model.addAttribute("restrictions", dietaryRestrictionsRepository.findAll());
        return "/selection";
    }
//    private static String userSessionKey = "user";
//    public User getUserFromSession(HttpSession session) {
//        Integer userId = (Integer) session.getAttribute(userSessionKey);
//        if (userId == null) {
//            return null;
//        }
//
//        Optional<User> user = userRepository.findById(userId);
//
//        if (user.isEmpty()) {
//            return null;
//        }
//
//
//        return user.get();
//    }

//    private static void setUserInSession(HttpSession session, User user) {
//        session.setAttribute(userSessionKey, user.getId());
//    }




    @RequestMapping(value="/add",method=RequestMethod.POST, params = {"restrict_id"})
    public String processUserDietaryRestrictions(@ModelAttribute @Valid DietaryRestrictionsSearch newDRS,
                                                 Errors errors, Model model, HttpServletRequest request,
                                                 @RequestParam int restrict_id, Principal principal) {



        HttpSession session= request.getSession();
        User user= authenticationController.getUserFromSession(session);
        request.getSession().setAttribute("id", user.getId());



        DietaryRestrictionsSearch dietaryRestrictionsSearch = dietaryRestrictionsRepository.findById(restrict_id).orElse(newDRS);
        newDRS.getRestrict_id();
        dietaryRestrictionsRepository.save(newDRS);


        return "/list";
    }



}




package org.launchcode.health_recipe;

import org.launchcode.health_recipe.controllers.AuthenticationController;
import org.launchcode.health_recipe.models.User;
import org.launchcode.health_recipe.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuthenticationFilter extends HandlerInterceptorAdapter {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationController authenticationController;

    //In the constructor on the next line below is where any whitelisted paths are suppose to go:
    private static final List<String> whitelist = Arrays.asList("/list/recipe","/list-recipes","/search",
            "/view","/adminregister", "/list","/login", "/register", "/logout", "/css", "/selection");

    private static boolean isWhitelisted(String path) {
        for (String pathRoot : whitelist) {
            if (path.startsWith(pathRoot)) {
                return true;
            }
        }
        return false;
    }

    //Doesn't Require Sign In for whitelisted pages
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws IOException{

        if (isWhitelisted(request.getRequestURI())) {
            //Returning "true"
            return true;
        }
        HttpSession session= request.getSession();
        User user= authenticationController.getUserFromSession(session);

        //The user is logged in
        if (user != null) {
            return true;
        }

        //The user is not logged in, this statement below redirects the user to the specified path stated in the ("/path)
        response.sendRedirect("/login");
        return true;

    }
}

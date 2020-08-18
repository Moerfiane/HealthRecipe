package org.launchcode.health_recipe.models;

import org.launchcode.health_recipe.models.data.IngredientRepository;
import org.launchcode.health_recipe.models.data.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// This is a change made in sandbox.

/**
 * Created by LaunchCode
 */
@Service
public class RecipeData {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    /**
     * Returns pageable list of Recipes
     */

    public List<Recipe> getAllRecipe() {
        List<Recipe> allRecipe = new ArrayList<>();

        recipeRepository.findAll().forEach(allRecipe :: add);
        return allRecipe;
    }
    public Page<Recipe> findAllByPage(Pageable pageable) {
        return recipeRepository.findAll(pageable);
    }

    /**
     * Returns the results of searching the Recipes data by field and search term.
     *
     * For example, searching for ingredient "Broccoli" will include results
     * with "Healthified Broccoli Cheddar Soup".
     *
     * @param column Recipe field that should be searched.
     * @param allValues Values of the field to search for.
     * @param allRecipes The list of recipes to search.
     * @return List of all recipes matching the criteria.
     */
    public static ArrayList<Recipe> findByColumnAndValue(String column, ArrayList<String> allValues,
                                                         Iterable<Recipe> allRecipes) {

        ArrayList<Recipe> results = new ArrayList<>();

        if (allValues.contains("all".toLowerCase())) {
            return (ArrayList<Recipe>) allRecipes;

        }

        if (column.equals("all")){
            results = findByValue(allValues, allRecipes);
            return results;
        }

        for (Recipe recipe : allRecipes) {
            for (String value : allValues) {
                String aValue = getFieldValue(recipe, column);

                if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                    results.add(recipe);
                }
            }
        }

        return results;

    }

    public static String getFieldValue(Recipe recipe, String fieldName){
        String theValue;
        if (fieldName.equals("name")){
            theValue = recipe.getRecipeName();
        } else {
            theValue = recipe.toString();
        }

        return theValue;
    }

    /**
     * Search all Recipe fields for the given term.
     *
     * @param allValues The search terms to look for.
     * @param allRecipes The list of recipes to search.
     * @return      List of all recipes with at least one field containing the value.
     */
    public static ArrayList<Recipe> findByValue(ArrayList<String> allValues, Iterable<Recipe> allRecipes) {

        ArrayList<Recipe> results = new ArrayList<>();

        for (Recipe recipe : allRecipes) {
            for (String value : allValues) {
                if (recipe.getRecipeName().toLowerCase().contains(value.toLowerCase())) {
                    results.add(recipe);
                } else if (recipe.getIngredient().toString().toLowerCase().contains(value.toLowerCase())) {
                    results.add(recipe);
                } else if (recipe.toString().toLowerCase().contains(value.toLowerCase())) {
                    results.add(recipe);
                }
            }
        }
        return results;
    }



    /* old method */
//    public static ArrayList<Recipe> findByValue(String value, Iterable<Recipe> allRecipes) {
//
//        ArrayList<Recipe> results = new ArrayList<>();
//
//        for (Recipe recipes : allRecipes) {
//            if (recipes.getName().toLowerCase().contains(value.toLowerCase())) {
//                results.add(recipes);
//            } else if (recipes.toString().toLowerCase().contains(value.toLowerCase())) {
//                results.add(recipes);
//            }
//        }
//        return results;
//    }

}
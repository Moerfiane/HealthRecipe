package org.launchcode.health_recipe.models;

        import org.launchcode.health_recipe.models.data.IngredientRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.ArrayList;

@Service
public class IngredientData {

    @Autowired
    IngredientRepository ingredientRepository;
    
    /**
     * Returns the results of searching the Ingredients data by field and search term.
     *
     * For example, searching for ingredient "Broccoli" will include results
     * with "Healthified Broccoli Cheddar Soup".
     *
     * @param column Ingredient field that should be searched.
     * @param allValues Values of the field to search for.
     * @param allIngredients The list of ingredients to search.
     * @return List of all ingredients matching the criteria.
     */
    public static ArrayList<Ingredient> findByColumnAndValue(String column, ArrayList<String> allValues,
                                                         Iterable<Ingredient> allIngredients) {

        ArrayList<Ingredient> results = new ArrayList<>();

        if (allValues.contains("all".toLowerCase())) {
            return (ArrayList<Ingredient>) allIngredients;
        }

        if (column.equals("all")){
            results = findByValue(allValues, allIngredients);
            return results;
        }

        for (Ingredient ingredient : allIngredients) {
            for (String value : allValues) {
                String aValue = getFieldValue(ingredient, column);

                if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                    results.add(ingredient);
                }
            }
        }

        return results;

    }


    public static String getFieldValue(Ingredient ingredient, String fieldName){
        String theValue;
        if (fieldName.equals("name")){
            theValue = ingredient.getName();
        } else {
            theValue = ingredient.toString();
        }

        return theValue;
    }

    /**
     * Search all Ingredient fields for the given term.
     *
     * @param allValues The search terms to look for.
     * @param allIngredients The list of ingredients to search.
     * @return      List of all ingredients with at least one field containing the value.
     */
    public static ArrayList<Ingredient> findByValue(ArrayList<String> allValues, Iterable<Ingredient> allIngredients) {

        ArrayList<Ingredient> results = new ArrayList<>();

        for (Ingredient ingredient : allIngredients) {
            for (String value : allValues) {
                if (ingredient.getName().toLowerCase().contains(value.toLowerCase())) {
                    results.add(ingredient);
                } else if (ingredient.toString().toLowerCase().contains(value.toLowerCase())) {
                    results.add(ingredient);
                }
            }
        }
        return results;
    }

}
package org.launchcode.health_recipe.models.data;

import org.launchcode.health_recipe.models.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

//@Repository
//public interface RecipeRepository extends CrudRepository <Recipe, Integer>, PagingAndSortingRepository<Recipe, Integer> {
//    Page<Recipe> findAll(Pageable pageable);
//}

@Repository
public interface RecipeRepository extends PagingAndSortingRepository <Recipe, Integer> {
    Page<Recipe> findAll(Pageable pageable);
}

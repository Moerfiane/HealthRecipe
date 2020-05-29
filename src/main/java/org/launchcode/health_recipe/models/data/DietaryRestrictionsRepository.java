package org.launchcode.health_recipe.models.data;

import org.launchcode.health_recipe.models.DietaryRestrictionsSearch;
import org.launchcode.health_recipe.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;



@Repository
@Transactional
public interface DietaryRestrictionsRepository extends CrudRepository <DietaryRestrictionsSearch, Integer> {

}

// LisaFix13 push 05/29/2020
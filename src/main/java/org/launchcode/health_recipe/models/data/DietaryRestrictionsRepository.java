package org.launchcode.health_recipe.models.data;

import org.launchcode.health_recipe.models.DietaryRestrictionsSearch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


//
@Repository
@Transactional
public interface DietaryRestrictionsRepository extends CrudRepository <DietaryRestrictionsSearch, Integer> {


}
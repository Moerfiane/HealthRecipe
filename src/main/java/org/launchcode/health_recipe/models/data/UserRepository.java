package org.launchcode.health_recipe.models.data;

import org.launchcode.health_recipe.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository <User, Integer> {
    User findByUsername(String username);

}

// LisaFix13 push 05/29/2020

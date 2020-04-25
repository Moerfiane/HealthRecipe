package org.launchcode.health_recipe.models;


import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RestrictionsService {

    List<Restrictions> listAllRestrictions();

    Restrictions getRestrictionByValue(String restrictions);
}


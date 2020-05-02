package org.launchcode.health_recipe.models;

//import org.launchcode.health_recipe.models.data.DietaryRestrictionsRepository;
import org.hibernate.criterion.Restrictions;
import org.launchcode.health_recipe.models.data.DietaryRestrictionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="user_restrictions")
public class UserRestrictions {

    //these are table User_restrictions that keeps track of user choices from selection page.
//   id_from_user is the id assigned when user registers. user_restrict_id is auto generated.
//    nothing is saved if user does not register.

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "users_restrict_id")
    private int users_restrict_id;

    @Column(name = "id_from_user")
    private int id_from_user;


    @OneToMany(mappedBy = "userRestrictions", cascade = CascadeType.ALL)
//    private List<DietaryRestrictionsSearch> restrictions = new ArrayList<>();
    public  List<DietaryRestrictionsSearch> restrictions;

    public int getUsers_restrict_id() {
        return users_restrict_id;
    }

    public void setUsers_restrict_id(int users_restrict_id) {
        this.users_restrict_id = users_restrict_id;
    }

    public int getId_from_user() {
        return id_from_user;
    }

    public void setId_from_user(int id_from_user) {
        this.id_from_user = id_from_user;
    }

    public List<DietaryRestrictionsSearch> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(List<DietaryRestrictionsSearch> restrictions) {
        this.restrictions = restrictions;
    }
}


//@Service
//public class UserRestrictions {
//
//    @Autowired
//    private DietaryRestrictionsRepository dietaryRestrictionsRepository;
//
//   public List<Restrictions> listAllRestrictions() {
//        return null;
//    }
//
//    public List<DietaryRestrictionsSearch> findAll() {
//
//        return (List<DietaryRestrictionsSearch>) dietaryRestrictionsRepository.findAll();
//    }
//
//
//    public static ArrayList<DietaryRestrictionsSearch> findByColumnAndValue(String column, ArrayList<String> allValues,
//                                                         Iterable<DietaryRestrictionsSearch> allRestrictions) {
//
//        ArrayList<DietaryRestrictionsSearch> results = new ArrayList<>();
//
//        if (allValues.contains("all".toLowerCase())) {
//            return (ArrayList<DietaryRestrictionsSearch>) allRestrictions;
//        }
//
//        if (column.equals("all")){
//            results = findByValue(allValues, allRestrictions);
//            return results;
//        }
//
//        for (DietaryRestrictionsSearch restrictions : allRestrictions) {
//            for (String value : allValues) {
//                String aValue = getFieldValue(restrictions, column);
//
//                if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
//                    results.add(restrictions);
//                }
//            }
//        }
//
//        return results;
//
//    }
//    public static String getFieldValue(DietaryRestrictionsSearch restrictions, String fieldRestrictions){
//        String theValue;
//        if (fieldRestrictions.equals("restrictions")){
//            theValue = restrictions.getRestrictions();
//        } else {
//            theValue = restrictions.toString();
//        }
//
//        return theValue;
//    }
//    public static ArrayList<DietaryRestrictionsSearch> findByValue(ArrayList<String> allValues, Iterable<DietaryRestrictionsSearch> allRestrictions) {
//
//        ArrayList<DietaryRestrictionsSearch> results = new ArrayList<>();
//
//        for (DietaryRestrictionsSearch restrictions : allRestrictions) {
//            for (String value : allValues) {
//                if (restrictions.getRestrictions().toLowerCase().contains(value.toLowerCase())) {
//                    results.add(restrictions);
//                } else if (restrictions.toString().toLowerCase().contains(value.toLowerCase())) {
//                    results.add(restrictions);
//                }
//            }
//        }
//        return results;
//    }
//
//
//}
//
////
////@Entity
////@Table(name="user_restrictions")
////@Embeddable
////public class UserRestrictions implements Serializable {
////
//////these are table User_restrictions that keeps track of user choices from selection page.
//////    id_from_user is the id assigned when user registers. user_restrict_id is auto generated.
//////    nothing is saved if user does not register.
////
////    @Id
////    @GeneratedValue(strategy = GenerationType.AUTO)
////    @Column(name = "users_restrict_id")
////    private int users_restrict_id;
////
////    @Column(name = "id_from_user")
////    @Embedded
////    private int id_from_user;
////
//////    @OneToMany(targetEntity = DietaryRestrictionsSearch.class, mappedBy = "user_Restrictions", cascade = CascadeType.ALL)
//////     @JoinTable(name = "dietary_restrictions_search", joinColumns={@JoinColumn(name="restrict_id", referencedColumnName = "user_restrict_id")}
//////     )
//////    private List<DietaryRestrictionsSearch> dietaryRestrictionsSearches;
//////    public List<DietaryRestrictionsSearch> dietaryRestrictionsSearches = new ArrayList<>();
////
////    public UserRestrictions(Integer users_restrict_id, Integer id_from_user) {
////        super();
////        this.users_restrict_id = users_restrict_id;
////        this.id_from_user = id_from_user;
////    }
////
////
////    public int getUser_restrict_id() {
////        return users_restrict_id;
////    }
////
////    public void setUser_restrict_id(int user_restrict_id) {
////        this.users_restrict_id = user_restrict_id;
////    }
////
////    public int getId_from_user() {
////        return id_from_user;
////    }
////
////    public void setId_from_user(int id_from_user) {
////        this.id_from_user = id_from_user;
////    }
////
//////    public List<DietaryRestrictionsSearch> getDietaryRestrictionsSearch() {
//////        return dietaryRestrictionsSearches;
//////    }
//////    public void setDietaryRestrictionsSearch(List<DietaryRestrictionsSearch> dietaryRestrictionsSearch) {
//////        this.dietaryRestrictionsSearches = dietaryRestrictionsSearch;
//////    }
////
////
////}
//

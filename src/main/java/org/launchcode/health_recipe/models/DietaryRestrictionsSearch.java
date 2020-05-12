package org.launchcode.health_recipe.models;

import org.launchcode.health_recipe.Health_RecipeApplication;
import org.launchcode.health_recipe.models.data.DietaryRestrictionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import javax.persistence.*;
import java.io.Serializable;

import java.sql.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name= "dietary_restrictions_search")
@SecondaryTable(name= "user_restrictions")
public class DietaryRestrictionsSearch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int restrict_id;

    @Column
    private String restrictions;

    private boolean active;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="checked_id")
//    private UserRestrictions userRestrictions;
//     private List<UserRestrictions> userRestrictions;

    public DietaryRestrictionsSearch() {}


    public DietaryRestrictionsSearch(int restrict_id, String restrictions, boolean active ) {
        this.restrict_id = restrict_id;
        this.restrictions = restrictions;
        this.active = active;
    }

    public int getRestrict_id() {
        return restrict_id;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }




    public boolean isActive() {
        return active;
    }

//    public UserRestrictions getUserRestrictions() {
//        return userRestrictions;
//    }
//
//    public void setUserRestrictions(UserRestrictions userRestrictions) {
//        this.userRestrictions = userRestrictions;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DietaryRestrictionsSearch)) return false;
        DietaryRestrictionsSearch that = (DietaryRestrictionsSearch) o;
        return getRestrict_id() == that.getRestrict_id() &&
                getRestrictions().equals(that.getRestrictions());
    }

    @Override
    public String toString() {
        return "DietaryRestrictionsSearch{" +
                "restrict_id=" + restrict_id +
                ", restrictions='" + restrictions + '\'' +
                '}';
    }
}

//@Entity
//@Table(name="dietary_restrictions_search")
//public class DietaryRestrictionsSearch implements Serializable {
//
//    @Autowired
//    DietaryRestrictionsRepository dietaryRestrictionsRepository;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "restrict_id")
//     private int restrict_id;
//
//    @Column(name = "restrictions")
//    private String restrictions;
//
//    @ManyToOne(fetch = FetchType.LAZY)
////    @JoinColumn(name="restrict_id", referencedColumnName="users_restrict_id")
////    @JoinColumns({
////            @JoinColumn(name = "restrictions", referencedColumnName = "users_restrict_id");
////            @JoinColumn(name = "id_from_user", referencedColumnName = "id")
////    })
////    @JoinTable(name = "user_restrictions", joinColumns={@JoinColumn(name="restrict_id", referencedColumnName = "users_restrict_id")}
////     )
//    private UserRestrictions userRestrictions;
//
//
//    public DietaryRestrictionsSearch() {}
//
//
//    public UserRestrictions getUserRestrictions() {
//        return userRestrictions;
//    }
//
//    public void setUserRestrictions(UserRestrictions userRestrictions) {
//        this.userRestrictions = userRestrictions;
//    }
//
//    public int getRestrict_id() {
//        return restrict_id;
//    }
//
//    public void setRestrict_id(int restrict_id) {
//        this.restrict_id = restrict_id;
//    }
//
//    public String getRestrictions() {
//        return restrictions;
//    }
//
//    public void setRestrictions(String restrictions) {
//        this.restrictions = restrictions;
//    }
//
//
//
//    @Override
//    public String toString() {
//        return "DietaryRestrictionsSearch{" +
//                "restrict_id=" + restrict_id +
//                ", restrictions='" + restrictions + '\'' +
//                ", Restrictions=" + restrictions +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof DietaryRestrictionsSearch)) return false;
//        if (!super.equals(o)) return false;
//        DietaryRestrictionsSearch that = (DietaryRestrictionsSearch) o;
//        return getRestrict_id() == that.getRestrict_id() &&
//                Objects.equals(getRestrictions(), that.getRestrictions()) &&
//                Objects.equals(getRestrictions(), that.getRestrictions());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(super.hashCode(), getRestrict_id(), getRestrictions(), getRestrictions());
//    }
//}

package org.launchcode.health_recipe.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@MappedSuperclass
public abstract class AbstractEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @NotBlank
//    @Size(max = 150)
//    private String name;

    public int getId() {
        return id;
    }


    public AbstractEntity() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }



}
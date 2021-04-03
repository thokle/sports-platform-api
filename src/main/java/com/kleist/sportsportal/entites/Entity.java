package com.kleist.sportsportal.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;


public abstract class Entity  {

    @Id
    @JsonProperty("id")
    @GeneratedValue
    private Long id;

    public Entity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || id == null || getClass() != obj.getClass()) return false;
        Entity entity = (Entity) obj;

        if(!id.equals(entity.getId()))return false;

        return true;


    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

}

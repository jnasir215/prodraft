package com.codedifferently.prodraft.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "prospects")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Prospect {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private String id;

    //@Column(name = "name")
    @JsonProperty("name")
    private String name;

    //@Column(name = "position")
    @JsonProperty("position")
    private String position;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}

package com.codedifferently.prodraft.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "market")
    private String market;

    @Column(name = "alias")
    @JsonProperty("alias")
    private String alias;

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

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}



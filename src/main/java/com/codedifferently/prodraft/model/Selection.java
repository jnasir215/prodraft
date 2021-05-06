package com.codedifferently.prodraft.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Selection {

    @JsonProperty("id")
    private String id;

    @JsonProperty("number")
    private String pick;

    @JsonProperty("team")
    private Team team;

    @JsonProperty("prospect")
    private Prospect prospect;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPick() {
        return pick;
    }

    public void setPick(String pick) {
        this.pick = pick;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Prospect getProspect() {
        return prospect;
    }

    public void setProspect(Prospect prospect) {
        this.prospect = prospect;
    }
}

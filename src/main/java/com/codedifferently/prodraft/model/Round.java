package com.codedifferently.prodraft.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Round {

    @JsonProperty("id")
    private String id;

    @JsonProperty("number")
    private String number;

    @JsonProperty("picks")
    private Selection[] picks;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Selection[] getPicks() {
        return picks;
    }

    public void setPicks(Selection[] picks) {
        this.picks = picks;
    }
}

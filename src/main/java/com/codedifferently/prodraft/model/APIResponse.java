package com.codedifferently.prodraft.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class APIResponse {

    @JsonProperty("draft")
    private Draft draft;

    @JsonProperty("rounds")
    private Round[] rounds;

    public Draft getDraft() {
        return draft;
    }

    public void setDraft(Draft draft) {
        this.draft = draft;
    }

    public Round[] getRounds() {
        return rounds;
    }

    public void setRounds(Round[] rounds) {
        this.rounds = rounds;
    }
}

package com.codedifferently.prodraft.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="draft")
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonRootName(value="draft")
public class Draft {

    @Id
    @JsonProperty("id")
    private String id;

    //@Column(name="year")
    @JsonProperty("year")
    private String year;

    //@Column(name="status")
    @JsonProperty("status")
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

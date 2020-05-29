package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Entity
public class Subtask {

    @NotEmpty
    private String name;
    @Id
    @GeneratedValue
    UUID id;
    @NotEmpty
    String description;

    public Subtask(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Subtask create(String name, String description){
        Subtask subtask = new Subtask();
        subtask.setName(name);
        subtask.setDescription(description);
        return subtask;
    }
}

package com.example.demo.dto;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

public class SubtaskDTO {

    @NotEmpty
    private String name;
    private UUID id;
    @NotEmpty
    private String description;

    public SubtaskDTO(){

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

}

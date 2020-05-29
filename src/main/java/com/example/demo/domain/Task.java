package com.example.demo.domain;

import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
public class Task {

    @NotEmpty
    String name;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    LocalDateTime dateTime;

    @Id
    @GeneratedValue
    UUID id;

    @NotEmpty
    String description;

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    private List<Subtask> subtasks;

    public Task(String name, LocalDateTime dateTime, UUID id, String description) {
        setName(name);
        setDateTime(dateTime);
        setId(id);
        setDescription(description);

    }

    public Task(){

    }
    public List<Subtask> getSubtasks() {
        return this.subtasks;
    }

    public void setSubtasks(ArrayList<Subtask> subtasks) {
        this.subtasks = subtasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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

    public static Task create(String title, String description, LocalDateTime datetime, ArrayList<Subtask> subtasks){
        Task task = new Task();
        task.setName(title);
        task.setDescription(description);
        task.setDateTime(datetime);
        task.setSubtasks(subtasks);
        return task;
    }

    public void addSubtask(Subtask subtask){
        this.subtasks.add(subtask);
    }

}

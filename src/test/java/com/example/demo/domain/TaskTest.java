package com.example.demo.domain;

import com.example.demo.domain.Subtask;
import com.example.demo.domain.Task;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;




@SpringBootTest
public class TaskTest {

    @Test
    public void setterAndGetterTest() {
        Task task = new Task();
        task.setId(UUID.fromString("950889d8-b49d-4ce0-bcd0-228a2086b889"));
        task.setName("title");
        task.setDescription("description");
        Subtask subtask = new Subtask();
        subtask.setName("subname");
        subtask.setDescription("subdescrip");
        subtask.setId(UUID.randomUUID());
        LocalDateTime date_time = LocalDateTime.now();
        task.setDateTime(date_time);
        ArrayList subtasks = new ArrayList<Subtask>();
        task.setSubtasks(subtasks);
        task.addSubtask(subtask);

        assertNotNull(task);
        assertEquals(UUID.fromString("950889d8-b49d-4ce0-bcd0-228a2086b889"), task.getId());
        assertEquals("title", task.getName());
        assertEquals("description", task.getDescription());
        assertEquals(date_time, task.getDateTime());
        assertEquals(subtasks, task.getSubtasks());
    }

    @Test
    public void Constructortest() {
        LocalDateTime date_time = LocalDateTime.now();
        Task task = new Task("title", date_time,  UUID.fromString("950889d8-b49d-4ce0-bcd0-228a2086b889") , "description", new ArrayList<Subtask>());



        assertNotNull(task);
        assertEquals(UUID.fromString("950889d8-b49d-4ce0-bcd0-228a2086b889"), task.getId());
        assertEquals("title", task.getName());
        assertEquals("description", task.getDescription());
        assertEquals(date_time, task.getDateTime());
    }




}
package com.example.demo.service;

import com.example.demo.dto.SubtaskDTO;
import com.example.demo.dto.TaskDTO;
import com.example.demo.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class TaskServiceimplTest {

    @Autowired
    private TaskService taskservice;

    @Test
    @Transactional
    public void addTaskTest(){
        SubtaskDTO subtask = new SubtaskDTO();
        List<SubtaskDTO> subtasks = new ArrayList<>();
        subtasks.add(subtask);

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setDescription("Description");
        taskDTO.setName("Title");
        taskDTO.setId(UUID.fromString("950779d8-b49d-4ce0-bcd0-228a2086b889"));
        taskDTO.setDateTime(LocalDateTime.of(2020,5,31,19,53));
        taskDTO.setSubtasks(subtasks);

        this.taskservice.addTask(taskDTO);

        List<TaskDTO> tasks = this.taskservice.getTasks();

        assertNotNull(tasks);
        assertFalse(tasks.isEmpty());
        TaskDTO first_task = tasks.get(0);
        TaskDTO taskdto = tasks.get(1);
        assertEquals(taskdto.getName(), taskDTO.getName());
        assertEquals(taskdto.getDescription(), taskDTO.getDescription());
        assertEquals(taskdto.getDateTime(), taskDTO.getDateTime());
        assertEquals(first_task.getName(), "Test_Title");
        assertEquals(first_task.getDescription(), "Test_Description");
        assertEquals(first_task.getDateTime(), LocalDateTime.of(2020, 05, 31, 11, 28));
        assertEquals(tasks.size(), 2);
    }

    @Test
    @Transactional
    public void addSubtask(){
        SubtaskDTO subtask = new SubtaskDTO();
        subtask.setName("Name");
        subtask.setDescription("Description");
        List<SubtaskDTO> subtasks = new ArrayList<>();
        subtasks.add(subtask);

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setDescription("Description");
        taskDTO.setName("Title");
        taskDTO.setId(UUID.fromString("950779d8-b49d-4ce0-bcd0-228a2086b889"));
        taskDTO.setDateTime(LocalDateTime.of(2020,5,31,19,53));
        taskDTO.setSubtasks(subtasks);

        this.taskservice.addTask(taskDTO);

        List<TaskDTO> tasks = this.taskservice.getTasks();

        assertEquals(1, taskDTO.getSubtasks().size());

    }

    @Test
    @Transactional
    public void deleteTaskTest(){
        SubtaskDTO sub = new SubtaskDTO();
        List<SubtaskDTO> subtasks = new ArrayList<>();
        subtasks.add(sub);

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setDescription("Description");
        taskDTO.setName("Title");
        taskDTO.setId(UUID.randomUUID());
        taskDTO.setDateTime(LocalDateTime.of(2020,5,31,20,33));
        taskDTO.setSubtasks(subtasks);

        this.taskservice.addTask(taskDTO);
        assertFalse(this.taskservice.getTasks().isEmpty());
        this.taskservice.deleteTask(this.taskservice.getTasks().get(1).getId());
        assertTrue(this.taskservice.getTasks().size() ==1);
    }

    @Test
    @Transactional
    public void getTaskByIdTest(){

        TaskDTO taskDTO1 = taskservice.getTaskById(taskservice.getTasks().get(0).getId());

        assertEquals(taskservice.getTasks().get(0).getName(), taskDTO1.getName());

    }




}